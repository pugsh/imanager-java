package com.imanager.common.log;

public class LogUtil {

	private LogUtil() {
	}

	public static LogMessage createLogMessage(String errorCode, String errorMessage) {
		return new LogMessage(errorCode, errorMessage);
	}
}
