package com.dl.demo.sys.adminsysuser;

import java.security.Principal;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dl.demo.common.ResInfo;
import com.dl.demo.common.base.Page;

/**
 * @类说明:用户数据控制器层
 * @author:高振中
 * @date:2018-08-10 09:21:48
 **/
@RestController
@RequestMapping("/api/adminSysUser")
public class AdminSysUserController {
	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private AdminSysUserService service; // 注入用户数据逻辑层
	/**
	 * @方法说明:验证方法
	 **/
	@PostMapping("validatePhone")
	public ResInfo<?> validate(@RequestBody AdminSysUserCond cond, Principal principal) {
		// 此处写验证逻辑
		if (service.queryCount(cond) > 0) {
			return new ResInfo<>(1, "手机号不能重复!");
		}
		return new ResInfo<>(0);
	}
	/**
	 * @方法说明:新增用户记录
	 **/
	@PostMapping("save")
	public int save(@RequestBody AdminSysUser adminSysUser) {
		return service.save(adminSysUser);
	}

	/**
	 * @方法说明:删除用户记录(多条)
	 **/
	@PostMapping("delete")
	public int delete(@RequestParam("ids[]") Integer ids[]) {
		return service.delete(ids);
	}

	/**
	 * @方法说明:修改用户记录
	 **/
	@PostMapping("update")
	public int update(@RequestBody AdminSysUser adminSysUser) {
		return service.update(adminSysUser);
	}

	/**
	 * @方法说明:按条件查询分页用户列表
	 **/
	@PostMapping("queryPage")
	public Page<AdminSysUser> queryPage(@RequestBody AdminSysUserCond cond) {
		return service.queryPage(cond);
	}

	/**
	 * @方法说明:按条件查询不分页用户列表
	 **/
	@PostMapping("queryList")
	public List<AdminSysUser> queryList(@RequestBody AdminSysUserCond cond) {
		return service.queryList(cond);
	}

	/**
	 * @方法说明:按主键查单个用户记录
	 **/
	// @PostMapping("findById")
	// public AdminSysUser findById(@RequestParam("id") Integer id) {
	// return service.findById(id);
	// }

	/**
	 * @方法说明:按条件查询用户记录个数
	 **/
	@PostMapping("queryCount")
	public long queryCount(@RequestBody AdminSysUserCond cond) {
		return service.queryCount(cond);
	}

	/**
	 * @方法说明:重置用户密码
	 **/
	@PostMapping("updatePassword")
	int updatePassword(@RequestParam("user_id")Integer user_id,@RequestParam("password")String password){
		return service.updatePassword(user_id,password);
	}
}