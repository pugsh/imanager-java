package com.imanager.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.imanager.common.log.AppLogger;
import com.imanager.common.log.ILogger;
import com.imanager.common.log.LogCode;

@Component
public class AppContextProvider implements ApplicationContextAware {

	private static final ILogger logger = AppLogger.getLogger(AppContextProvider.class);

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringUtil.setApplicationContext(applicationContext);
		logger.info(LogCode.SVC_INFO_CODE, "Application context is set.");
	}

}
