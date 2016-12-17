package com.imanager.service.dao;

import java.io.Serializable;
import java.util.List;

import com.imanager.service.dao.filter.DocumentSearch;
import com.imanager.service.exception.SequenceException;
import com.imanager.service.model.BaseDocument;

public interface IBaseDAO {

	public BaseDocument findById(DocumentSearch<? extends Serializable> filter) throws Exception;

	public List<BaseDocument> findAll(DocumentSearch<?> search) throws Exception;

	public void save(BaseDocument document) throws SequenceException;
}
