package com.imanager.service.model;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.imanager.service.constants.ServiceConstants;

@Document(collection = ServiceConstants.PRODUCT_COLLECTION)
public class Product extends BaseDocument {

	@Indexed
	private Long productId;
	private String productName;
	private Double price;
	private List<Supplier> suppliers;

	public Product() {
		super();
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
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

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", suppliers="
				+ suppliers + "]";
	}

	@Override
	public String getKeyName() {
		return ServiceConstants.PROPS_PRODUCTID;
	}

	@Override
	public Long getKeyValue() {
		return this.productId;
	}

	@Override
	public void setKeyValue(Long value) {
		this.productId = value;
	}

}
