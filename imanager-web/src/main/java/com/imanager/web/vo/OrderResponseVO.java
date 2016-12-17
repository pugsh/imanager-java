package com.imanager.web.vo;

import java.util.List;

public class OrderResponseVO {

	private Long orderId;
	private SupplierResponseVO supplier;
	private List<ItemResponseVO> items;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public SupplierResponseVO getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierResponseVO supplier) {
		this.supplier = supplier;
	}

	public List<ItemResponseVO> getItems() {
		return items;
	}

	public void setItems(List<ItemResponseVO> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "OrderResponseVO [orderId=" + orderId + ", supplier=" + supplier + ", items=" + items + "]";
	}

}
