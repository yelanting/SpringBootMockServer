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

import com.tianque.commons.util.core.base.StringUtil;
import com.tianque.commons.util.core.base.UuidUtil;
import com.tianque.commons.util.core.base.ValidationUtil;
import com.tianque.commons.util.exception.base.BusinessValidationException;
import com.tianque.mock.server.mapper.ApplicationInfoMapper;
import com.tianque.mock.server.model.ApplicationInfo;
import com.tianque.mock.server.service.ApplicationInfoService;

/**
 * @author : Administrator
 * @since : 2019年5月7日 下午7:15:13
 * @see :
 */

@Service("applicationInfoService")
public class ApplicationInfoServiceImpl implements ApplicationInfoService {

	private static final Logger logger = LoggerFactory
	        .getLogger(ApplicationInfoServiceImpl.class);

	@Autowired
	private ApplicationInfoMapper applicationInfoMapper;

	/**
	 * @see 获取列表
	 */
	@Override
	public List<ApplicationInfo> getList() {

		List<ApplicationInfo> findAllList = applicationInfoMapper.findAll();
		logger.debug("当前列表:{}", Arrays.asList(findAllList));
		return findAllList;
	}

	/**
	 * @see 添加应用信息
	 */
	@Override
	public ApplicationInfo addApplicationInfo(ApplicationInfo applicationInfo) {
		logger.info("添加应用信息:{}", applicationInfo);
		if (checkAppEnameExists(applicationInfo.getAppEname())) {
			throw new BusinessValidationException("该应用已经存在，不可重复添加");
		}

		try {

			applicationInfo.setAppCode(UuidUtil.generateId().toString());
			int resultKey = applicationInfoMapper.insert(applicationInfo);
			applicationInfo.setId(Long.valueOf(resultKey));
			return applicationInfo;
		} catch (Exception e) {
			logger.error("添加应用信息失败,错误信息:{}", e.getMessage());
			throw new BusinessValidationException("添加应用信息失败");
		}
	}

	/**
	 * @see com.tianque.yunxiao.connect.server.service.ApplicationInfoService#updateApplicationInfo(com.tianque.yunxiao.connect.server.model.ApplicationInfo)
	 */
	@Override
	public ApplicationInfo updateApplicationInfo(
	        ApplicationInfo applicationInfo) {
		logger.info("修改应用信息:{}", applicationInfo);
		ValidationUtil.validateNull(applicationInfo.getId(), null);

		if (checkAppEnameExists(applicationInfo)) {
			throw new BusinessValidationException(
			        "该appEname已经存在，不可修改为此appEname");
		}

		ApplicationInfo currentApplicationInfo = selectByObject(
		        applicationInfo);

		if (null == currentApplicationInfo) {
			throw new BusinessValidationException("待修改对象不存在，不能修改");
		}

		try {

			if (StringUtil.isEmpty(currentApplicationInfo.getAppCode())) {
				applicationInfo.setAppCode(UuidUtil.generateId().toString());
			} else {
				applicationInfo.setAppCode(currentApplicationInfo.getAppCode());
			}

			this.applicationInfoMapper.updateByPrimaryKey(applicationInfo);
			return applicationInfo;
		} catch (Exception e) {
			throw new BusinessValidationException("修改失败");
		}

	}

	/**
	 * @see com.tianque.yunxiao.connect.server.service.ApplicationInfoService#searchApplicationInfosBySearchContent(java.lang.String)
	 */
	@Override
	public List<ApplicationInfo> searchApplicationInfosBySearchContent(
	        String searchContent) {
		logger.debug("根据:{}查询列表", searchContent);

		return applicationInfoMapper
		        .findApplicationInfosByAppEnameOrNameLike(searchContent);
	}

	/**
	 * @see 单个删除
	 */
	@Override
	public Long deleteApplicationInfo(Long id) {
		ValidationUtil.validateNull(id, null);
		applicationInfoMapper.deleteByPrimaryKey(id);
		return id;
	}

	/**
	 * 批量删除
	 * 
	 * @see com.tianque.yunxiao.connect.server.service.ApplicationInfoService#deleteApplicationInfo(java.lang.Long[])
	 */
	@Override
	public Long[] deleteApplicationInfo(Long[] ids) {
		ValidationUtil.validateNull(ids, null);
		ValidationUtil.validateArrayNullOrEmpty(ids, null);
		applicationInfoMapper.deleteByIds(ids);
		return ids;
	}

	/**
	 * @see com.tianque.yunxiao.connect.server.service.ApplicationInfoService#selectByPrimaryKey(java.lang.Long)
	 */
	@Override
	public ApplicationInfo selectByPrimaryKey(Long id) {
		logger.info("根据主键查询");
		ValidationUtil.validateNull(id, null);
		return applicationInfoMapper.selectByPrimaryKey(id);
	}

	/**
	 * @see
	 *      com.tianque.yunxiao.connect.server.service.ApplicationInfoService#selectByObject(com.tianque.yunxiao.connect.server.model
	 *      .ApplicationInfo)
	 */
	@Override
	public ApplicationInfo selectByObject(ApplicationInfo applicationInfo) {
		return selectByPrimaryKey(applicationInfo.getId());
	}

	/**
	 * @see :检查
	 * @param :
	 * @return : boolean
	 * @return
	 */
	private boolean checkAppEnameExists(String appEname) {
		List<ApplicationInfo> currentList = searchApplicationInfosBySearchContent(
		        appEname);

		return !currentList.isEmpty();
	}

	/**
	 * @see :检查
	 * @param :
	 * @return : boolean
	 * @return
	 */
	private boolean checkAppEnameExists(ApplicationInfo applicationInfo) {
		List<ApplicationInfo> currentList = null;
		if (null != applicationInfo.getId()) {
			currentList = applicationInfoMapper
			        .findOtherApplicationInfosByObject(applicationInfo);
		} else {
			currentList = searchApplicationInfosBySearchContent(
			        applicationInfo.getAppEname());

		}
		return !currentList.isEmpty();
	}

	/**
	 * 根据appEname唯一查询
	 * 
	 * @see com.tianque.yunxiao.connect.server.service.ApplicationInfoService#
	 *      findApplicationInfoByAppEname(java.lang.String)
	 */
	@Override
	public ApplicationInfo findApplicationInfoByAppEname(String appEname) {
		return applicationInfoMapper.findApplicationInfoByAppEname(appEname);
	}
}
