package com.imanager.service.vo;

import java.util.Date;
import java.util.List;

import com.imanager.service.model.Supplier;

public class OrderVO extends BaseVO {

	private Long orderId;
	private Supplier supplier;
	private Date orderDate;
	private Date lastUpdateDate;
	private List<ItemVO> items;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public List<ItemVO> getItems() {
		return items;
	}

	public void setItems(List<ItemVO> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "OrderVO [orderId=" + orderId + ", supplier=" + supplier + ", orderDate=" + orderDate
				+ ", lastUpdateDate=" + lastUpdateDate + ", items=" + items + "]";
	}
}
