/**
 * Project Name: mock-server
 * File Name: ApplicationInfo.java
 * Package Name: com.tianque.mock.server.model
 * Date: 2019年9月25日 上午9:02:16
 * Copyright (c) 2019, qing121171@gmail.com All Rights Reserved.
 */
package com.tianque.mock.server.model;

import com.tianque.mock.server.model.base.BaseDomain;

/**
 * @author : 孙留平
 * @since : 2019年9月25日 上午9:02:16
 * @see :
 * 
 *      应用实例信息
 */
public class ApplicationInfo extends BaseDomain {
	/**
	 * @Fields serialVersionUID : 序列化ID
	 */
	private static final long serialVersionUID = -5203975138280315604L;

	// 实例名称
	private String appName;

	// app编码
	private String appCode;

	// app基础url
	private String baseUrl;

	// app英文名
	private String appEname;

	// 是否默认
	private boolean defaultApp;

	/**
	 * @return the appName
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * @param appName
	 *            the appName to set
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}

	/**
	 * @return the appCode
	 */
	public String getAppCode() {
		return appCode;
	}

	/**
	 * @param appCode
	 *            the appCode to set
	 */
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	/**
	 * @return the baseUrl
	 */
	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * @param baseUrl
	 *            the baseUrl to set
	 */
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	/**
	 * @return the appEname
	 */
	public String getAppEname() {
		return appEname;
	}

	/**
	 * @param appEname
	 *            the appEname to set
	 */
	public void setAppEname(String appEname) {
		this.appEname = appEname;
	}

	/**
	 * @return the defaultApp
	 */
	public boolean isDefaultApp() {
		return defaultApp;
	}

	/**
	 * @param defaultApp
	 *            the defaultApp to set
	 */
	public void setDefaultApp(boolean defaultApp) {
		this.defaultApp = defaultApp;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * @return
	 */
	@Override
	public String toString() {
		return "ApplicationInfo [appName=" + appName + ", appCode=" + appCode
		        + ", baseUrl=" + baseUrl + ", appEname=" + appEname
		        + ", defaultApp=" + defaultApp + "]";
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 * @return
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appCode == null) ? 0 : appCode.hashCode());
		result = prime * result
		        + ((appEname == null) ? 0 : appEname.hashCode());
		result = prime * result + ((appName == null) ? 0 : appName.hashCode());
		result = prime * result + ((baseUrl == null) ? 0 : baseUrl.hashCode());
		result = prime * result + (defaultApp ? 1231 : 1237);
		return result;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApplicationInfo other = (ApplicationInfo) obj;
		if (appCode == null) {
			if (other.appCode != null)
				return false;
		} else if (!appCode.equals(other.appCode))
			return false;
		if (appEname == null) {
			if (other.appEname != null)
				return false;
		} else if (!appEname.equals(other.appEname))
			return false;
		if (appName == null) {
			if (other.appName != null)
				return false;
		} else if (!appName.equals(other.appName))
			return false;
		if (baseUrl == null) {
			if (other.baseUrl != null)
				return false;
		} else if (!baseUrl.equals(other.baseUrl))
			return false;
		if (defaultApp != other.defaultApp)
			return false;
		return true;
	}
}
