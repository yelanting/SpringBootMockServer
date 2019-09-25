/**
 * @author : 孙留平
 * @since : 2019年5月7日 下午7:15:13
 * @see:
 */
package com.tianque.mock.server.service.impl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianque.commons.util.core.base.ValidationUtil;
import com.tianque.commons.util.exception.base.BusinessValidationException;
import com.tianque.mock.server.mapper.MockApiMapper;
import com.tianque.mock.server.model.MockApi;
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

	/**
	 * @see 获取列表
	 */
	@Override
	public List<MockApi> getList() {

		List<MockApi> findAllList = mockApiMapper.findAll();
		logger.debug("当前列表:{}", Arrays.asList(findAllList));
		return findAllList;
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
			return mockApi;
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
			return mockApi;
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

		return mockApiMapper.findMockApisByAppEnameOrNameLike(searchContent);
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
		return mockApiMapper.selectByPrimaryKey(id);
	}

	/**
	 * @see
	 *      com.tianque.yunxiao.connect.server.service.MockApiService#selectByObject(com.tianque.yunxiao.connect.server.model
	 *      .MockApi)
	 */
	@Override
	public MockApi selectByObject(MockApi mockApi) {
		return selectByPrimaryKey(mockApi.getId());
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
	public MockApi findMockApiByAppEname(String 请求路径) {
		return mockApiMapper.findMockApiByAppEname(请求路径);
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
		return mockApiMapper.searchMockApiByApplicationId(applicationId);
	}
}
