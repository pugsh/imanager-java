package com.imanager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imanager.common.log.AppLogger;
import com.imanager.common.log.ILogger;
import com.imanager.common.log.LogCode;
import com.imanager.common.util.AppMapper;
import com.imanager.service.IBaseService;
import com.imanager.service.dao.IBaseDAO;
import com.imanager.service.dao.filter.DocumentSearch;
import com.imanager.service.enums.DocumentType;
import com.imanager.service.exception.NoDataFoundException;
import com.imanager.service.exception.ServiceOpException;
import com.imanager.service.model.BaseDocument;
import com.imanager.service.vo.BaseVO;

@Service
public class BaseServiceImpl implements IBaseService {

	private static final ILogger logger = AppLogger.getLogger(BaseServiceImpl.class);

	@Autowired
	private IBaseDAO baseDAO;

	@Autowired
	private AppMapper mapper;

	@Override
	public BaseVO getDocumentById(DocumentType docType, int id) throws ServiceOpException, NoDataFoundException {
		BaseVO vo = null;
		try {
			DocumentSearch<Integer> search = new DocumentSearch<>(docType.getEntityClass(), docType.getKeyPropsName(),
					id, docType.getCollectionName());
			BaseDocument document = baseDAO.findById(search);
			vo = (BaseVO) mapper.map(document, docType.getVoClass());
		} catch (NoDataFoundException e) {
			logger.debug(LogCode.SVC_ERROR_CODE, "No data found in getDocumentById.", e);
			throw new NoDataFoundException("No data found.");
		} catch (Exception e) {
			logger.error(LogCode.SVC_ERROR_CODE, "Unexpexted error occured in getDocumentById.", e);
			throw new ServiceOpException("Unexpected error occured creating document.");
		}
		return vo;
	}

	@Override
	public List<BaseVO> getAllDocuments(DocumentType documentType) throws ServiceOpException, NoDataFoundException {
		BaseVO vo = null;
		List<BaseVO> retVo = null;
		try {
			DocumentSearch<Integer> search = new DocumentSearch<>(documentType.getEntityClass(),
					documentType.getKeyPropsName());
			List<BaseDocument> allDocs = baseDAO.findAll(search);
			if (CollectionUtils.isNotEmpty(allDocs)) {
				retVo = new ArrayList<>(allDocs.size());
				for (BaseDocument baseDocument : allDocs) {
					vo = (BaseVO) mapper.map(baseDocument, documentType.getVoClass());
					retVo.add(vo);
				}
			}

		} catch (NoDataFoundException e) {
			logger.debug(LogCode.SVC_ERROR_CODE, "No data found in getAllDocuments.", e);
			throw new NoDataFoundException("No data found.");
		} catch (Exception e) {
			logger.error(LogCode.SVC_ERROR_CODE, "Unexpexted error occured in getAllDocuments", e);
			throw new ServiceOpException("Unexpected error occured fetching document.");
		}
		return retVo;
	}

	@Override
	public void createDocument(DocumentType docType, BaseVO vo) throws ServiceOpException {
		try {
			if (vo != null) {
				BaseDocument document = (BaseDocument) mapper.map(vo, docType.getEntityClass());
				baseDAO.save(document);
			}
		} catch (Exception e) {
			logger.error(LogCode.SVC_ERROR_CODE, "Unexpexted error occured in createDocument.", e);
			throw new ServiceOpException("Unexpected error occured creating document.");
		}
	}

}
