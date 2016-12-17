package com.imanager.service.dao.filter;

import java.io.Serializable;

public class DocumentSearch<T extends Serializable> {

	private String searchProperty;
	private T searchValue;
	private String collectionName;
	private Class<?> entityClass;

	public DocumentSearch(Class<?> entityClass, String searchProperty, T searchValue, String collectionName) {
		this.searchProperty = searchProperty;
		this.searchValue = searchValue;
		this.collectionName = collectionName;
		this.entityClass = entityClass;
	}

	public DocumentSearch(Class<?> entityClass, String searchProperty) {
		this.searchProperty = searchProperty;
		this.entityClass = entityClass;
	}

	public DocumentSearch(Class<?> entityClass, String searchProperty, T searchValue) {
		this.searchProperty = searchProperty;
		this.searchValue = searchValue;
		this.entityClass = entityClass;
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

	public Class<?> getEntityClass() {
		return entityClass;
	}

	@Override
	public String toString() {
		return "DocumentSearch [searchProperty=" + searchProperty + ", searchValue=" + searchValue + ", collectionName="
				+ collectionName + ", documentClass=" + entityClass + "]";
	}

}
