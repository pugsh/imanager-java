package com.imanager.util;

import org.springframework.stereotype.Component;

import com.imanager.common.util.SpringUtil;
import com.imanager.service.IBaseService;
import com.imanager.service.constants.ServiceConstants;
import com.imanager.service.enums.DocumentType;

@Component
public class ServiceLocator {

	public IBaseService locateService(DocumentType documentType) {
		return (IBaseService) SpringUtil.getBean(ServiceConstants.BASE_SVC);
	}
}
