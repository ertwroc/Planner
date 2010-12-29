package com.project.planner.controller;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.project.planner.controller.error.ErrorCodeResolver;
import com.project.planner.controller.error.ErrorResolver;
import com.project.planner.entity.Project;

import static com.project.planner.utils.ControllerUtils.toPVS;

@Controller
@RequestMapping("/project")
public class ProjectController {
	private static final BiMap<String, String> requestToProject = HashBiMap.create();
	static {
		requestToProject.put("end_date", "endDate");
		requestToProject.put("desc", "description");
		requestToProject.put("start_date", "startDate");
	}
	@Autowired
	private ErrorResolver errorResolver;
	@Autowired
	private ErrorCodeResolver errorCodeResolver;
	/**
	 * Render empty form for adding new project
	 * @return path to new project form
	 */
	@RequestMapping(value = "new", method = RequestMethod.GET)
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("project/form");
		mav.addObject("error", new HashMap<String, String>());
		return mav;
	}
	/**
	 * Action adding new project
	 * 
	 * @return path to new project form
	 */
	@RequestMapping(value = "new", method = RequestMethod.POST)
	public ModelAndView createAction(@RequestParam HashMap<String, String> params){
		System.out.println(params);
		params.remove("owner");//TODO
		org.springframework.validation.DefaultMessageCodesResolver x;
		
		Project newProject = new Project();
		DataBinder binder = new DataBinder(newProject);
		binder.setIgnoreUnknownFields(false);
		binder.setMessageCodesResolver(errorCodeResolver);

		binder.bind(toPVS(params, requestToProject));
		BindingResult result = binder.getBindingResult();
//		List<FieldError> err = result.getFieldErrors();
//		List<ObjectError> err2 = result.getGlobalErrors();
//		for (FieldError fe : err) {
//			System.out.println("Args: " + Arrays.toString(fe.getArguments()));
//			System.out.println("Codes: " + Arrays.toString(fe.getCodes()));
//			System.out.println("Def. msg: " + fe.getDefaultMessage());
//			System.out.println("Field: " + fe.getField());
//			System.out.println("Object: " + fe.getObjectName());
//			System.out.println("Value: " + fe.getRejectedValue());
//			System.out.println("---");
//		}
//		System.out.println("---------");
//		for (ObjectError fe : err2) {
//			System.out.println("Args: " + Arrays.toString(fe.getArguments()));
//			System.out.println("Codes: " + Arrays.toString(fe.getCodes()));
//			System.out.println("Def. msg: " + fe.getDefaultMessage());
//			System.out.println("Object: " + fe.getObjectName());
//			System.out.println("---");
//		}
		
		
		Map<String, String> errors = new HashMap<String, String>();
		for (FieldError error : result.getFieldErrors()) {
			errors.put(requestToProject.inverse().get(error.getField()), errorResolver.getMessage(error.getCode()));
		}
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("project/form");
		mav.addAllObjects(params);
		mav.addObject("error", errors);
		return mav;
	}
}
