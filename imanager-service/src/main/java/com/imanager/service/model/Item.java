package com.imanager.service.model;

public class Item {

	private Integer quantity;
	private Product product;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Item [quantity=" + quantity + ", product=" + product + "]";
	}

}
