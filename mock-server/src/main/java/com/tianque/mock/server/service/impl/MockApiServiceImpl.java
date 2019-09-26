/**
 * @author : 孙留平
 * @since : 2019年5月7日 下午7:15:13
 * @see:
 */
package com.tianque.mock.server.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianque.commons.util.core.base.ValidationUtil;
import com.tianque.commons.util.exception.base.BusinessValidationException;
import com.tianque.mock.server.mapper.MockApiMapper;
import com.tianque.mock.server.model.ApplicationInfo;
import com.tianque.mock.server.model.MockApi;
import com.tianque.mock.server.service.ApplicationInfoService;
import com.tianque.mock.server.service.MockApiService;

/**
 * @author : Administrator
 * @since : 2019年5月7日 下午7:15:13
 * @see :
 */

@Service("mockApiService")
public class MockApiServiceImpl implements MockApiService {

	private static final Logger logger = LoggerFactory
	        .getLogger(MockApiServiceImpl.class);

	@Autowired
	private MockApiMapper mockApiMapper;

	@Autowired
	private ApplicationInfoService applicationInfoService;

	/**
	 * @see 获取列表
	 */
	@Override
	public List<MockApi> getList() {

		List<MockApi> findAllList = mockApiMapper.findAll();
		logger.debug("当前列表:{}", Arrays.asList(findAllList));
		return dealWithMockApis(findAllList);
	}

	/**
	 * @see 添加接口Mock
	 */
	@Override
	public MockApi addMockApi(MockApi mockApi) {
		logger.info("添加接口Mock:{}", mockApi);
		if (checkAppEnameExists(mockApi.getApiPath())) {
			throw new BusinessValidationException("该path已经存在，不可重复添加");
		}

		try {

			int resultKey = mockApiMapper.insert(mockApi);
			mockApi.setId(Long.valueOf(resultKey));
			return dealWithMockApi(mockApi);
		} catch (Exception e) {
			logger.error("添加接口Mock失败,错误信息:{}", e.getMessage());
			throw new BusinessValidationException("添加接口Mock失败");
		}
	}

	/**
	 * @see com.tianque.yunxiao.connect.server.service.MockApiService#updateMockApi(com.tianque.yunxiao.connect.server.model.MockApi)
	 */
	@Override
	public MockApi updateMockApi(MockApi mockApi) {
		logger.info("修改接口Mock:{}", mockApi);
		ValidationUtil.validateNull(mockApi.getId(), null);

		if (checkAppEnameExists(mockApi)) {
			throw new BusinessValidationException("该请求路径已经存在，不可修改为此请求路径");
		}

		MockApi currentMockApi = selectByObject(mockApi);

		if (null == currentMockApi) {
			throw new BusinessValidationException("待修改对象不存在，不能修改");
		}

		try {

			this.mockApiMapper.updateByPrimaryKey(mockApi);
			return dealWithMockApi(mockApi);
		} catch (Exception e) {
			throw new BusinessValidationException("修改失败");
		}

	}

	/**
	 * @see com.tianque.yunxiao.connect.server.service.MockApiService#searchMockApisBySearchContent(java.lang.String)
	 */
	@Override
	public List<MockApi> searchMockApisBySearchContent(String searchContent) {
		logger.debug("根据:{}查询列表", searchContent);

		return dealWithMockApis(
		        mockApiMapper.findMockApisByApiPathOrNameLike(searchContent));
	}

	/**
	 * @see 单个删除
	 */
	@Override
	public Long deleteMockApi(Long id) {
		ValidationUtil.validateNull(id, null);
		mockApiMapper.deleteByPrimaryKey(id);
		return id;
	}

	/**
	 * 批量删除
	 * 
	 * @see com.tianque.yunxiao.connect.server.service.MockApiService#deleteMockApi(java.lang.Long[])
	 */
	@Override
	public Long[] deleteMockApi(Long[] ids) {
		ValidationUtil.validateNull(ids, null);
		ValidationUtil.validateArrayNullOrEmpty(ids, null);
		mockApiMapper.deleteByIds(ids);
		return ids;
	}

	/**
	 * @see com.tianque.yunxiao.connect.server.service.MockApiService#selectByPrimaryKey(java.lang.Long)
	 */
	@Override
	public MockApi selectByPrimaryKey(Long id) {
		logger.info("根据主键查询");
		ValidationUtil.validateNull(id, null);
		return dealWithMockApi(mockApiMapper.selectByPrimaryKey(id));
	}

	/**
	 * @see
	 *      com.tianque.yunxiao.connect.server.service.MockApiService#selectByObject(com.tianque.yunxiao.connect.server.model
	 *      .MockApi)
	 */
	@Override
	public MockApi selectByObject(MockApi mockApi) {
		return dealWithMockApi(selectByPrimaryKey(mockApi.getId()));
	}

	/**
	 * @see :检查
	 * @param :
	 * @return : boolean
	 * @return
	 */
	private boolean checkAppEnameExists(String 请求路径) {
		List<MockApi> currentList = searchMockApisBySearchContent(请求路径);

		return !currentList.isEmpty();
	}

	/**
	 * @see :检查
	 * @param :
	 * @return : boolean
	 * @return
	 */
	private boolean checkAppEnameExists(MockApi mockApi) {
		List<MockApi> currentList = null;
		if (null != mockApi.getId()) {
			currentList = mockApiMapper.findOtherMockApisByObject(mockApi);
		} else {
			currentList = searchMockApisBySearchContent(mockApi.getApiPath());

		}
		return !currentList.isEmpty();
	}

	/**
	 * 根据请求路径唯一查询
	 * 
	 * @see com.tianque.yunxiao.connect.server.service.MockApiService#
	 *      findMockApiByAppEname(java.lang.String)
	 */
	@Override
	public MockApi findMockApiByApiPath(String apiPath) {
		logger.debug("根据apiPath查询MockApi:[{}]", apiPath);
		return dealWithMockApi(mockApiMapper.findMockApiByApiPath(apiPath));
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.tianque.mock.server.service.MockApiService#searchMockApiByApplicationId(java.lang.Long)
	 * @param applicationId
	 * @return
	 */
	@Override
	public List<MockApi> searchMockApiByApplicationId(Long applicationId) {
		logger.debug("根据应用的id:{}查询相关联的api", applicationId);
		return dealWithMockApis(
		        mockApiMapper.searchMockApiByApplicationId(applicationId));
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.tianque.mock.server.service.MockApiService#searchMockApisBySearchContentAndAppInfo(java.lang.String,
	 *      java.lang.String)
	 * @param searchContent
	 * @param appInfo
	 * @return
	 */
	@Override
	public List<MockApi> searchMockApisBySearchContentAndAppInfo(
	        String searchContent, String appInfo) {
		logger.debug("根据Api内容:[{}]和app信息搜索:[{}]", searchContent, appInfo);
		Long[] applicationIds = getApplicationIdsOfSearchContent(appInfo);

		if (applicationIds.length == 0) {
			return new ArrayList<>();
		}

		return dealWithMockApis(
		        mockApiMapper.searchMockApiBySearchContentInApplicationIds(
		                searchContent, applicationIds));
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.tianque.mock.server.service.MockApiService#searchMockApisWithAppInfo(java.lang.String)
	 * @param searchContent
	 * @return
	 */
	@Override
	public List<MockApi> searchMockApisWithAppInfo(String searchContent) {
		Long[] applicationIds = getApplicationIdsOfSearchContent(searchContent);
		return searchMockApiByApplicationIds(applicationIds);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.tianque.mock.server.service.MockApiService#searchMockApiByApplicationIds(java.lang.Long[])
	 * @param applicationIds
	 * @return
	 */
	@Override
	public List<MockApi> searchMockApiByApplicationIds(Long[] applicationIds) {
		logger.debug("根据多个应用id信息:{}查询关联的mockapi",
		        Arrays.asList(applicationIds));

		if (applicationIds.length == 0) {
			return new ArrayList<>();
		}

		List<MockApi> currentMockApiList = mockApiMapper
		        .searchMockApiByApplicationIds(applicationIds);

		return dealWithMockApis(currentMockApiList);
	}

	/**
	 * 根据模糊查询的结果，拿到id数组
	 * 
	 * @see :
	 * @param :
	 * @return : Long[]
	 * @return
	 */
	private Long[] getApplicationIdsOfSearchContent(String appSearchContent) {
		List<ApplicationInfo> applicationInfos = applicationInfoService
		        .searchApplicationInfosBySearchContent(appSearchContent);

		if (applicationInfos.isEmpty()) {
			return new Long[] {};
		}

		Long[] applicationIds = new Long[applicationInfos.size()];

		for (int i = 0; i < applicationInfos.size(); i++) {
			applicationIds[i] = applicationInfos.get(i).getId();
		}
		return applicationIds;
	}

	/**
	 * 根据id拿到app
	 * 
	 * @see :
	 * @param :
	 * @return : Long[]
	 * @return
	 */
	private ApplicationInfo getApplicationInfoById(Long applicationInfoId) {
		return applicationInfoService.selectByPrimaryKey(applicationInfoId);
	}

	/**
	 * 处理返回的MockApi列表
	 * 
	 * @see :
	 * @param :
	 * @return : List<MockApi>
	 * @param mockApis
	 * @return
	 */
	private List<MockApi> dealWithMockApis(final List<MockApi> mockApis) {

		List<ApplicationInfo> applicationInfos = new ArrayList<>();
		List<Long> applicationIds = new ArrayList<>();

		for (MockApi mockApi : mockApis) {
			// 如果没有查到过，则查一下放进去
			if (!applicationIds.contains(mockApi.getApplicationId())) {
				ApplicationInfo applicationInfo = getApplicationInfoById(
				        mockApi.getApplicationId());
				applicationInfos.add(applicationInfo);
				applicationIds.add(mockApi.getApplicationId());
				mockApi.setApplicationInfo(applicationInfo);
			} else {
				mockApi.setApplicationInfo(applicationInfos.get(
				        applicationIds.indexOf(mockApi.getApplicationId())));
			}
		}

		return mockApis;
	}

	/**
	 * 处理返回的MockApi
	 * 
	 * @see :
	 * @param :
	 * @return : MockApi
	 * @return
	 */
	private MockApi dealWithMockApi(final MockApi mockApi) {

		if (null != mockApi && null != mockApi.getApplicationId()) {
			mockApi.setApplicationInfo(
			        getApplicationInfoById(mockApi.getApplicationId()));
		}
		return mockApi;
	}
}
