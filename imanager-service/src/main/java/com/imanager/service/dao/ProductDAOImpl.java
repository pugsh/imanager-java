package com.imanager.service.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.imanager.service.constants.ServiceConstants;
import com.imanager.service.document.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private MongoOperations mongoTemplate;

	@Override
	public List<Product> getProudcts() {
		return mongoTemplate.findAll(Product.class);
	}

	@Override
	public Product getProduct(String productName) {
		Criteria criteria = Criteria.where(ServiceConstants.PROPS_PRODUCT_NAME).is(productName);
		Query query = new Query(criteria);
		return mongoTemplate.findOne(query, Product.class, ServiceConstants.PRODUCT_COLLECTIONS);
	}

}
