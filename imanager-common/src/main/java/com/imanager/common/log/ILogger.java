package com.imanager.common.log;

public interface ILogger {

	public void info(String errorCode, String errorMessage);

	public void info(String errorCode, String errorMessage, Throwable t);

	public void debug(String errorCode, String errorMessage);

	public void debug(String errorCode, String errorMessage, Throwable t);

	public void error(String errorCode, String errorMessage);

	public void error(String errorCode, String errorMessage, Throwable t);
}
