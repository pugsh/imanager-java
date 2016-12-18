package com.imanager.service.request;

import java.util.Arrays;

import com.imanager.service.enums.DocumentType;
import com.imanager.service.vo.BaseVO;

public class ServiceRequest {

	private DocumentType documentType;
	private BaseVO data;
	private Integer[] deleteIds;

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public BaseVO getData() {
		return data;
	}

	public void setData(BaseVO data) {
		this.data = data;
	}

	public Integer[] getDeleteIds() {
		return deleteIds;
	}

	public void setDeleteIds(Integer[] deleteIds) {
		this.deleteIds = deleteIds;
	}

	@Override
	public String toString() {
		return "ServiceRequest [documentType=" + documentType + ", data=" + data + ", deleteIds="
				+ Arrays.toString(deleteIds) + "]";
	}

}
