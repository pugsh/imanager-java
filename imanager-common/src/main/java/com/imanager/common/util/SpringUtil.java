package com.imanager.common.util;

import org.springframework.context.ApplicationContext;

public class SpringUtil {

	private static ApplicationContext appContext;

	private SpringUtil() {
	}

	public static void setApplicationContext(ApplicationContext appContext) {
		SpringUtil.appContext = appContext;
	}

	public static Object getBean(String name) {
		return appContext.getBean(name);
	}

	public static <T> T getBean(String name, Class<T> className) {
		return appContext.getBean(name, className);
	}

	public static <T> T getBean(Class<T> className) {
		return appContext.getBean(className);
	}
}
