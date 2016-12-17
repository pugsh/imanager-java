package com.imanager.common.web.util;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.imanager.common.web.constants.WebConstants;

@Component
public class CommonRequestHelper {

	public <T extends Object> T toJSONClass(Class<T> clazz, String stringObj) {
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(stringObj, clazz);
	}

	public <T> List<T> toJSONClassList(final Class<T[]> clazz, final String json) throws ValidationException {
		List<T> inputList;
		try {
			T[] jsonToObject = new Gson().fromJson(json, clazz);
			inputList = Arrays.asList(jsonToObject);
		} catch (JsonSyntaxException jsEx) {

			throw new ValidationException(WebConstants.INVALID_INPUT_JSON, jsEx);
		}
		return inputList;
	}
}
