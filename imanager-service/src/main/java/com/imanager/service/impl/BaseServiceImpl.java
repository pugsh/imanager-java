package com.imanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imanager.common.log.AppLogger;
import com.imanager.common.log.ILogger;
import com.imanager.common.log.LogCode;
import com.imanager.common.util.AppMapper;
import com.imanager.service.IBaseService;
import com.imanager.service.dao.IBaseDAO;
import com.imanager.service.dao.filter.DocumentSearch;
import com.imanager.service.document.BaseDocument;
import com.imanager.service.enums.DocumentType;
import com.imanager.service.exception.NoDataFoundException;
import com.imanager.service.exception.ServiceOpException;
import com.imanager.service.vo.BaseVO;

@Service
public class BaseServiceImpl implements IBaseService {

	private static final ILogger logger = AppLogger.getLogger(BaseServiceImpl.class);

	@Autowired
	private IBaseDAO baseDAO;

	@Autowired
	private AppMapper mapper;

	@Transactional
	@Override
	public BaseVO getDocumentById(DocumentType docType, int id) throws ServiceOpException, NoDataFoundException {
		BaseVO vo = null;
		try {
			DocumentSearch<Integer> search = new DocumentSearch<>(docType.getDocumentClass(), docType.getKeyPropsName(),
					id, docType.getCollectionName());
			BaseDocument document = baseDAO.getDocumentById(search);
			vo = (BaseVO) mapper.map(document, docType.getVoClass());
		} catch (NoDataFoundException e) {
			logger.debug(LogCode.SRV_ERROR_CODE, "No data found", e);
			throw new NoDataFoundException("No data found");
		} catch (Exception e) {
			logger.error(LogCode.SRV_ERROR_CODE, "Exception occured while fetching data", e);
			throw new ServiceOpException("Exception occured while fetching data");
		}
		return vo;
	}

}
