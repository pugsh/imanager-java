package com.imanager.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imanager.service.IBaseService;
import com.imanager.service.enums.DocumentType;
import com.imanager.service.exception.NoDataFoundException;
import com.imanager.service.exception.ServiceOpException;
import com.imanager.service.request.SearchRequest;
import com.imanager.service.request.ServiceRequest;
import com.imanager.service.vo.BaseVO;

@Service
public class ServiceDelegate {

	@Autowired
	private ServiceLocator serviceLocator;

	public BaseVO getDocumentById(DocumentType docType, int id) throws ServiceOpException, NoDataFoundException {
		IBaseService service = serviceLocator.locateService(docType);
		return service.getDocumentById(docType, id);
	}

	public List<BaseVO> getDocuments(SearchRequest request) throws ServiceOpException, NoDataFoundException {
		IBaseService service = serviceLocator.locateService(request.getDocumentType());
		return service.getDocuments(request);
	}

	public void addDocument(ServiceRequest serviceRequest) throws ServiceOpException {
		IBaseService service = serviceLocator.locateService(serviceRequest.getDocumentType());
		service.addDocument(serviceRequest.getDocumentType(), (BaseVO) serviceRequest.getData());
	}

	public void updateDocument(ServiceRequest serviceRequest) throws ServiceOpException {
		IBaseService service = serviceLocator.locateService(serviceRequest.getDocumentType());
		service.updateDocument(serviceRequest.getDocumentType(), (BaseVO) serviceRequest.getData());
	}

	public void deleteDocument(ServiceRequest serviceRequest) throws ServiceOpException {
		IBaseService service = serviceLocator.locateService(serviceRequest.getDocumentType());
		service.removeDocument(serviceRequest.getDocumentType(), serviceRequest.getDeleteIds());
	}
}
