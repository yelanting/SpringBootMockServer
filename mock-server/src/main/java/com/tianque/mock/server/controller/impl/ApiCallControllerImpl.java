/**
 * Project Name: mock-server
 * File Name: ApiCallControllerImpl.java
 * Package Name: com.tianque.mock.server.controller.impl
 * Date: 2019年9月25日 下午1:52:19
 * Copyright (c) 2019, qing121171@gmail.com All Rights Reserved.
 */
package com.tianque.mock.server.controller.impl;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * @author : 孙留平
 * @since : 2019年9月25日 下午1:52:19
 * @see :
 *      调用
 */
@RestController("/apiCall")
@Api("Mock调用相关Api")
public class ApiCallControllerImpl {
	// @PostMapping("/{applicationEname}/{requestMappingPath}")
	// public String callApi(@PathParam("applicationName") String applicationEname,
	// @PathParam("requestMappingPath") String requestMappingPath) {
	// return null;
	// }
}
