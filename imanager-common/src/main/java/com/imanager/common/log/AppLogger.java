package com.imanager.common.log;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class AppLogger implements ILogger {

	private Logger logger = null;

	private AppLogger(Logger logger) {
		this.logger = logger;
	}

	public static ILogger getLogger(Class<?> className) {
		Logger logger = LogManager.getLogger(className);
		return new AppLogger(logger);
	}

	@Override
	public void error(String errorCode, String message) {
		LogMessage logMessage = LogUtil.createLogMessage(errorCode, message);
		logger.error(logMessage);
	}

	@Override
	public void error(String errorCode, String message, Throwable t) {
		LogMessage logMessage = LogUtil.createLogMessage(errorCode, message);
		logger.error(logMessage, t);
	}

	@Override
	public void info(String errorCode, String message) {
		LogMessage logMessage = LogUtil.createLogMessage(errorCode, message);
		logger.info(logMessage);
	}

	@Override
	public void info(String errorCode, String message, Throwable t) {
		LogMessage logMessage = LogUtil.createLogMessage(errorCode, message);
		logger.info(logMessage, t);
	}

	@Override
	public void debug(String errorCode, String message) {
		LogMessage logMessage = LogUtil.createLogMessage(errorCode, message);
		logger.debug(logMessage);
	}

	@Override
	public void debug(String errorCode, String message, Throwable t) {
		LogMessage logMessage = LogUtil.createLogMessage(errorCode, message);
		logger.debug(logMessage, t);
	}

	@Override
	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}
}
