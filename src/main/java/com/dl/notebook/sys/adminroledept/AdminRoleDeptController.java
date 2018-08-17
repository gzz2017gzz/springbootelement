package com.dl.notebook.sys.adminroledept;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dl.notebook.sys.admindept.AdminDept;

/**
 * @类说明:角色部门数据控制器层
 * @author:高振中
 * @date:2018-08-10 09:21:48
 **/
@RestController
@RequestMapping("/api/adminRoleDept")
public class AdminRoleDeptController {
	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private AdminRoleDeptService service; // 注入角色部门数据逻辑层

	/**
	 * @方法说明:删除角色部门记录
	 **/
	@PostMapping("insertBatch")
	public int[] insertBatch(@RequestBody List<AdminRoleDept> list, @RequestParam("role_id") Integer role_id) {
		return service.insertBatch(list, role_id);
	}

	/**
	 * @方法说明:按条件查询不分页角色部门列表
	 **/
	@PostMapping("queryList")
	public List<AdminRoleDept> queryList(@RequestBody AdminRoleDeptCond cond) {
		return service.queryList(cond);
	}

	/**
	 * @方法说明:按人员主键查询数据授权信息
	 **/
	@PostMapping("queryAuthDepts")
	public List<AdminDept> queryAuthDepts(@RequestParam("user_id") Integer user_id) {
		return service.queryAuthDepts(user_id);
	}
}