package com.imanager.web.vo;

import com.imanager.service.model.Address;

public class CustomerResponseVO {

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
		return "CustomerResponseVO [customerId=" + customerId + ", customerName=" + customerName + ", contact="
				+ contact + ", address=" + address + "]";
	}

}
