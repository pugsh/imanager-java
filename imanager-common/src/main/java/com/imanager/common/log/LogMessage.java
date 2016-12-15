package com.imanager.common.log;

public class LogMessage {

	private String errorCode;
	private String errorMessage;

	public LogMessage(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "LogMessage [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}

}
