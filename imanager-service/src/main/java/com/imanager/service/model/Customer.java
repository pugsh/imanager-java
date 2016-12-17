package com.imanager.service.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.imanager.service.constants.ServiceConstants;

@Document(collection = ServiceConstants.CUSTOMER_COLLECTION)
public class Customer extends BaseDocument {

	@Indexed
	private Long customerId;
	private String customerName;
	private String contact;
	private Address address;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", contact=" + contact
				+ ", address=" + address + "]";
	}

	@Override
	public String getKeyName() {
		return ServiceConstants.PROPS_CUSTOMERID;
	}

	@Override
	public Long getKeyValue() {
		return this.customerId;
	}

	@Override
	public void setKeyValue(Long value) {
		this.customerId = value;
	}

}
