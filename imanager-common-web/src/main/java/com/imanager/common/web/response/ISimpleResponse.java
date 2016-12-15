package com.imanager.common.web.response;

/**
 * @author plk
 *
 * @param <T>
 */
public interface ISimpleResponse<T> {

	/**
	 * @return
	 */
	public String getStatus();

	/**
	 * @return
	 */
	public String getLocale();

	/**
	 * @return
	 */
	public T getResponseData();
}
