package com.imanager.service;

import com.imanager.service.document.vo.BaseVO;
import com.imanager.service.enums.DocumentType;

@FunctionalInterface
public interface IBaseService {

	public BaseVO getDocumentById(DocumentType docType, int id);
}
