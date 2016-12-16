package com.imanager.service.dao.filter;

import java.io.Serializable;

public class DocumentSearch<T extends Serializable> {

	private String searchProperty;
	private T searchValue;
	private String collectionName;
	private Class<?> documentClass;

	public DocumentSearch(Class<?> documentClass, String searchProperty, T searchValue, String collectionName) {
		this.searchProperty = searchProperty;
		this.searchValue = searchValue;
		this.collectionName = collectionName;
		this.documentClass = documentClass;
	}

	public String getSearchProperty() {
		return searchProperty;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public T getSearchValue() {
		return searchValue;
	}

	public Class<?> getDocumentClass() {
		return documentClass;
	}

	@Override
	public String toString() {
		return "DocumentSearch [searchProperty=" + searchProperty + ", searchValue=" + searchValue + ", collectionName="
				+ collectionName + ", documentClass=" + documentClass + "]";
	}

}
