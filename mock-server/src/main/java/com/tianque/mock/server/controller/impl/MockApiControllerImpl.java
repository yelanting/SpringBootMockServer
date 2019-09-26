/**
 * @author : 孙留平
 * @since : 2019年5月10日 下午5:59:08
 * @see:
 */
package com.tianque.mock.server.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianque.commons.util.ResponseData;
import com.tianque.mock.server.model.MockApi;
import com.tianque.mock.server.service.MockApiService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author : Administrator
 * @since : 2019年5月10日 下午5:59:08
 * @see :
 */
@Controller
@Api("MockApi相关API")
@RequestMapping("/mockApi")
public class MockApiControllerImpl {
	@Autowired
	private MockApiService mockApiService;

	@GetMapping(value = "/getList")
	@ResponseBody
	@ApiOperation(value = "查询MockApi列表")
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没有填好"),
	        @ApiResponse(code = 404, message = "页面查找失败，路径不对") })
	public ResponseData getList() {
		List<MockApi> mockApiList = mockApiService.getList();
		return ResponseData.getSuccessResult(mockApiList, mockApiList.size());
	}

	/**
	 * 根据项目名称查询
	 * 
	 * @see :
	 * @param :
	 * @return : ResponseData
	 * @param searchContent
	 * @return
	 */
	@GetMapping(value = "/searchList")
	@ResponseBody
	@ApiOperation(value = "根据key名称查询MockApi")
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没有填好"),
	        @ApiResponse(code = 404, message = "页面查找失败，路径不对") })
	public ResponseData searchList(
	        @RequestParam("searchContent") String searchContent) {
		List<MockApi> mockApiPage = mockApiService
		        .searchMockApisBySearchContent(searchContent);
		return ResponseData.getSuccessResult(mockApiPage, mockApiPage.size());
	}

	/**
	 * 根据项目名称查询
	 * 
	 * @see :
	 * @param :
	 * @return : ResponseData
	 * @param searchContent
	 * @return
	 */
	@GetMapping(value = "/searchListWithAppInfo")
	@ResponseBody
	@ApiOperation(value = "根据应用信息查询MockApi")
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没有填好"),
	        @ApiResponse(code = 404, message = "页面查找失败，路径不对") })
	public ResponseData searchListWithAppInfo(
	        @RequestParam("searchContent") String searchContent) {
		List<MockApi> mockApiPage = mockApiService
		        .searchMockApisWithAppInfo(searchContent);
		return ResponseData.getSuccessResult(mockApiPage, mockApiPage.size());
	}

	/**
	 * 根据项目名称查询
	 * 
	 * @see :
	 * @param :
	 * @return : ResponseData
	 * @param searchContent
	 * @return
	 */
	@GetMapping(value = "/searchListWithConditionAndAppInfo")
	@ResponseBody
	@ApiOperation(value = "根据应用信息查询MockApi")
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没有填好"),
	        @ApiResponse(code = 404, message = "页面查找失败，路径不对") })
	public ResponseData searchListWithConditionAndAppInfo(
	        @RequestParam("searchContent") String searchContent,
	        @RequestParam("appInfo") String appInfo) {
		List<MockApi> mockApiPage = mockApiService
		        .searchMockApisBySearchContentAndAppInfo(searchContent,
		                appInfo);
		return ResponseData.getSuccessResult(mockApiPage, mockApiPage.size());
	}

	/**
	 * 添加MockApi
	 * 
	 * @see :
	 * @param :
	 * @return : ResponseData
	 * @param mockApi
	 */
	@PostMapping(value = "/addMockApi")
	@ApiOperation(value = "添加MockApi")
	@ResponseBody
	public ResponseData addMockApi(@ModelAttribute MockApi mockApi) {
		return ResponseData
		        .getSuccessResult(mockApiService.addMockApi(mockApi));
	}

	/**
	 * 更新MockApi
	 * 
	 * @see :
	 * @param :
	 * @return : ResponseData
	 * @param mockApi
	 */
	@PostMapping(value = "/updateMockApi")
	@ApiOperation(value = "修改MockApi")
	@ResponseBody
	public ResponseData updateMockApi(@ModelAttribute MockApi mockApi) {
		return ResponseData
		        .getSuccessResult(mockApiService.updateMockApi(mockApi));
	}

	/**
	 * 删除MockApi-单个
	 * 
	 * @see :
	 * @param :
	 * @return : ResponseData
	 * @param id
	 */
	@PostMapping(value = "/deleteMockApi")
	@ApiOperation(value = "删除MockApi")
	@ResponseBody
	public ResponseData deleteMockApi(@RequestParam("id") Long id) {
		return ResponseData.getSuccessResult(mockApiService.deleteMockApi(id));
	}

	/**
	 * 批量删除MockApi
	 * 
	 * @see :
	 * @param :
	 * @return : ResponseData
	 * @param ids
	 * @return
	 */
	@PostMapping(value = "/deleteMockApiInBatch")
	@ApiOperation(value = "批量删除MockApi")
	@ResponseBody
	public ResponseData deleteMockApiInBatch(
	        @RequestParam("ids[]") Long[] ids) {
		mockApiService.deleteMockApi(ids);
		return ResponseData.getSuccessResult(ids);
	}

	/**
	 * 获取详情
	 * 
	 * @see :
	 * @param :
	 * @return : ResponseData
	 * @param codeCoverage
	 */
	@GetMapping(value = "/getDetail/{id}")
	@ApiOperation(value = "查询详情")
	@ResponseBody
	public ResponseData getDetail(@PathVariable Long id) {
		return ResponseData
		        .getSuccessResult(mockApiService.selectByPrimaryKey(id));
	}

	/**
	 * 获取详情
	 * 
	 * @see :
	 * @param :
	 * @return : ResponseData
	 * @param codeCoverage
	 */
	@GetMapping(value = "/getList/{applicationId}")
	@ApiOperation(value = "查询详情")
	@ResponseBody
	public ResponseData getListByApplicationId(
	        @PathVariable Long applicationId) {
		return ResponseData.getSuccessResult(
		        mockApiService.searchMockApiByApplicationId(applicationId));
	}
}