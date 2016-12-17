package com.imanager.service.vo;

import java.util.List;

public class ProductVO extends BaseVO {

	private Long productId;
	private String productName;
	private Double price;
	private List<SupplierVO> suppliers;

	public ProductVO() {
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

	public List<SupplierVO> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<SupplierVO> suppliers) {
		this.suppliers = suppliers;
	}

	@Override
	public String toString() {
		return "ProductVO [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", suppliers=" + suppliers + "]";
	}

}
