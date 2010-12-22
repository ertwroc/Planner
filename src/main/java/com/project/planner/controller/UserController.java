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
	 * Renderuje pusty formularz dodawania nowego uzytkownika
	 * @return adres formularza dodawania nowego uzytkownika
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
