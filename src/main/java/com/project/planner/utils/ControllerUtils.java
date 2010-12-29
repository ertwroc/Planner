package com.project.planner.utils;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;

public class ControllerUtils {
	/**
	 * Convert map to property values with key change using provided mapping.
	 * @param data data to fill property values
	 * @param mapping mapping used to change name
	 * @return converted property values
	 */
	public static PropertyValues toPVS(Map<String, String> data, Map<String, String> mapping) {
		MutablePropertyValues result = new MutablePropertyValues();
		for (Entry<String, String> entry : data.entrySet()) {
			String newKey = mapping.get(entry.getKey());
			if (newKey == null) {
				newKey = entry.getKey();
			}
			result.add(newKey, entry.getValue());
		}
		return result;
	}
}
