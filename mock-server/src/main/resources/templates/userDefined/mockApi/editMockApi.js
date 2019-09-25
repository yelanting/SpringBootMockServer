layui.use([
		'form', 'layer', 'layedit', 'laydate', 'upload'
], function() {
	var form = layui.form
	layer = parent.layer === undefined ? layui.layer : top.layer,
			laypage = layui.laypage, upload = layui.upload,
			layedit = layui.layedit, laydate = layui.laydate, $ = layui.jquery;

	form.verify({
		paramKey : function(val) {
			var inputName = "参数Key"
			return checkInputEmpty(val, inputName)
					|| checkInputLength(val, null, 50, inputName)
		},

		paramValue : function(val) {
			var inputName =  "参数值";
			return checkInputEmpty(val, inputName) ||checkInputLength(val, null, 500,inputName)
		},
		
		paramComment : function(val) {
			return checkInputLength(val, null, 500, "参数描述")
		},
	});
	
	/**
	 * 获取页面的id
	 * 
	 */
	function getParentId() {
		let searchContent = window.location.search;
		let targetId = getValueOfKeyFromWindowLocationSearch("id" , searchContent);
		return targetId;
	}
	
	
	/**
	 * 渲染应用信息
	 */
	(function(){
		/**
		 * 如果是sftp的话，请求服务器信息刷新select
		 */
		let detail = getCurrentTableData(getParentId());
		
		if (!detail.data.applicationId) {
			initApplicationInfoSelect();
		}else{
			initApplicationInfoSelectById(detail.data.applicationId);
		}
	})()
	
	
	form.on("submit(editMockApiSubmit)", function(data) {
		// 弹出loading
		var index = top.layer.msg('数据提交中，请稍候', {
			icon : 16, time : false, shade : 0.8
		});
		
		var postData = $("#editMockApiForm").serialize();
		
		// 实际使用时的提交信息
		$.post("/mockApi/updateMockApi", postData, function(response) {
			if (response.success == "false" || !response.success) {
				if (response.msg != "null") {
					top.layer.msg("修改失败:" + response.msg);
				} else {
					top.layer.msg("修改失败,原因未知！");
				}
			} else {
				setTimeout(function() {
					top.layer.close(index);
					top.layer.msg("修改成功！");
					layer.closeAll("iframe");
					// 刷新父页面
					parent.location.reload();
				}, 500);
			}
		});
		return false;
	})
});