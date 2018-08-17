package com.dl.notebook.sys.adminfunc;

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

import com.dl.notebook.common.ResInfo;

/**
 * @类说明:菜单数据控制器层
 * @author:高振中
 * @date:2018-08-10 09:21:48
 **/
@RestController
@RequestMapping("/api/adminFunc")
public class AdminFuncController {
	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private AdminFuncService service; // 注入菜单数据逻辑层

	/**
	 * @方法说明:新增菜单记录
	 **/
	@PostMapping("save")
	public int save(@RequestBody AdminFunc adminFunc) {
		return service.save(adminFunc);
	}
	/**
	 * @方法说明:验证方法
	 **/
	@PostMapping("validate")
	public ResInfo<?> validate(@RequestBody AdminFuncCond cond, Principal principal) {
		if (service.queryCount(cond) > 0) {
			return new ResInfo<>(1, "部门名称不能重复!");
		}
		return new ResInfo<>(0);
	}
	/**
	 * @方法说明:删除菜单记录(多条)
	 **/
	@PostMapping("delete")
	public int delete(@RequestParam("ids[]") Integer ids[]) {
		return service.delete(ids);
	}

	/**
	 * @方法说明:修改菜单记录
	 **/
	@PostMapping("update")
	public int update(@RequestBody AdminFunc adminFunc) {
		return service.update(adminFunc);
	}

	/**
	 * @方法说明:按条件查询不分页菜单列表
	 **/
	@PostMapping("queryList")
	public List<AdminFunc> queryList(@RequestBody AdminFuncCond cond) {
		return service.queryList(cond);
	}

	/**
	 * @方法说明:按条件查询菜单记录个数
	 **/
	@PostMapping("queryCount")
	public long queryCount(@RequestBody AdminFuncCond cond) {
		return service.queryCount(cond);
	}
}