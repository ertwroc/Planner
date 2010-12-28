package com.project.planner.controller.interceptor;

import java.text.MessageFormat;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.AbstractMessageSource;

public class MessageSourceWrapper {
	/**
	 * String which would be add around message key, if message can't be found
	 * in message source.
	 */
	private static final String BAD_KEY_WRAPPER = "___";
	/** logger */
	protected final Log logger = LogFactory.getLog(getClass());
	
	private AbstractMessageSource messageSource;
	private Locale locale;
	
	public MessageSourceWrapper(AbstractMessageSource messageSource,
			Locale locale) {
		this.messageSource = messageSource;
		this.locale = locale;
	}

	public String getMessage(String key) {
		return this.getMessageInternal(key, null);
	}

	public String getMessage(String key, Object param1) {
		return this.getMessageInternal(key, param1);
	}

	public String getMessage(String key, Object param1, Object param2) {
		return this.getMessageInternal(key, param1, param2);
	}

	public String getMessage(String key, Object param1, Object param2,
			Object param3) {
		return this.getMessageInternal(key, param1, param2, param3);
	}

	public String getMessage(String key, Object param1, Object param2,
			Object param3, Object param4) {
		return this.getMessageInternal(key, param1, param2, param3, param4);
	}

	public String getMessage(String key, Object param1, Object param2,
			Object param3, Object param4, Object param5) {
		return this.getMessageInternal(key, param1, param2, param3, param4,
				param5);
	}

	private String getMessageInternal(String key, Object... params){
		try {
			return messageSource.getMessage(key, null, locale);
		} catch (NoSuchMessageException e) {
			logger.warn(MessageFormat.format("Can''t find ''{0}'' in message bundle", key));
			return new StringBuilder(BAD_KEY_WRAPPER).append(key).append(BAD_KEY_WRAPPER).toString();
		}
		
	}
}
