package com.imanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imanager.service.ProductService;
import com.imanager.service.dao.ProductDAO;
import com.imanager.service.document.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public Product getProduct(String productName) {
		System.out.println(productDAO.getProudcts());
		return productDAO.getProduct(productName);
	}

}
