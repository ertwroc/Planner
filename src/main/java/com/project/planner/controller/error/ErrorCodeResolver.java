package com.project.planner.controller.error;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.stereotype.Component;
import org.springframework.validation.MessageCodesResolver;

@Component
public class ErrorCodeResolver implements MessageCodesResolver{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] resolveMessageCodes(String errorCode, String objectName) {
		List<String> errorCodes = new ArrayList<String>();
		errorCodes.add(errorCode);
		return errorCodes.toArray(new String[0]);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] resolveMessageCodes(String errorCode, String objectName,
			String field, Class fieldType) {
		List<String> errorCodes = new ArrayList<String>();
		errorCodes.add(errorCode);
		if (ConversionNotSupportedException.ERROR_CODE.equals(errorCode)) {
			errorCodes.add(errorCode + "." + getType(fieldType));
		}
		return errorCodes.toArray(new String[0]);
	}

	private String getType(Class<?> fieldType) {
		if (Calendar.class.isAssignableFrom(fieldType)) {
			return "date";
		}
		return "unknown";
	}

}
