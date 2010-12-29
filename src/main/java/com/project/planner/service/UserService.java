package com.project.planner.service;

import org.eclipse.persistence.annotations.Property;
import org.springframework.beans.PropertyValues;
import org.springframework.stereotype.Service;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;

import com.project.planner.entity.User;

@Service
public class UserService {
	public void createUser() {
		Validator v = null;
//		v.validate(target, errors)
	}
}
