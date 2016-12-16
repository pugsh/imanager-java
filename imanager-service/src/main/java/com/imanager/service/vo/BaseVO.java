package com.imanager.service.vo;

public abstract class BaseVO {

	protected String id;

	protected BaseVO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
