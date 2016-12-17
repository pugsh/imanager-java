package com.imanager.service.dao;

import java.io.Serializable;
import java.util.List;

import com.imanager.service.dao.filter.DocumentFilter;
import com.imanager.service.exception.SequenceException;
import com.imanager.service.model.BaseDocument;

public interface IBaseDAO {

	public BaseDocument findById(DocumentFilter<? extends Serializable> filter) throws Exception;

	public List<BaseDocument> findAll(DocumentFilter<?> search) throws Exception;

	public List<BaseDocument> find(DocumentFilter<?> filter) throws Exception;

	public void insert(BaseDocument document) throws SequenceException;

	public void update(BaseDocument document) throws SequenceException;

	public void delete(BaseDocument document) throws SequenceException;

}
