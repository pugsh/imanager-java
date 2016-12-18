package com.imanager.common.web.response;

import java.lang.reflect.Type;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.imanager.common.web.constants.WebConstants;

public class SimpleSerializer {

	private static final DateTimeFormatter formatter = DateTimeFormat.forPattern(WebConstants.RESPONSE_DATE_FORMAT);

	private SimpleSerializer() {
	}

	public static JsonSerializer<DateTime> getDateTimeSerializer() {
		return new JsonSerializer<DateTime>() {

			@Override
			public JsonElement serialize(DateTime dateTime, Type typeOfSrc, JsonSerializationContext context) {
				return new JsonPrimitive(formatter.print(dateTime));
			}
		};
	}

	public static JsonDeserializer<DateTime> getDateTimeDserializer() {
		return new JsonDeserializer<DateTime>() {

			@Override
			public DateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
					throws JsonParseException {
				return formatter.parseDateTime(json.getAsString());
			}
		};
	}
}
