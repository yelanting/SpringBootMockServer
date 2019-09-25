/**
 * @author : 孙留平
 * @since : 2019年5月7日 下午6:43:30
 * @see:
 */
package com.tianque.mock.server.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tianque.mock.server.model.MockApi;

/**
 * @author : Administrator
 * @since : 2019年5月7日 下午6:43:30
 * @see :
 */
@Mapper
public interface MockApiMapper {

	/**
	 * 所有
	 * 
	 * @see :
	 * @param :
	 * @return : List<MockApi>
	 * @return
	 */
	List<MockApi> findAll();

	/**
	 * 插入
	 * 
	 * @see :
	 * @param :
	 * @return : int
	 * @param record
	 * @return
	 */
	int insert(MockApi record);

	/**
	 * 根据对象更新
	 * 
	 * @see :
	 * @param :
	 * @return : int
	 * @param record
	 * @return
	 */

	int updateByPrimaryKey(MockApi record);

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
	 * @return : MockApi
	 * @param id
	 * @return
	 */
	MockApi selectByPrimaryKey(Long id);

	/**
	 * 根据单个实体查询
	 * 
	 * @see :
	 * @param :
	 * @return : MockApi
	 * @param record
	 * @return
	 */
	MockApi selectByObject(MockApi record);

	/**
	 * 根据key查询列表-模糊
	 * 
	 * @see :
	 * @param :
	 * @return : List<MockApi>
	 * @param searchContent
	 * @return
	 */
	List<MockApi> findMockApisByAppEnameOrNameLike(String searchContent);

	/**
	 * 根据key查询列表-模糊
	 * 
	 * @see :
	 * @param :
	 * @return : List<MockApi>
	 * @param searchContent
	 * @return
	 */
	List<MockApi> findMockApisByAppNameLike(String searchContent);

	/**
	 * 根据主键查询，精确
	 * 
	 * @see :
	 * @param :
	 * @return : MockApi
	 * @param appEname
	 * @return
	 */
	MockApi findMockApiByAppEname(String appEname);

	/**
	 * 查询非当前实体列表
	 * 
	 * @see :
	 * @param :
	 * @return : List<MockApi>
	 * @param mockApi
	 * @return
	 */
	List<MockApi> findOtherMockApisByObject(MockApi mockApi);
}
