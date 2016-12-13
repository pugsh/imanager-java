package com.imanager.service.impl;

import org.springframework.stereotype.Service;

import com.imanager.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Override
	public String testService() {
		return "Hello from spring-jersey";
	}

}
