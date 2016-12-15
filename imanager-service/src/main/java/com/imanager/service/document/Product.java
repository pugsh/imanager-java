package com.imanager.service.document;

import java.util.List;

public class Product extends BaseDocument {

	private String productId;
	private String productName;
	private Double price;
	private List<String> suppliers;

	public Product() {
		super();
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<String> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<String> suppliers) {
		this.suppliers = suppliers;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productId=" + productId + ", productName=" + productName + ", price=" + price
				+ "]";
	}
}
