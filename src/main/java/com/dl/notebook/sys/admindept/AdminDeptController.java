package com.dl.notebook.sys.admindept;

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
 * @类说明:部门数据控制器层
 * @author:高振中
 * @date:2018-08-10 09:21:48
 **/
@RestController
@RequestMapping("/api/adminDept")
public class AdminDeptController {
	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private AdminDeptService service; // 注入部门数据逻辑层
	/**
	 * @方法说明:验证方法
	 **/
	@PostMapping("validate")
	public ResInfo<?> validate(@RequestBody AdminDeptCond cond, Principal principal) {
		if (service.queryCount(cond) > 0) {
			return new ResInfo<>(1, "菜单名称不能重复!");
		}
		return new ResInfo<>(0);
	}
	/**
	 * @方法说明:新增部门记录
	 **/
	@PostMapping("save")
	public int save(@RequestBody AdminDept adminDept) {
		return service.save(adminDept);
	}

	/**
	 * @方法说明:删除部门记录(多条)
	 **/
	@PostMapping("delete")
	public int delete(@RequestParam("ids[]") Integer ids[]) {
		return service.delete(ids);
	}

	/**
	 * @方法说明:修改部门记录
	 **/
	@PostMapping("update")
	public int update(@RequestBody AdminDept adminDept) {
		return service.update(adminDept);
	}

	/**
	 * @方法说明:按条件查询不分页部门列表
	 **/
	@PostMapping("queryList")
	public List<AdminDept> queryList(@RequestBody AdminDeptCond cond) {
		return service.queryList(cond);
	}

	/**
	 * @方法说明:按条件查询部门记录个数
	 **/
	@PostMapping("queryCount")
	public long queryCount(@RequestBody AdminDeptCond cond) {
		return service.queryCount(cond);
	}
}