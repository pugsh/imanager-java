package com.imanager.service.vo;

import java.util.List;

public class OrderVO extends BaseVO {

	private Long orderId;
	private SupplierVO supplier;
	private List<ItemVO> items;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public SupplierVO getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierVO supplier) {
		this.supplier = supplier;
	}

	public List<ItemVO> getItems() {
		return items;
	}

	public void setItems(List<ItemVO> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "OrderVO [orderId=" + orderId + ", supplier=" + supplier + ", items=" + items + "]";
	}

}
