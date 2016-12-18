package com.imanager.service;

import java.util.List;

import com.imanager.service.enums.DocumentType;
import com.imanager.service.exception.NoDataFoundException;
import com.imanager.service.exception.ServiceOpException;
import com.imanager.service.request.SearchRequest;
import com.imanager.service.vo.BaseVO;

public interface IBaseService {

	public BaseVO getDocumentById(DocumentType docType, int id) throws ServiceOpException, NoDataFoundException;

	public List<BaseVO> getDocuments(SearchRequest searchRequest) throws ServiceOpException, NoDataFoundException;

	public void addDocument(DocumentType docType, BaseVO vo) throws ServiceOpException;

	public void updateDocument(DocumentType docType, BaseVO vo) throws ServiceOpException;

	public void removeDocument(DocumentType docType, Integer... deleteIds) throws ServiceOpException;
}
