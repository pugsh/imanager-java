package com.imanager.common.web.response;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class SimpleResponseBuilder {

	public <T> ResponseBuilder buildSuccessResponse(ISimpleResponse<T> response, HttpHeaders headers,
			String headerMessage, int statusCode) {
		ResponseBuilder builder = Response.status(statusCode);
		Gson gson = new GsonBuilder().create();
		builder.entity(gson.toJson(response));
		builder.header(headerMessage, headers);
		return builder;
	}

	public <T> ResponseBuilder buildErrorResponse(SimpleResponse<T> errorResponse, HttpHeaders headers,
			String headerMessage, int statusCode) {
		ResponseBuilder builder = Response.status(statusCode);
		Gson gson = new GsonBuilder().create();
		builder.entity(gson.toJson(errorResponse));
		builder.header(headerMessage, headers);
		return builder;
	}

}
