package com.imanager.service.model;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.imanager.service.constants.ServiceConstants;

@Document(collection = ServiceConstants.ORDER_COLLECTION)
public class Order extends BaseDocument {

	@Indexed
	private Long orderId;
	private Supplier supplier;
	private List<Item> items;

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

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", supplier=" + supplier + ", items=" + items + "]";
	}

	@Override
	public String getKeyName() {
		return ServiceConstants.PROPS_ORDERID;
	}

	@Override
	public Long getKeyValue() {
		return this.orderId;
	}

	@Override
	public void setKeyValue(Long value) {
		this.orderId = value;
	}

}
