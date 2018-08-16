package com.dl.notebook.sys.menu;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dl.notebook.common.base.Page;

/**
 * @类说明:sys_menu数据控制器层
 * @author:高振中
 * @date:2018-04-22 23:23:06
 **/
@RestController
@RequestMapping("api/menu")
public class MenuController {
	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private MenuService service; // 注入sys_menu数据逻辑层

	/**
	 * @方法说明:新增sys_menu记录
	 **/
	@PostMapping("save")
	public long save(@RequestBody Menu menu) {
		return service.save(menu);
	}

	/**
	 * @方法说明:删除sys_menu记录(多条)
	 **/
	@DeleteMapping("delete")
	public int delete(@RequestParam("ids[]") Long ids[]) {
		return service.delete(ids);
	}

	/**
	 * @方法说明:修改sys_menu记录
	 **/
	@PostMapping("update")
	public int update(@RequestBody Menu menu) {
		return service.update(menu);
	}

	/**
	 * @方法说明:按条件查询分页sys_menu列表
	 **/
	@PostMapping("queryPage")
	public Page<Menu> queryPage(@RequestBody MenuCond cond) {
		return service.queryPage(cond);
	}

	/**
	 * @方法说明:按条件查询不分页sys_menu列表
	 **/
	@PostMapping("queryList")
	public List<Menu> queryList() {
		return service.queryList();
	}

	/**
	 * @方法说明:按主键查单个sys_menu记录
	 **/
	@PostMapping("findById")
	public Menu findById(@RequestParam("id") Long id) {
		return service.findById(id);
	}

	/**
	 * @方法说明:按条件查询sys_menu记录个数
	 **/
	@PostMapping("queryCount")
	public long queryCount(@RequestBody MenuCond cond) {
		return service.queryCount(cond);
	}
}