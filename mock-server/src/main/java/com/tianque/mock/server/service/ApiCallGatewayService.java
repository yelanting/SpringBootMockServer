/**
 * @author : 孙留平
 * @since : 2019年5月7日 下午6:48:56
 * @see:
 */
package com.tianque.mock.server.service;

/**
 * @author : Administrator
 * @since : 2019年5月7日 下午6:48:56
 * @see :
 */
public interface ApiCallGatewayService {
	Object callApi(String applicationEname, String requestMappingPath);
}
