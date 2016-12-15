package com.imanager.web.vo;

import java.util.List;

public class ProductResponseVO {

	private String id;
	private String productId;
	private String productName;
	private Integer price;
	private List<String> suppliers;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public List<String> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<String> suppliers) {
		this.suppliers = suppliers;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", productName=" + productName + ", price=" + price + "]";
	}

}
