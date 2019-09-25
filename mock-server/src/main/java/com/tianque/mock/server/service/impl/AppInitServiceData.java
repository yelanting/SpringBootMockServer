/**
 * Project Name: mock-server
 * File Name: AppInitServiceData.java
 * Package Name: com.tianque.mock.server.service.impl
 * Date: 2019年9月25日 下午2:52:41
 * Copyright (c) 2019, qing121171@gmail.com All Rights Reserved.
 */
package com.tianque.mock.server.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianque.commons.util.core.base.UuidUtil;
import com.tianque.mock.server.define.DefaultAppInitDefine;
import com.tianque.mock.server.model.ApplicationInfo;
import com.tianque.mock.server.service.ApplicationInfoService;

/**
 * @author : 孙留平
 * @since : 2019年9月25日 下午2:52:41
 * @see :
 */
@Service("appInitService")
public class AppInitServiceData {

	@Autowired
	private ApplicationInfoService applicationInfoService;

	@PostConstruct
	public void initDefaultApp() {

		ApplicationInfo applicationInfo = new ApplicationInfo();
		applicationInfo.setAppName(DefaultAppInitDefine.DEFAULT_APP_NAME);
		applicationInfo.setAppEname(DefaultAppInitDefine.DEFAULT_APP_ENAME);
		applicationInfo.setAppCode(UuidUtil.generateId().toString());
		applicationInfo.setDefaultApp(DefaultAppInitDefine.IS_DEFAULT_APP);
		applicationInfo.setDescription(DefaultAppInitDefine.DEFAULT_APP_DESC);

		ApplicationInfo currentApplication = getDefaultApp();
		// 如果不存在，添加
		if (null == currentApplication) {
			applicationInfoService.addApplicationInfo(applicationInfo);
		} else {
			// 如果存在，则判断一样与否，不一样就更新
			if (!applicationInfo.equals(getDefaultApp())) {
				applicationInfo.setId(currentApplication.getId());
				applicationInfoService.updateApplicationInfo(applicationInfo);
			}
		}
	}

	/**
	 * 获取默认应用
	 * 
	 * @see :
	 * @param :
	 * @return : ApplicationInfo
	 * @return
	 */
	public ApplicationInfo getDefaultApp() {
		return applicationInfoService.findApplicationInfoByAppEname(
		        DefaultAppInitDefine.DEFAULT_APP_ENAME);
	}
}
