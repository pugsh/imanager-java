package com.imanager.service.enums;

import java.util.HashMap;
import java.util.Map;

import com.imanager.service.constants.ServiceConstants;
import com.imanager.service.model.Customer;
import com.imanager.service.model.Order;
import com.imanager.service.model.Product;
import com.imanager.service.model.Supplier;
import com.imanager.service.vo.CustomerVO;
import com.imanager.service.vo.OrderVO;
import com.imanager.service.vo.ProductVO;
import com.imanager.service.vo.SupplierVO;

public enum DocumentType {
	PRODUCT(ServiceConstants.PRODUCT_DOCUMENT, ServiceConstants.PROPS_PRODUCTID, Product.class, ProductVO.class,
			ServiceConstants.PRODUCT_COLLECTION), 
	SUPPLIER(ServiceConstants.SUPPLIER_DOCUMENT, ServiceConstants.PROPS_SUPPLIERID, Supplier.class, SupplierVO.class,
					ServiceConstants.SUPPLIER_COLLECTION),
	ORDER(ServiceConstants.ORDER_DOCUMENT, ServiceConstants.PROPS_ORDERID, Order.class, OrderVO.class,
			ServiceConstants.ORDER_COLLECTION),
	CUSTOMER(ServiceConstants.CUSTOMER_DOCUMENT, ServiceConstants.PROPS_CUSTOMERID, Customer.class, CustomerVO.class,
			ServiceConstants.CUSTOMER_COLLECTION);

	private static final Map<String, DocumentType> enumKeyValueMap = new HashMap<>();

	static {
		for (DocumentType documentType : DocumentType.values()) {
			enumKeyValueMap.put(documentType.getDocumentName(), documentType);
		}
	}

	private String documentName;
	private String collectionName;
	private String keyPropsName;
	private Class<?> entityClass;
	private Class<?> voClass;

	private DocumentType(String documentName, String keyPropsName, Class<?> entityClass, Class<?> voClass,
			String collectionName) {
		this.documentName = documentName;
		this.collectionName = collectionName;
		this.keyPropsName = keyPropsName;
		this.entityClass = entityClass;
		this.voClass = voClass;
	}

	public String getDocumentName() {
		return documentName;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public String getKeyPropsName() {
		return keyPropsName;
	}

	public Class<?> getEntityClass() {
		return entityClass;
	}

	public Class<?> getVoClass() {
		return voClass;
	}

	public static DocumentType toEnum(String documentName) {
		return enumKeyValueMap.get(documentName);
	}
}
