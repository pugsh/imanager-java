package com.imanager.common.web.response;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.annotations.SerializedName;
import com.imanager.common.web.constants.WebConstants;

/**
 * @author plk
 *
 * @param <T>
 */
public class SimpleResponse<T> implements ISimpleResponse<T> {

	@SerializedName("status")
	private String status;

	@SerializedName("locale")
	private String locale = WebConstants.SPACE;

	@SerializedName("data")
	private T responseData;

	public SimpleResponse(String status, String locale, T responseData) {
		this.status = status;
		this.responseData = responseData;
		if (StringUtils.isNotEmpty(locale)) {
			this.locale = locale;
		}
	}

	@Override
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public void setResponseData(T responseData) {
		this.responseData = responseData;
	}

	@Override
	public String getLocale() {
		return locale;
	}

	@Override
	public T getResponseData() {
		return responseData;
	}

}
