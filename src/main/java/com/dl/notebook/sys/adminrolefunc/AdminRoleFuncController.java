package com.dl.notebook.sys.adminrolefunc;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dl.notebook.sys.adminfunc.AdminFunc;

/**
 * @类说明:角色菜单(功能权限)数据控制器层
 * @author:高振中
 * @date:2018-08-10 09:21:48
 **/
@RestController
@RequestMapping("/api/adminRoleFunc")
public class AdminRoleFuncController {
	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private AdminRoleFuncService service; // 注入角色菜单(功能权限)数据逻辑层

	/**
	 * @方法说明:按条件查询不分页角色菜单(功能权限)列表
	 **/
	@PostMapping("queryList")
	public List<AdminRoleFunc> queryList(@RequestBody AdminRoleFuncCond cond) {
		return service.queryList(cond);
	}

	/**
	 * @方法说明:批量插入角色菜单记录
	 **/
	@PostMapping("insertBatch")
	public int[] insertBatch(@RequestBody List<AdminRoleFunc> list, @RequestParam("role_id") int role_id) {
		return service.insertBatch(list, role_id);
	}

	/**
	 * @方法说明:某一用户所拥有的相关菜单
	 **/
	@PostMapping("queryFunc")
	public List<AdminFunc> queryFunc(@RequestParam("user_id") Integer user_id) {
		return service.queryFunc(user_id);
	}
}