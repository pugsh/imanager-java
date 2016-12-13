package com.imanager.service.document;

import org.springframework.data.annotation.Id;

//@Document(collection = ServiceConstants.PRODUCT_COLLECTIONS)
public class Product {

	@Id
	private String id;
	private String productId;
	private String productName;
	private Double price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", productId=" + productId + ", productName=" + productName + ", price=" + price
				+ "]";
	}
}
