package com.imanager.service.document.vo;

import java.util.List;

public class ProductVO extends BaseVO {

	private String productId;
	private String productName;
	private Double price;
	private List<String> suppliers;

	public ProductVO() {
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

}
