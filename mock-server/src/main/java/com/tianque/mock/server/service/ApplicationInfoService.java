/**
 * @author : 孙留平
 * @since : 2019年5月7日 下午6:48:56
 * @see:
 */
package com.tianque.mock.server.service;

import java.util.List;

import com.tianque.mock.server.model.ApplicationInfo;

/**
 * @author : Administrator
 * @since : 2019年5月7日 下午6:48:56
 * @see :
 */
public interface ApplicationInfoService {
	/**
	 * 查询列表
	 * 
	 * @see : 获取列表
	 * @param :
	 * @return : List<ApplicationInfo>
	 * @return
	 */
	List<ApplicationInfo> getList();

	/**
	 * 添加全局参数
	 * 
	 * @see :
	 * @param :
	 * @return : ApplicationInfo
	 * @param applicationInfo
	 * @return
	 */
	ApplicationInfo addApplicationInfo(ApplicationInfo applicationInfo);

	/**
	 * 修改数据
	 * 
	 * @see :
	 * @param :
	 * @return : ApplicationInfo
	 * @param applicationInfo
	 * @return
	 */
	ApplicationInfo updateApplicationInfo(ApplicationInfo applicationInfo);

	/**
	 * 根据搜索内容查询列表
	 * 
	 * @see :
	 * @param :
	 * @return : List<ApplicationInfo>
	 * @param searchContent
	 * @return
	 */
	List<ApplicationInfo> searchApplicationInfosBySearchContent(
	        String searchContent);

	/**
	 * 根据appEname查询
	 * 
	 * @see :
	 * @param :
	 * @return : List<ApplicationInfo>
	 * @param appEname
	 * @return
	 */
	ApplicationInfo findApplicationInfoByAppEname(String appEname);

	/**
	 * 单个删除
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 * @param id
	 */
	Long deleteApplicationInfo(Long id);

	/**
	 * 批量删除
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 * @param ids
	 */
	Long[] deleteApplicationInfo(Long[] ids);

	/**
	 * 根据主键查询
	 * 
	 * @see : 根据主键查询
	 * @param :
	 * @return : ApplicationInfo
	 * @param id
	 * @return
	 */
	ApplicationInfo selectByPrimaryKey(Long id);

	/**
	 * 根据对象查询
	 * 
	 * @see : 根据具体对象查询
	 * @param :
	 * @return : ApplicationInfo
	 * @param applicationInfo
	 * @return
	 */
	ApplicationInfo selectByObject(ApplicationInfo applicationInfo);
}
