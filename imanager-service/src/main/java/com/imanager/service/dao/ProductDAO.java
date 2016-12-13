package com.imanager.service.dao;

import java.util.List;

import com.imanager.service.document.Product;

public interface ProductDAO {

	public List<Product> getProudcts();
	public Product getProduct(String productId);
}
