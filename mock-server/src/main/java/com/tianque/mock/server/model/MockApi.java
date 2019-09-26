/**
 * Project Name: mock-server
 * File Name: ApplicationInfo.java
 * Package Name: com.tianque.mock.server.model
 * Date: 2019年9月25日 上午9:02:16
 * Copyright (c) 2019, qing121171@gmail.com All Rights Reserved.
 */
package com.tianque.mock.server.model;

import com.tianque.mock.server.enums.RequestMethodType;
import com.tianque.mock.server.enums.RequestMimeType;
import com.tianque.mock.server.model.base.BaseDomain;

/**
 * @author : 孙留平
 * @since : 2019年9月25日 上午9:02:16
 * @see :
 * 
 *      MockApi详情
 */
public class MockApi extends BaseDomain {

	/**
	 */
	private static final long serialVersionUID = 7210954277220372832L;

	// mockApi名称
	private String apiName;

	// mockApiPath
	private String apiPath;

	// 关联应用id

	private Long applicationId;

	// app请求参数
	private String apiParams;

	// 请求方式
	private RequestMethodType requestMethodType;

	// 请求mime类型
	private RequestMimeType requestMimeType;
	// 期待返回数据
	private Object expectedResponse;

	/**
	 * 非数据库字段
	 */
	private ApplicationInfo applicationInfo;

	/**
	 * @return the apiName
	 */
	public String getApiName() {
		return apiName;
	}

	/**
	 * @param apiName
	 *            the apiName to set
	 */
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	/**
	 * @return the apiPath
	 */
	public String getApiPath() {
		return apiPath;
	}

	/**
	 * @param apiPath
	 *            the apiPath to set
	 */
	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}

	/**
	 * @return the applicationId
	 */
	public Long getApplicationId() {
		return applicationId;
	}

	/**
	 * @param applicationId
	 *            the applicationId to set
	 */
	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	/**
	 * @return the apiParams
	 */
	public String getApiParams() {
		return apiParams;
	}

	/**
	 * @param apiParams
	 *            the apiParams to set
	 */
	public void setApiParams(String apiParams) {
		this.apiParams = apiParams;
	}

	/**
	 * @return the requestMethodType
	 */
	public RequestMethodType getRequestMethodType() {
		return requestMethodType;
	}

	/**
	 * @param requestMethodType
	 *            the requestMethodType to set
	 */
	public void setRequestMethodType(RequestMethodType requestMethodType) {
		this.requestMethodType = requestMethodType;
	}

	/**
	 * @return the requestMimeType
	 */
	public RequestMimeType getRequestMimeType() {
		return requestMimeType;
	}

	/**
	 * @param requestMimeType
	 *            the requestMimeType to set
	 */
	public void setRequestMimeType(RequestMimeType requestMimeType) {
		this.requestMimeType = requestMimeType;
	}

	/**
	 * @return the expectedResponse
	 */
	public Object getExpectedResponse() {
		return expectedResponse;
	}

	/**
	 * @param expectedResponse
	 *            the expectedResponse to set
	 */
	public void setExpectedResponse(Object expectedResponse) {
		this.expectedResponse = expectedResponse;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * @return
	 */
	@Override
	public String toString() {
		return "MockApi [apiName=" + apiName + ", apiPath=" + apiPath
		        + ", applicationId=" + applicationId + ", apiParams="
		        + apiParams + ", requestMethodType=" + requestMethodType
		        + ", requestMimeType=" + requestMimeType + ", expectedResponse="
		        + expectedResponse + ", applicationInfo=" + applicationInfo
		        + "]";
	}

	/**
	 * @return the applicationInfo
	 */
	public ApplicationInfo getApplicationInfo() {
		return applicationInfo;
	}

	/**
	 * @param applicationInfo
	 *            the applicationInfo to set
	 */
	public void setApplicationInfo(ApplicationInfo applicationInfo) {
		this.applicationInfo = applicationInfo;
	}

}
