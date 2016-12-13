package com.imanager.web.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imanager.common.util.AppMapper;
import com.imanager.service.ProductService;
import com.imanager.service.TestService;
import com.imanager.service.document.Product;
import com.imanager.web.vo.ProductResponseVO;

@Service
@Path("/v1")
public class ApiEndPoint {

	@Autowired
	private TestService testService;

	@Autowired
	private ProductService productService;

	@Autowired
	private AppMapper mapper;

	@GET
	@Path("/test")
	public String checkHeartBeat() {
		return testService.testService();
	}

	@GET
	@Path("/products/{productName}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProductResponseVO getProducts(@PathParam("productName") String productName) {
		ProductResponseVO responseVO = null;
		try {
			Product product = productService.getProduct(productName);
			responseVO = mapper.map(product, ProductResponseVO.class);
		} catch (Exception e) {
			responseVO = null;
		}
		return responseVO;
	}

}
