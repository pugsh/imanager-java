package com.imanager.service.dao.impl;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.imanager.service.dao.IBaseDAO;
import com.imanager.service.dao.filter.DocumentSearch;
import com.imanager.service.document.BaseDocument;
import com.imanager.service.exception.InvalidSearchParameter;
import com.imanager.service.exception.NoDataFoundException;

@Repository
public class BaseDAOImpl implements IBaseDAO {

	@Autowired
	private MongoOperations mongoTemplate;

	@Override
	public BaseDocument getDocumentById(DocumentSearch<? extends Serializable> filter) throws Exception {
		if (filter == null || StringUtils.isEmpty(filter.getSearchProperty())
				|| StringUtils.isEmpty(filter.getCollectionName())) {
			throw new InvalidSearchParameter("Invalid search paramater");
		}
		BaseDocument document;
		Criteria criteria = Criteria.where(filter.getSearchProperty()).is(filter.getSearchValue());
		Query query = new Query(criteria);
		document = (BaseDocument) mongoTemplate.findOne(query, filter.getDocumentClass(),
				filter.getCollectionName());
		if (document == null) {
			throw new NoDataFoundException("No data found");
		}
		return document;
	}

}
