package com.imanager.service.dao;

import java.io.Serializable;

import com.imanager.service.dao.filter.DocumentSearch;
import com.imanager.service.document.BaseDocument;

@FunctionalInterface
public interface IBaseDAO {

	public BaseDocument getDocumentById(DocumentSearch<? extends Serializable> filter) throws Exception;
}
