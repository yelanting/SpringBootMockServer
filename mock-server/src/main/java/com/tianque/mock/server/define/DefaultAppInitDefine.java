/**
 * Project Name: mock-server
 * File Name: DefaultAppInitDefine.java
 * Package Name: com.tianque.mock.server.define
 * Date: 2019年9月25日 下午2:56:57
 * Copyright (c) 2019, qing121171@gmail.com All Rights Reserved.
 */
package com.tianque.mock.server.define;

/**
 * @author : 孙留平
 * @since : 2019年9月25日 下午2:56:57
 * @see : 定义系统默认应用的参数
 */
public class DefaultAppInitDefine {
	private DefaultAppInitDefine() {
	}

	public static final String DEFAULT_APP_NAME = "默认应用";
	public static final String DEFAULT_APP_ENAME = "defaultApp";
	public static final String DEFAULT_APP_DESC = "这是系统默认的应用，不可删除";
	public static final String DEFAULT_APP_BASE_URL = "/";
	public static final Boolean IS_DEFAULT_APP = Boolean.TRUE;
}
