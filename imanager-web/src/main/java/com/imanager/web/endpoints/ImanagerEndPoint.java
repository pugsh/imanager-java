package com.imanager.web.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imanager.common.log.AppLogger;
import com.imanager.common.log.ILogger;
import com.imanager.common.util.AppMapper;
import com.imanager.common.web.constants.WebConstants;
import com.imanager.common.web.response.ISimpleResponse;
import com.imanager.common.web.response.SimpleResponseBuilder;
import com.imanager.common.web.util.SimpleResponseUtil;
import com.imanager.service.ProductService;
import com.imanager.service.TestService;
import com.imanager.service.document.Product;
import com.imanager.web.vo.ProductResponseVO;

@Service
@Path("/v1")
public class ApiEndPoint {

	private static final ILogger logger = AppLogger.getLogger(ApiEndPoint.class);

	@Autowired
	private SimpleResponseBuilder responseBuilder;

	@Autowired
	private SimpleResponseUtil responseUtil;

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
	public Response getProducts(@Context HttpHeaders headers, @PathParam("productName") String productName) {

		ResponseBuilder builder = null;
		Response response = null;
		ProductResponseVO responseVO = null;
		try {
			Product product = productService.getProduct(productName);
			responseVO = mapper.map(product, ProductResponseVO.class);
			ISimpleResponse<ProductResponseVO> successResponse = responseUtil.buildSuccessResponse(responseVO);
			builder = responseBuilder.buildSuccessResponse(successResponse, headers, WebConstants.SUCCESS,
					WebConstants.STATUS_200);
			response = builder.build();
		} catch (Exception e) {
			builder = responseUtil.buildErrorResponse(headers, WebConstants.MESSAGE_CODE_500_DESCRIPTION,
					responseBuilder);
			response = builder.build();
			logger.error("", "", e);
		}
		return response;
	}

}
