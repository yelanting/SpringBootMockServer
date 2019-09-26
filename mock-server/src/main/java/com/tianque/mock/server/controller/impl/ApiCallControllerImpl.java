/**
 * Project Name: mock-server
 * File Name: ApiCallControllerImpl.java
 * Package Name: com.tianque.mock.server.controller.impl
 * Date: 2019年9月25日 下午1:52:19
 * Copyright (c) 2019, qing121171@gmail.com All Rights Reserved.
 */
package com.tianque.mock.server.controller.impl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import com.tianque.mock.server.service.ApiCallGatewayService;

import io.swagger.annotations.Api;

/**
 * @author : 孙留平
 * @since : 2019年9月25日 下午1:52:19
 * @see :
 *      调用
 */
@RestController("apiCallController")
@RequestMapping("/apiCallGateway")
@Api("Mock调用相关Api")
public class ApiCallControllerImpl {

	private static final Logger LOGGER = LoggerFactory
	        .getLogger(ApiCallControllerImpl.class);

	@Autowired
	private ApiCallGatewayService apiCallGatewayService;

	@RequestMapping("/callApi/{applicationEname}/{requestMappingPath}/**")
	public Object callApi(
	        @PathVariable("applicationEname") String applicationEname,
	        @PathVariable("requestMappingPath") String requestMappingPath,
	        HttpServletRequest httpServletRequest) {

		final String path = httpServletRequest
		        .getAttribute(
		                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE)
		        .toString();
		final String bestMatchingPattern = httpServletRequest
		        .getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE)
		        .toString();

		String arguments = new AntPathMatcher()
		        .extractPathWithinPattern(bestMatchingPattern, path);
		String requestMappingPathFinal;
		if (null != arguments && !arguments.isEmpty()) {
			requestMappingPathFinal = requestMappingPath + '/' + arguments;
		} else {
			requestMappingPathFinal = requestMappingPath;
		}

		LOGGER.debug("applicationEname:[{}], requestMappingPath:{}",
		        applicationEname, requestMappingPathFinal);
		return apiCallGatewayService.callApi(applicationEname,
		        requestMappingPathFinal);
	}
}
