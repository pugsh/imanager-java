package com.imanager.service.dao.filter;

import java.io.Serializable;

import com.imanager.service.request.Sort;

public class DocumentFilter<T extends Serializable> {

	private String searchProperty;
	private T searchValue;
	private String collectionName;
	private Class<?> entityClass;
	private Sort sortOrder;
	private Integer startIndex;
	private Integer totalRecords;

	public DocumentFilter(Class<?> entityClass, String searchProperty, T searchValue, String collectionName) {
		this.searchProperty = searchProperty;
		this.searchValue = searchValue;
		this.collectionName = collectionName;
		this.entityClass = entityClass;
	}

	public DocumentFilter(Class<?> entityClass, String searchProperty) {
		this.searchProperty = searchProperty;
		this.entityClass = entityClass;
	}

	public DocumentFilter(Class<?> entityClass, String searchProperty, T searchValue) {
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

	public Sort getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Sort sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}

	@Override
	public String toString() {
		return "DocumentFilter [searchProperty=" + searchProperty + ", searchValue=" + searchValue + ", collectionName="
				+ collectionName + ", entityClass=" + entityClass + ", sortOrder=" + sortOrder + ", startIndex="
				+ startIndex + ", totalRecords=" + totalRecords + "]";
	}

}
