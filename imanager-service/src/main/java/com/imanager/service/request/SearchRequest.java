package com.imanager.service.request;

import com.imanager.service.enums.DocumentType;

public class SearchRequest {

	DocumentType documentType;
	private Sort sortOrder;
	private Integer startIndex;
	private Integer totalRecords;

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
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

}
