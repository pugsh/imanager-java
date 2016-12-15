package com.imanager.common.log;

import java.io.Serializable;

public class LogMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;
	private String message;

	public LogMessage(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "LogCode=" + code + ", LogMessage=" + message;
	}

}
