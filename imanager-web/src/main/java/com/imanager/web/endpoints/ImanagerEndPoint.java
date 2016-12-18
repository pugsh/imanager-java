package com.imanager.web.endpoints;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.imanager.common.log.AppLogger;
import com.imanager.common.log.ILogger;
import com.imanager.common.log.LogCode;
import com.imanager.common.web.constants.WebConstants;
import com.imanager.common.web.response.ISimpleResponse;
import com.imanager.common.web.response.SimpleResponseBuilder;
import com.imanager.common.web.util.CommonRequestHelper;
import com.imanager.common.web.util.SimpleResponseUtil;
import com.imanager.service.IBaseService;
import com.imanager.service.enums.DocumentType;
import com.imanager.service.exception.NoDataFoundException;
import com.imanager.service.request.SearchRequest;
import com.imanager.service.vo.BaseVO;

@Service
@Path("/v1")
public class ImanagerEndPoint {

	private static final ILogger logger = AppLogger.getLogger(ImanagerEndPoint.class);

	@Autowired
	private SimpleResponseBuilder responseBuilder;

	@Autowired
	private CommonRequestHelper requestHelper;

	@Autowired
	private SimpleResponseUtil responseUtil;

	@Autowired
	private IBaseService baseService;

	@GET
	@Path("{document}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDocument(@Context HttpHeaders headers, @PathParam("document") String documentName,
			@PathParam("id") int id) {
		long startTime = System.currentTimeMillis();
		boolean debugEnabled = logger.isDebugEnabled();

		ResponseBuilder builder = null;
		Response response = null;
		BaseVO baseVO = null;
		try {
			DocumentType documentType = DocumentType.toEnum(documentName);
			baseVO = baseService.getDocumentById(documentType, id);
			ISimpleResponse<BaseVO> successResponse = responseUtil.buildSuccessResponse(baseVO);
			builder = responseBuilder.buildSuccessResponse(successResponse, headers, WebConstants.SUCCESS,
					WebConstants.STATUS_200);
			response = builder.build();
		} catch (NoDataFoundException e) {
			builder = responseUtil.buildNoDataFoundResponse(headers, responseBuilder);
			response = builder.build();
			logger.debug(LogCode.API_DEBUG_CODE, "No data found in getDocument for document={} and id={}.",
					documentName, id, e);
		} catch (Exception e) {
			builder = responseUtil.buildErrorResponse(headers, "Unexpected error occured.", responseBuilder);
			response = builder.build();
			logger.error(LogCode.API_ERROR_CODE, "Unexpected error occured in getDocument.", e);
		} finally {
			long endTime = System.currentTimeMillis();
			if (debugEnabled) {
				logger.info(LogCode.API_INFO_CODE, "Response time of getDocument {}ms.", endTime - startTime);
			}
		}
		return response;
	}

	@GET
	@Path("{document}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDocuments(@Context HttpHeaders headers, @PathParam("document") String documentName,
			@QueryParam("startIndex") Integer startIndex, @QueryParam("totalRecords") Integer totalRecords,
			@QueryParam("sortBy") String sortBy) {
		long startTime = System.currentTimeMillis();
		boolean debugEnabled = logger.isDebugEnabled();

		ResponseBuilder builder = null;
		Response response = null;
		List<BaseVO> baseVO = null;
		SearchRequest searchRequest = new SearchRequest();
		try {
			DocumentType documentType = DocumentType.toEnum(documentName);
			searchRequest.setStartIndex(startIndex);
			searchRequest.setTotalRecords(totalRecords);
			searchRequest.setDocumentType(documentType);
			setSortingParams(sortBy, searchRequest);

			baseVO = baseService.getDocuments(searchRequest);
			ISimpleResponse<List<BaseVO>> successResponse = responseUtil.buildSuccessResponse(baseVO);
			builder = responseBuilder.buildSuccessResponse(successResponse, headers, WebConstants.SUCCESS,
					WebConstants.STATUS_200);
			response = builder.build();
		} catch (NoDataFoundException e) {
			builder = responseUtil.buildNoDataFoundResponse(headers, responseBuilder);
			response = builder.build();
			logger.debug(LogCode.API_DEBUG_CODE, "No data found in getDocuments for document={}.", documentName, e);
		} catch (Exception e) {
			builder = responseUtil.buildErrorResponse(headers, "Unexpected error occured.", responseBuilder);
			response = builder.build();
			logger.error(LogCode.API_ERROR_CODE, "Unexpected error occured in getDocuments.", e);
		} finally {
			long endTime = System.currentTimeMillis();
			if (debugEnabled) {
				logger.info(LogCode.API_INFO_CODE, "Response time of getDocuments {}ms.", endTime - startTime);
			}
		}
		return response;
	}

	@POST
	@Path("{document}/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createDocument(@Context HttpHeaders headers, @PathParam("document") String documentName,
			String entityData) {
		long startTime = System.currentTimeMillis();
		boolean debugEnabled = logger.isDebugEnabled();

		ResponseBuilder builder = null;
		Response response = null;
		try {
			DocumentType documentType = DocumentType.toEnum(documentName);
			BaseVO baseVO = (BaseVO) requestHelper.toJSONClass(documentType.getVoClass(), entityData);
			baseService.createDocument(documentType, baseVO);
			ISimpleResponse<String> successResponse = responseUtil.createConfirmationResponse();
			builder = responseBuilder.buildSuccessResponse(successResponse, headers, WebConstants.SUCCESS,
					WebConstants.STATUS_200);
			response = builder.build();
		} catch (Exception e) {
			builder = responseUtil.buildErrorResponse(headers, "Unexpected error occured.", responseBuilder);
			response = builder.build();
			logger.error(LogCode.API_ERROR_CODE, "Unexpected error occured in createDocument.", e);
		} finally {
			long endTime = System.currentTimeMillis();
			if (debugEnabled) {
				logger.info(LogCode.API_INFO_CODE, "Response time of createDocument {}ms.", endTime - startTime);
			}

		}
		return response;
	}

	private void setSortingParams(String sortOrder, SearchRequest searchRequest) {
		if (searchRequest != null && StringUtils.isNotEmpty(sortOrder)) {
			String[] parts = sortOrder.split(",");
			String propertyName = parts[0];
			Direction sortDirection = Direction.ASC;
			if (parts.length > 1) {
				sortDirection = Direction.fromString(parts[1]);
			}
			searchRequest.setSortProps(propertyName);
			searchRequest.setSortDirection(sortDirection);
		}
	}

}
