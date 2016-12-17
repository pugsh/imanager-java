package com.imanager.web.vo;

public class ItemResponseVO {

	private ProductResponseVO product;
	private Integer quantity;

	public ProductResponseVO getProduct() {
		return product;
	}

	public void setProduct(ProductResponseVO product) {
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
		return "ItemResponseVO [product=" + product + ", quantity=" + quantity + "]";
	}

}
