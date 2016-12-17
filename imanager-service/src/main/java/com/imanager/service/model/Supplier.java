package com.imanager.service.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.imanager.service.constants.ServiceConstants;

@Document(collection = ServiceConstants.SUPPLIER_COLLECTION)
public class Supplier extends BaseDocument {

	@Indexed
	private Long supplierId;
	private String supplierName;
	private String ownerName;
	private String contact;
	private Address address;

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", ownerName=" + ownerName
				+ ", contact=" + contact + ", address=" + address + "]";
	}

	@Override
	public String getKeyName() {
		return ServiceConstants.PROPS_SUPPLIERID;
	}

	@Override
	public Long getKeyValue() {
		return this.supplierId;
	}

	@Override
	public void setKeyValue(Long value) {
		this.supplierId = value;
	}

}
