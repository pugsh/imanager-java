package com.imanager.common.log;

public class LogUtil {

	private static final String LOG_MESSAGE_TEMPLATE = "CODE=%s|MSG=%s";

	private LogUtil() {
	}

	public static String getLogMessage(String errorCode, String errorMessage) {
		return String.format(LOG_MESSAGE_TEMPLATE, errorCode, errorMessage);
	}
}
