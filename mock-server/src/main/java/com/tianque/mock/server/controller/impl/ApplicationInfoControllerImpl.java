/**
 * @author : 孙留平
 * @since : 2019年5月10日 下午5:59:08
 * @see:
 */
package com.tianque.mock.server.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.tianque.mock.server.model.ApplicationInfo;
import com.tianque.mock.server.service.ApplicationInfoService;

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
@Api("应用信息相关API")
@RequestMapping("/applicationInfo")
public class ApplicationInfoControllerImpl {

	private static final Logger logger = LoggerFactory
	        .getLogger(ApplicationInfoControllerImpl.class);
	@Autowired
	private ApplicationInfoService applicationInfoService;

	@GetMapping(value = "/getList")
	@ResponseBody
	@ApiOperation(value = "查询应用信息列表")
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没有填好"),
	        @ApiResponse(code = 404, message = "页面查找失败，路径不对") })
	public ResponseData getList() {
		List<ApplicationInfo> applicationInfoList = applicationInfoService
		        .getList();
		return ResponseData.getSuccessResult(applicationInfoList,
		        applicationInfoList.size());
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
	@ApiOperation(value = "根据key名称查询应用信息")
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没有填好"),
	        @ApiResponse(code = 404, message = "页面查找失败，路径不对") })
	public ResponseData searchList(
	        @RequestParam("searchContent") String searchContent) {
		List<ApplicationInfo> applicationInfoPage = applicationInfoService
		        .searchApplicationInfosBySearchContent(searchContent);
		return ResponseData.getSuccessResult(applicationInfoPage,
		        applicationInfoPage.size());
	}

	/**
	 * 添加应用信息
	 * 
	 * @see :
	 * @param :
	 * @return : ResponseData
	 * @param applicationInfo
	 */
	@PostMapping(value = "/addApplicationInfo")
	@ApiOperation(value = "添加应用信息")
	@ResponseBody
	public ResponseData addApplicationInfo(
	        @ModelAttribute ApplicationInfo applicationInfo) {
		return ResponseData.getSuccessResult(
		        applicationInfoService.addApplicationInfo(applicationInfo));
	}

	/**
	 * 更新应用信息
	 * 
	 * @see :
	 * @param :
	 * @return : ResponseData
	 * @param applicationInfo
	 */
	@PostMapping(value = "/updateApplicationInfo")
	@ApiOperation(value = "修改应用信息")
	@ResponseBody
	public ResponseData updateApplicationInfo(
	        @ModelAttribute ApplicationInfo applicationInfo) {
		return ResponseData.getSuccessResult(
		        applicationInfoService.updateApplicationInfo(applicationInfo));
	}

	/**
	 * 删除应用信息-单个
	 * 
	 * @see :
	 * @param :
	 * @return : ResponseData
	 * @param id
	 */
	@PostMapping(value = "/deleteApplicationInfo")
	@ApiOperation(value = "删除应用信息")
	@ResponseBody
	public ResponseData deleteApplicationInfo(@RequestParam("id") Long id) {
		return ResponseData.getSuccessResult(
		        applicationInfoService.deleteApplicationInfo(id));
	}

	/**
	 * 批量删除应用信息
	 * 
	 * @see :
	 * @param :
	 * @return : ResponseData
	 * @param ids
	 * @return
	 */
	@PostMapping(value = "/deleteApplicationInfoInBatch")
	@ApiOperation(value = "批量删除应用信息")
	@ResponseBody
	public ResponseData deleteApplicationInfoInBatch(
	        @RequestParam("ids[]") Long[] ids) {
		applicationInfoService.deleteApplicationInfo(ids);
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
		return ResponseData.getSuccessResult(
		        applicationInfoService.selectByPrimaryKey(id));
	}
}