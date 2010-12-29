package com.project.planner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.planner.model.NewUser;

@Controller
@RequestMapping("/user")
public class UserController {
	/**
	 * Render empty form for adding new user
	 * @return path to new user form
	 */
	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String create(){
		return "user/form";
	}
	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String createAction(@ModelAttribute NewUser user){
		return "user/form";
	}
}
