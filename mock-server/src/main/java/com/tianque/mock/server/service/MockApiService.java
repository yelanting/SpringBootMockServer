/**
 * @author : 孙留平
 * @since : 2019年5月7日 下午6:48:56
 * @see:
 */
package com.tianque.mock.server.service;

import java.util.List;

import com.tianque.mock.server.model.MockApi;

/**
 * @author : Administrator
 * @since : 2019年5月7日 下午6:48:56
 * @see :
 */
public interface MockApiService {
	/**
	 * 查询列表
	 * 
	 * @see : 获取列表
	 * @param :
	 * @return : List<MockApi>
	 * @return
	 */
	List<MockApi> getList();

	/**
	 * 添加全局参数
	 * 
	 * @see :
	 * @param :
	 * @return : MockApi
	 * @param mockApi
	 * @return
	 */
	MockApi addMockApi(MockApi mockApi);

	/**
	 * 修改数据
	 * 
	 * @see :
	 * @param :
	 * @return : MockApi
	 * @param mockApi
	 * @return
	 */
	MockApi updateMockApi(MockApi mockApi);

	/**
	 * 根据搜索内容查询列表
	 * 
	 * @see :
	 * @param :
	 * @return : List<MockApi>
	 * @param searchContent
	 * @return
	 */
	List<MockApi> searchMockApisBySearchContent(String searchContent);

	/**
	 * 根据appEname查询
	 * 
	 * @see :
	 * @param :
	 * @return : List<MockApi>
	 * @param appEname
	 * @return
	 */
	MockApi findMockApiByAppEname(String appEname);

	/**
	 * 单个删除
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 * @param id
	 */
	Long deleteMockApi(Long id);

	/**
	 * 批量删除
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 * @param ids
	 */
	Long[] deleteMockApi(Long[] ids);

	/**
	 * 根据主键查询
	 * 
	 * @see : 根据主键查询
	 * @param :
	 * @return : MockApi
	 * @param id
	 * @return
	 */
	MockApi selectByPrimaryKey(Long id);

	/**
	 * 根据对象查询
	 * 
	 * @see : 根据具体对象查询
	 * @param :
	 * @return : MockApi
	 * @param mockApi
	 * @return
	 */
	MockApi selectByObject(MockApi mockApi);
}
