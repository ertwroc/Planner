package com.project.planner.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

public class LocalizedMessagesInterceptor implements HandlerInterceptor {
	/**
	 * Name of variable in model allowing access to messages.
	 */
	public static final String MESSAGES_MODEL_NAME = "msg";
	@Autowired
	private ReloadableResourceBundleMessageSource messages;
	/**
	 * Locale resolver used to get curent user locales.
	 */
	@Autowired
	private LocaleResolver localeResolver;
	/**
	 * {@inheritDoc}
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (modelAndView != null) {
			modelAndView.addObject(MESSAGES_MODEL_NAME, 
					new MessageSourceWrapper(messages, localeResolver.resolveLocale(request)));
		}
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	public ReloadableResourceBundleMessageSource getMessages() {
		return messages;
	}

	public void setMessages(ReloadableResourceBundleMessageSource messages) {
		this.messages = messages;
	}
}
