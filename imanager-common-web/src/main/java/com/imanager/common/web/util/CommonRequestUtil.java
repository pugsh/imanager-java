package com.imanager.common.web.util;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.ValidationException;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.imanager.common.web.constants.WebConstants;
import com.imanager.common.web.response.ResponseSerializer;

@Component
public class CommonRequestUtil {

	public <T extends Object> T toJSONClass(Class<T> clazz, String stringObj) {
		Gson gson = new GsonBuilder().registerTypeAdapter(DateTime.class, ResponseSerializer.getDateTimeDserializer())
				.create();
		return gson.fromJson(stringObj, clazz);
	}

	public <T> List<T> toJSONClassList(final Class<T[]> clazz, final String json) throws ValidationException {
		List<T> inputList;
		try {
			GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(DateTime.class,
					ResponseSerializer.getDateTimeDserializer());
			T[] jsonToObject = gsonBuilder.create().fromJson(json, clazz);
			inputList = Arrays.asList(jsonToObject);
		} catch (JsonSyntaxException jsEx) {
			throw new ValidationException(WebConstants.INVALID_INPUT_JSON, jsEx);
		}
		return inputList;
	}
}
