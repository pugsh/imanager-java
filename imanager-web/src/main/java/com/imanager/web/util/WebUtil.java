package com.imanager.web.util;

import org.apache.commons.lang3.StringUtils;

import com.imanager.common.web.constants.WebConstants;
import com.imanager.service.enums.ActionType;
import com.imanager.service.enums.DocumentType;
import com.imanager.web.exception.InputValidationException;

public class WebUtil {

	private WebUtil() {
	}

	public static boolean validateInput(String documentName, String action, String entityData)
			throws InputValidationException {

		if (StringUtils.isEmpty(documentName) || StringUtils.isEmpty(action) || StringUtils.isEmpty(entityData)) {
			throw new InputValidationException(WebConstants.INPUT_VALIDATION_ERR);
		}
		if (DocumentType.toEnum(documentName) == null) {
			throw new InputValidationException(WebConstants.INPUT_VALIDATION_ERR);
		}
		if (ActionType.toEnum(action) == null) {
			throw new InputValidationException(WebConstants.INPUT_VALIDATION_ERR);
		}

		return true;
	}
}
