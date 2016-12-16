package com.imanager.service;

import com.imanager.service.enums.DocumentType;
import com.imanager.service.exception.NoDataFoundException;
import com.imanager.service.exception.ServiceOpException;
import com.imanager.service.vo.BaseVO;

@FunctionalInterface
public interface IBaseService {

	public BaseVO getDocumentById(DocumentType docType, int id) throws ServiceOpException, NoDataFoundException;
}
