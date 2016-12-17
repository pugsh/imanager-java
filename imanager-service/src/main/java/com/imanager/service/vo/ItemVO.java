package com.imanager.service.vo;

public class ItemVO {

	private ProductVO product;
	private Integer quantity;

	public ProductVO getProduct() {
		return product;
	}

	public void setProduct(ProductVO product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [product=" + product + ", quantity=" + quantity + "]";
	}

}
