package com.dl.notebook.sys.adminuserrole;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @类说明:用户角色数据控制器层
 * @author:高振中
 * @date:2018-08-10 09:21:48
 **/
@RestController
@RequestMapping("/api/adminUserRole")
public class AdminUserRoleController {
	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private AdminUserRoleService service; // 注入用户角色数据逻辑层

	/**
	 * @方法说明:批量插入用户角色记录
	 **/
	@PostMapping("insertBatch")
	public int[] insertBatch(@RequestBody List<AdminUserRole> list, @RequestParam("user_id") int user_id) {
		return service.insertBatch(list, user_id);
	}

	/**
	 * @方法说明:按条件查询不分页用户角色列表
	 **/
	@PostMapping("queryList")
	public List<AdminUserRole> queryList(@RequestBody AdminUserRoleCond cond) {
		return service.queryList(cond);
	}

}