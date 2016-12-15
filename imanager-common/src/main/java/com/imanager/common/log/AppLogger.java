package com.imanager.common.log;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class AppLogger implements ILogger {

	private Logger logger = null;

	private AppLogger(Logger logger) {
		this.logger = logger;
	}

	public static AppLogger getLogger(Class<?> className) {
		Logger logger = LogManager.getLogger(className);
		return new AppLogger(logger);
	}

	@Override
	public void error(String errorCode, String errorMessage) {
		LogMessage logMessage = LogUtil.createLogMessage(errorCode, errorMessage);
		logger.error(logMessage);
	}

	@Override
	public void error(String errorCode, String errorMessage, Throwable t) {
		LogMessage logMessage = LogUtil.createLogMessage(errorCode, errorMessage);
		logger.error(logMessage, t);
	}

	@Override
	public void info(String errorCode, String errorMessage) {
		
	}

	@Override
	public void info(String errorCode, String errorMessage, Throwable t) {
		
	}

	@Override
	public void debug(String errorCode, String errorMessage) {
		logger.debug(errorMessage);
	}

	@Override
	public void debug(String errorCode, String errorMessage, Throwable t) {
		
	}
}