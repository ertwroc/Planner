package com.project.planner.controller.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

@Component
public class ErrorResolver {
	@Autowired
	private ReloadableResourceBundleMessageSource messages;
	/**
	 * Locale resolver used to get curent user locales.
	 */
	@Autowired
	private LocaleResolver localeResolver;
	
	public String getMessage(String code, Object...args){
		try {
			return messages.getMessage(code, args, null);//TODO
		} catch (NoSuchMessageException e) {
			return "__" + code + "__";
		}
	}
}
