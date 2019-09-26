/**
 * @author : 孙留平
 * @since : 2019年5月7日 下午7:15:13
 * @see:
 */
package com.tianque.mock.server.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianque.commons.util.exception.base.BusinessValidationException;
import com.tianque.mock.server.model.ApplicationInfo;
import com.tianque.mock.server.model.MockApi;
import com.tianque.mock.server.service.ApiCallGatewayService;
import com.tianque.mock.server.service.ApplicationInfoService;
import com.tianque.mock.server.service.MockApiService;

/**
 * @author : Administrator
 * @since : 2019年5月7日 下午7:15:13
 * @see :
 */

@Service("apiCallGatewayService")
public class ApiCallGatewayServiceImpl implements ApiCallGatewayService {

	private static final Logger logger = LoggerFactory
	        .getLogger(ApiCallGatewayServiceImpl.class);

	@Autowired
	private ApplicationInfoService applicationInfoService;

	@Autowired
	private MockApiService mockApiService;

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.tianque.mock.server.service.ApiCallGatewayService#callApi()
	 * @return
	 */
	@Override
	public Object callApi(String applicationEname, String requestMappingPath) {
		logger.info("当前正在对应用:{},进行请求:{}", applicationEname, requestMappingPath);
		ApplicationInfo applicationInfo = applicationInfoService
		        .findApplicationInfoByAppEname(applicationEname);

		if (null == applicationInfo) {
			throw new BusinessValidationException(
			        "应用" + applicationEname + "不存在，请仔细检查");
		}

		logger.debug("app的信息为:{}", applicationInfo);

		String requestMappingPathWithOutPrefix = null;

		String requestMappingPathWithPrefix = null;

		if (!requestMappingPath.startsWith("/")) {
			requestMappingPathWithOutPrefix = requestMappingPath;
			requestMappingPathWithPrefix = "/" + requestMappingPath;
		} else {
			requestMappingPathWithPrefix = requestMappingPath;
			requestMappingPathWithOutPrefix = requestMappingPath.substring(1);
		}

		MockApi mockApiWithOutPrefix = mockApiService
		        .findMockApiByApiPath(requestMappingPathWithOutPrefix);

		MockApi mockApiWithPrefix = mockApiService
		        .findMockApiByApiPath(requestMappingPathWithPrefix);

		if (null == mockApiWithOutPrefix && null == mockApiWithPrefix) {
			throw new BusinessValidationException(
			        "请求路径:[" + requestMappingPathWithOutPrefix + "]或者["
			                + requestMappingPathWithPrefix + "]均不存在");
		}

		MockApi finalMockApi = null;

		if (null != mockApiWithOutPrefix && null != mockApiWithPrefix) {
			finalMockApi = mockApiWithPrefix;
		} else if (null != mockApiWithOutPrefix) {
			finalMockApi = mockApiWithOutPrefix;
		} else {
			finalMockApi = mockApiWithPrefix;
		}

		logger.info("开始正在对应用:{},进行请求:{}", applicationEname, requestMappingPath);
		logger.debug("api的相关信息为:{}", finalMockApi);

		logger.debug("请求返回结果为:{}", finalMockApi.getExpectedResponse());
		return finalMockApi.getExpectedResponse();
	}
}
