package com.imanager.common.util;

import org.dozer.Mapper;
import org.dozer.MappingException;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppMapper implements Mapper {

	@Autowired
	private DozerBeanMapperFactoryBean dozerfactory;

	@Override
	public <T> T map(Object source, Class<T> destinationClass) throws MappingException {

		return getMapper().map(source, destinationClass);

	}

	@Override
	public <T> T map(Object source, Class<T> destinationClass, String mapId) throws MappingException {

		return getMapper().map(source, destinationClass, mapId);
	}

	@Override
	public void map(Object source, Object destination) throws MappingException {

		getMapper().map(source, destination);
	}

	@Override
	public void map(Object source, Object destination, String mapId) throws MappingException {

		getMapper().map(source, destination, mapId);

	}

	private Mapper getMapper() {
		Mapper mapper = null;
		try {
			mapper = (Mapper) dozerfactory.getObject();

		} catch (Exception e) {
			throw new MappingException(e.getMessage());
		}
		return mapper;
	}

}
