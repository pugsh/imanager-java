package com.imanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imanager.common.log.AppLogger;
import com.imanager.common.log.ILogger;
import com.imanager.service.ProductService;
import com.imanager.service.dao.ProductDAO;
import com.imanager.service.document.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private static final ILogger logger = AppLogger.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	@Transactional
	public Product getProduct(String productName) {
		return productDAO.getProduct(productName);
	}

}
