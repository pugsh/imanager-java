package com.imanager.common.log;

public interface ILogger {

	public void info(String errorCode, String errorMessage);

	public void info(String errorCode, String errorMessage, Object... params);

	public void debug(String errorCode, String errorMessage);

	public void debug(String errorCode, String errorMessage, Object... params);

	public void error(String errorCode, String errorMessage);

	public void error(String errorCode, String errorMessage, Object... params);

	public boolean isDebugEnabled();
}
