package com.imanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Product getProduct(String productName) {
		logger.error("", "");
		return productDAO.getProduct(productName);
	}

}
