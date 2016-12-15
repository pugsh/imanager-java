package com.imanager.common.web.response;

import com.imanager.common.web.constants.WebConstants;

public class ErrorResponse {

	private String status = WebConstants.FAILURE;
	private String errorMessage;
	private String statusCode;
	private String statusDescription;

	public ErrorResponse(String statusDescription, String statusCode, String errorMessage) {
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
		this.statusDescription = statusDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

}
