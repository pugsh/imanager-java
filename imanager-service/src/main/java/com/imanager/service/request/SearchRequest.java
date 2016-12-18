package com.imanager.service.request;

import com.imanager.service.enums.DocumentType;

public class SearchRequest {

	DocumentType documentType;
	private Integer startIndex;
	private Integer totalRecords;
	private String sortProps;
	private String direction;

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
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

	public String getSortProps() {
		return sortProps;
	}

	public void setSortProps(String sortProps) {
		this.sortProps = sortProps;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "SearchRequest [documentType=" + documentType + ", startIndex=" + startIndex + ", totalRecords="
				+ totalRecords + ", sortProps=" + sortProps + ", direction=" + direction + "]";
	}

}
