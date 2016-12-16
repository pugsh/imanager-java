package com.imanager.common.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.imanager.common.log.AppLogger;

public class AppContextListener implements ServletContextListener {

	private static final String LOG_CONFIG_URL = "/home/plk/workspace/imanager-java/log-config/log4j2.xml";
	private static boolean contextInitialized = false;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		if (contextInitialized) {
			return;
		}
		// initialize Logger
		AppLogger.initialize(LOG_CONFIG_URL);
		contextInitialized = true;
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// no action needed
	}

}
