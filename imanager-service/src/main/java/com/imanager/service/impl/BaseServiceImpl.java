package com.imanager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.imanager.common.log.AppLogger;
import com.imanager.common.log.ILogger;
import com.imanager.common.log.LogCode;
import com.imanager.common.util.AppMapper;
import com.imanager.service.IBaseService;
import com.imanager.service.dao.IBaseDAO;
import com.imanager.service.dao.filter.DocumentFilter;
import com.imanager.service.enums.DocumentType;
import com.imanager.service.exception.NoDataFoundException;
import com.imanager.service.exception.ServiceOpException;
import com.imanager.service.model.BaseDocument;
import com.imanager.service.request.SearchRequest;
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
			DocumentFilter<Integer> search = new DocumentFilter<>(docType.getEntityClass(), docType.getKeyPropsName(),
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
	public List<BaseVO> getDocuments(SearchRequest request) throws ServiceOpException, NoDataFoundException {
		BaseVO vo = null;
		List<BaseVO> retVo = null;
		try {
			DocumentType documentType = request.getDocumentType();
			DocumentFilter<Integer> search = new DocumentFilter<>(documentType.getEntityClass(),
					documentType.getKeyPropsName());
			search.setStartIndex(request.getStartIndex());
			search.setTotalRecords(request.getTotalRecords());
			
			if (StringUtils.isNotEmpty(request.getSortProps())) {
				search.setSortProps(request.getSortProps());
				search.setSortDirection(Direction.fromString(request.getDirection()));
			}

			List<BaseDocument> docs = baseDAO.find(search);
			if (CollectionUtils.isNotEmpty(docs)) {
				retVo = new ArrayList<>(docs.size());
				for (BaseDocument baseDocument : docs) {
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
				baseDAO.insert(document);
			}
		} catch (Exception e) {
			logger.error(LogCode.SVC_ERROR_CODE, "Unexpexted error occured in createDocument.", e);
			throw new ServiceOpException("Unexpected error occured creating document.");
		}
	}

	@Override
	public void updateDocument(DocumentType docType, BaseVO vo) throws ServiceOpException {
		try {
			BaseDocument document = (BaseDocument) mapper.map(vo, docType.getEntityClass());
			baseDAO.update(document);
		} catch (Exception e) {
			logger.error(LogCode.SVC_ERROR_CODE, "Unexpexted error occured in updateDocument.", e);
			throw new ServiceOpException("Unexpected error occured updating document.");
		}
	}

	@Override
	public void removeDocument(DocumentType docType, BaseVO vo) throws ServiceOpException {
		try {
			BaseDocument document = (BaseDocument) mapper.map(vo, docType.getEntityClass());
			baseDAO.delete(document);
		} catch (Exception e) {
			logger.error(LogCode.SVC_ERROR_CODE, "Unexpexted error occured in removeDocument.", e);
			throw new ServiceOpException("Unexpected error occured deleting document.");
		}
	}

}
