package com.imanager.service.enums;

import java.util.HashMap;
import java.util.Map;

import com.imanager.service.constants.ServiceConstants;
import com.imanager.service.document.Product;
import com.imanager.service.document.Supplier;
import com.imanager.service.vo.ProductVO;
import com.imanager.service.vo.SupplierVO;

public enum DocumentType {
	PRODUCT(ServiceConstants.PRODUCT_DOCUMENT, ServiceConstants.PROPS_PRODUCTID, Product.class, ProductVO.class,
			ServiceConstants.PRODUCT_COLLECTIONS), 
	SUPPLIER(ServiceConstants.SUPPLIER_DOCUMENT, ServiceConstants.PROPS_SUPPLIERID, Supplier.class, SupplierVO.class,
					ServiceConstants.SUPPLIER_COLLECTIONS);

	private static final Map<String, DocumentType> enumKeyValueMap = new HashMap<>();

	static {
		for (DocumentType documentType : DocumentType.values()) {
			enumKeyValueMap.put(documentType.getDocumentName(), documentType);
		}
	}

	private String documentName;
	private String collectionName;
	private String keyPropsName;
	private Class<?> documentClass;
	private Class<?> voClass;

	private DocumentType(String documentName, String keyPropsName, Class<?> documentClass, Class<?> voClass,
			String collectionName) {
		this.documentName = documentName;
		this.collectionName = collectionName;
		this.keyPropsName = keyPropsName;
		this.documentClass = documentClass;
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

	public Class<?> getDocumentClass() {
		return documentClass;
	}

	public Class<?> getVoClass() {
		return voClass;
	}

	public static DocumentType toEnum(String documentName) {
		return enumKeyValueMap.get(documentName);
	}
}
