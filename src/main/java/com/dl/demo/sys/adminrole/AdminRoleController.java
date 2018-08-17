package com.dl.demo.sys.adminrole;

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
 * @类说明:角色数据控制器层
 * @author:高振中
 * @date:2018-08-10 09:21:48
 **/
@RestController
@RequestMapping("/api/adminRole")
public class AdminRoleController {
	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private AdminRoleService service; // 注入角色数据逻辑层

	/**
	 * @方法说明:新增角色记录
	 **/
	@PostMapping("save")
	public int save(@RequestBody AdminRole adminRole) {
		return service.save(adminRole);
	}

	/**
	 * @方法说明:验证方法
	 **/
	@PostMapping("validateName")
	public ResInfo<?> validate(@RequestBody AdminRoleCond cond, Principal principal) {
		if (service.queryCount(cond) > 0) {
			return new ResInfo<>(1, "角色名称不能重复!");
		}
		return new ResInfo<>(0);
	}

	/**
	 * @方法说明:删除角色记录(多条)
	 **/
	@PostMapping("delete")
	public int delete(@RequestParam("ids[]") Integer ids[]) {
		return service.delete(ids);
	}

	/**
	 * @方法说明:修改角色记录
	 **/
	@PostMapping("update")
	public int update(@RequestBody AdminRole adminRole) {
		return service.update(adminRole);
	}

	/**
	 * @方法说明:按条件查询分页角色列表
	 **/
	@PostMapping("queryPage")
	public Page<AdminRole> queryPage(@RequestBody AdminRoleCond cond) {
		return service.queryPage(cond);
	}

	/**
	 * @方法说明:按条件查询角色记录个数
	 **/
	@PostMapping("queryCount")
	public long queryCount(@RequestBody AdminRoleCond cond) {
		return service.queryCount(cond);
	}

	/**
	 * @方法说明:按条件查询不分页角色列表
	 **/
	@PostMapping("queryList")
	public List<AdminRole> queryList(@RequestBody AdminRoleCond cond) {
		return service.queryList(cond);
	}
}