package com.imanager.service.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.imanager.service.dao.IBaseDAO;
import com.imanager.service.dao.filter.DocumentFilter;
import com.imanager.service.exception.InvalidSearchParameter;
import com.imanager.service.exception.NoDataFoundException;
import com.imanager.service.exception.SequenceException;
import com.imanager.service.model.BaseDocument;
import com.imanager.service.model.Sequence;

@Repository
public class BaseDAOImpl implements IBaseDAO {

	@Autowired
	private MongoOperations mongoOperation;

	@Override
	public BaseDocument findById(DocumentFilter<? extends Serializable> filter) throws Exception {
		if (filter == null || StringUtils.isEmpty(filter.getSearchProperty())) {
			throw new InvalidSearchParameter("Invalid search paramater");
		}
		BaseDocument document;
		Criteria criteria = Criteria.where(filter.getSearchProperty()).is(filter.getSearchValue());
		Query query = new Query(criteria);

		document = (BaseDocument) mongoOperation.findOne(query, filter.getEntityClass());
		if (document == null) {
			throw new NoDataFoundException("No data found");
		}
		return document;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BaseDocument> findAll(DocumentFilter<?> filter) throws Exception {
		if (filter == null) {
			throw new InvalidSearchParameter("Invalid search paramater");
		}
		List<BaseDocument> allDocuments = (List<BaseDocument>) mongoOperation.findAll(filter.getEntityClass());
		if (CollectionUtils.isEmpty(allDocuments)) {
			throw new NoDataFoundException("No data found");
		}
		return allDocuments;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BaseDocument> find(DocumentFilter<?> filter) throws Exception {
		if (filter == null || StringUtils.isEmpty(filter.getSearchProperty())) {
			throw new InvalidSearchParameter("Invalid search paramater");
		}
		Query query = new Query();
		if (filter.getStartIndex() != null) {
			query.skip(filter.getStartIndex());
		}
		if (filter.getTotalRecords() != null) {
			query.limit(filter.getTotalRecords());
		}
		if (StringUtils.isNotEmpty(filter.getSortProps())) {
			Sort sort = new Sort(filter.getSortDirection(), filter.getSortProps());
			query.with(sort);
		}
		List<BaseDocument> allDocuments = (List<BaseDocument>) mongoOperation.find(query, filter.getEntityClass());
		if (CollectionUtils.isEmpty(allDocuments)) {
			throw new NoDataFoundException("No data found");
		}
		return allDocuments;
	}

	@Override
	public void insert(BaseDocument document) throws SequenceException {
		Long sequenceId = getNextSequenceId(document.getKeyName());
		document.setKeyValue(sequenceId);
		mongoOperation.insert(document);
	}

	@Override
	public void update(BaseDocument document) throws SequenceException {
		mongoOperation.save(document);
	}

	@Override
	public void delete(BaseDocument document) throws SequenceException {
		mongoOperation.remove(document);
	}

	private Long getNextSequenceId(String key) throws SequenceException {

		// get sequence id
		Query query = new Query(Criteria.where("name").is(key));

		// increase sequence id by 1
		Update update = new Update();
		update.inc("seq", 1);

		// return new increased id
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);

		// this is the magic happened.
		Sequence sequence = mongoOperation.findAndModify(query, update, options, Sequence.class);

		// if no id, throws SequenceException
		// optional, just a way to tell user when the sequence id is failed to
		// generate.
		if (sequence == null) {
			throw new SequenceException("Unable to get sequence id for key : " + key);
		}

		return sequence.getSeq();
	}
}
