package com.imanager.common.log;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;

public class AppLogger implements ILogger {

	private Logger logger = null;

	private AppLogger(Logger logger) {
		this.logger = logger;
	}

	public static void initialize(String configFile) {
		LoggerContext context = (LoggerContext) LogManager.getContext(false);
		File file = new File(configFile);
		context.setConfigLocation(file.toURI());
	}

	public static ILogger getLogger(Class<?> className) {
		Logger logger = LogManager.getLogger(className);
		return new AppLogger(logger);
	}

	@Override
	public void error(String errorCode, String message) {
		String logMessage = LogUtil.getLogMessage(errorCode, message);
		logger.error(logMessage);
	}

	@Override
	public void error(String errorCode, String message, Object... params) {
		String logMessage = LogUtil.getLogMessage(errorCode, message);
		logger.error(logMessage, params);
	}

	@Override
	public void info(String errorCode, String message) {
		String logMessage = LogUtil.getLogMessage(errorCode, message);
		logger.info(logMessage);
	}

	@Override
	public void info(String errorCode, String message, Object... params) {
		String logMessage = LogUtil.getLogMessage(errorCode, message);
		logger.info(logMessage, params);
	}

	@Override
	public void debug(String errorCode, String message) {
		String logMessage = LogUtil.getLogMessage(errorCode, message);
		logger.debug(logMessage);
	}

	@Override
	public void debug(String errorCode, String message, Object... params) {
		String logMessage = LogUtil.getLogMessage(errorCode, message);
		logger.debug(logMessage, params);
	}

	@Override
	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}
}
