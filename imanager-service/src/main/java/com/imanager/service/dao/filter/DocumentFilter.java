package com.imanager.service.dao.filter;

import java.io.Serializable;

import org.springframework.data.domain.Sort.Direction;

public class DocumentFilter<T extends Serializable> {

	private String searchProperty;
	private T searchValue;
	private String collectionName;
	private Class<?> entityClass;
	private Integer startIndex;
	private Integer totalRecords;
	private String sortProps;
	private Direction sortDirection;

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

	public String getSortProps() {
		return sortProps;
	}

	public void setSortProps(String sortProps) {
		this.sortProps = sortProps;
	}

	public Direction getSortDirection() {
		return sortDirection;
	}

	public void setSortDirection(Direction sortDirection) {
		this.sortDirection = sortDirection;
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
				+ collectionName + ", entityClass=" + entityClass + ", startIndex=" + startIndex + ", totalRecords="
				+ totalRecords + ", sortProps=" + sortProps + ", sortDirection=" + sortDirection + "]";
	}

}
