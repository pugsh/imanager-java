package com.imanager.service.document;

import org.springframework.data.annotation.Id;

public abstract class BaseDocument {
	@Id
	protected String id;

	protected BaseDocument() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
