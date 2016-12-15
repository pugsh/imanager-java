package com.imanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imanager.common.util.AppMapper;
import com.imanager.service.IBaseService;
import com.imanager.service.dao.IBaseDAO;
import com.imanager.service.document.BaseDocument;
import com.imanager.service.document.vo.BaseVO;
import com.imanager.service.enums.DocumentType;

@Service
public class BaseServiceImpl implements IBaseService {

	@Autowired
	private IBaseDAO baseDAO;

	@Autowired
	private AppMapper mapper;

	@Transactional
	@Override
	public BaseVO getDocumentById(DocumentType docType, int id) {
		BaseDocument document = baseDAO.getDocumentById(docType, id);
		return (BaseVO) mapper.map(document, docType.getVoClass());
	}

}
