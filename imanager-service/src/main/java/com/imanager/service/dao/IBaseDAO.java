package com.imanager.service.dao;

import com.imanager.service.document.BaseDocument;
import com.imanager.service.enums.DocumentType;

@FunctionalInterface
public interface IBaseDAO {

	public BaseDocument getDocumentById(DocumentType documentType, int id);
}
