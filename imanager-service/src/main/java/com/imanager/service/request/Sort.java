package com.imanager.service.request;

import com.imanager.service.enums.SortDirection;

public class Sort {

	private String propertyName;
	private SortDirection sortDirection;

	public Sort(String propertyName, SortDirection sortDirection) {
		this.propertyName = propertyName;
		this.sortDirection = sortDirection;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public SortDirection getSortDirection() {
		return sortDirection;
	}

	@Override
	public String toString() {
		return "Sort [propertyName=" + propertyName + ", sortDirection=" + sortDirection + "]";
	}

}
