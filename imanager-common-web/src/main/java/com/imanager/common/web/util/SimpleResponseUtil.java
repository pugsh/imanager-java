package com.imanager.common.web.util;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.stereotype.Component;

import com.imanager.common.web.constants.WebConstants;
import com.imanager.common.web.response.ErrorResponse;
import com.imanager.common.web.response.ISimpleResponse;
import com.imanager.common.web.response.SimpleResponse;
import com.imanager.common.web.response.SimpleResponseBuilder;

@Component
public class SimpleResponseUtil {

	private static final String LOCALE = "en_US";

	public <T> ISimpleResponse<T> buildSuccessResponse(T responseData) {
		return new SimpleResponse<>(WebConstants.SUCCESS, LOCALE, responseData);
	}

	public ResponseBuilder buildErrorResponse(HttpHeaders headers, String errorMessage, SimpleResponseBuilder builder) {
		String statusCode = String.valueOf(WebConstants.STATUS_500);
		String statusDescription = WebConstants.CODE_500_MESSAGE;
		ErrorResponse errorResponse = new ErrorResponse(statusDescription, statusCode, errorMessage);
		return builder.buildErrorResponse(errorResponse, headers, statusDescription, WebConstants.STATUS_500);
	}
}
