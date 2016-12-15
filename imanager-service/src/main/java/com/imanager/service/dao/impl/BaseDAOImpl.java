package com.imanager.service.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.imanager.service.dao.IBaseDAO;
import com.imanager.service.document.BaseDocument;
import com.imanager.service.enums.DocumentType;

@Repository
public class BaseDAOImpl implements IBaseDAO {

	@Autowired
	private MongoOperations mongoTemplate;

	@Override
	public BaseDocument getDocumentById(DocumentType documentType, int id) {
		Criteria criteria = Criteria.where(documentType.getKeyPropsName()).is(id);
		Query query = new Query(criteria);
		return (BaseDocument) mongoTemplate.findOne(query, documentType.getDocumentClass(),
				documentType.getCollectionName());
	}

}
