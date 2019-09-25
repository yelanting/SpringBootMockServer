/**
 * @author : 孙留平
 * @since : 2019年5月7日 下午6:43:30
 * @see:
 */
package com.tianque.mock.server.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tianque.mock.server.model.ApplicationInfo;

/**
 * @author : Administrator
 * @since : 2019年5月7日 下午6:43:30
 * @see :
 */
@Mapper
public interface ApplicationInfoMapper {

	/**
	 * 所有
	 * 
	 * @see :
	 * @param :
	 * @return : List<ApplicationInfo>
	 * @return
	 */
	List<ApplicationInfo> findAll();

	/**
	 * 插入
	 * 
	 * @see :
	 * @param :
	 * @return : int
	 * @param record
	 * @return
	 */
	int insert(ApplicationInfo record);

	/**
	 * 根据对象更新
	 * 
	 * @see :
	 * @param :
	 * @return : int
	 * @param record
	 * @return
	 */

	int updateByPrimaryKey(ApplicationInfo record);

	/**
	 * 根据主键单个删除
	 * 
	 * @see :
	 * @param :
	 * @return : int
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * 根据主键批量删除
	 * 
	 * @see :
	 * @param :
	 * @return : int
	 * @param ids
	 * @return
	 */
	int deleteByIds(Long[] ids);

	/**
	 * 根据主键查询单个实体
	 * 
	 * @see :
	 * @param :
	 * @return : ApplicationInfo
	 * @param id
	 * @return
	 */
	ApplicationInfo selectByPrimaryKey(Long id);

	/**
	 * 根据单个实体查询
	 * 
	 * @see :
	 * @param :
	 * @return : ApplicationInfo
	 * @param record
	 * @return
	 */
	ApplicationInfo selectByObject(ApplicationInfo record);

	/**
	 * 根据key查询列表-模糊
	 * 
	 * @see :
	 * @param :
	 * @return : List<ApplicationInfo>
	 * @param searchContent
	 * @return
	 */
	List<ApplicationInfo> findApplicationInfosByAppEnameOrNameLike(
	        String searchContent);

	/**
	 * 根据key查询列表-模糊
	 * 
	 * @see :
	 * @param :
	 * @return : List<ApplicationInfo>
	 * @param searchContent
	 * @return
	 */
	List<ApplicationInfo> findApplicationInfosByAppNameLike(
	        String searchContent);

	/**
	 * 根据主键查询，精确
	 * 
	 * @see :
	 * @param :
	 * @return : ApplicationInfo
	 * @param appEname
	 * @return
	 */
	ApplicationInfo findApplicationInfoByAppEname(String appEname);

	/**
	 * 查询非当前实体列表
	 * 
	 * @see :
	 * @param :
	 * @return : List<ApplicationInfo>
	 * @param applicationInfo
	 * @return
	 */
	List<ApplicationInfo> findOtherApplicationInfosByObject(
	        ApplicationInfo applicationInfo);
}
