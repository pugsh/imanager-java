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
import com.imanager.common.log.LogCode;
import com.imanager.common.web.constants.WebConstants;
import com.imanager.common.web.response.ISimpleResponse;
import com.imanager.common.web.response.SimpleResponseBuilder;
import com.imanager.common.web.util.SimpleResponseUtil;
import com.imanager.service.IBaseService;
import com.imanager.service.document.vo.BaseVO;
import com.imanager.service.enums.DocumentType;

@Service
@Path("/v1")
public class ImanagerEndPoint {

	private static final ILogger logger = AppLogger.getLogger(ImanagerEndPoint.class);

	@Autowired
	private SimpleResponseBuilder responseBuilder;

	@Autowired
	private SimpleResponseUtil responseUtil;

	@Autowired
	private IBaseService baseService;

	@GET
	@Path("{document}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDocument(@Context HttpHeaders headers, @PathParam("document") String document,
			@PathParam("id") int id) {
		long startTime = System.currentTimeMillis();
		boolean debugEnabled = logger.isDebugEnabled();

		ResponseBuilder builder = null;
		Response response = null;
		BaseVO baseVO = null;
		try {
			DocumentType documentType = DocumentType.toEnum(document);
			baseVO = baseService.getDocumentById(documentType, id);
			ISimpleResponse<BaseVO> successResponse = responseUtil.buildSuccessResponse(baseVO);
			builder = responseBuilder.buildSuccessResponse(successResponse, headers, WebConstants.SUCCESS,
					WebConstants.STATUS_200);
			response = builder.build();
		} catch (Exception e) {
			logger.error(LogCode.API_ERROR_CODE, "Error occured", e);
		} finally {
			long endTime = System.currentTimeMillis();
			if (debugEnabled) {
				logger.info(LogCode.API_INFO_CODE, "Response time {%s}" + (endTime - startTime));
			}
			if (baseVO != null) {
				logger.info(LogCode.API_INFO_CODE, baseVO.toString());
			}
		}
		return response;
	}

}
