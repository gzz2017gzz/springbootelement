package com.dl.notebook.sys.menu;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dl.notebook.common.base.Page;

/**
 * @类说明:sys_menu数据逻辑层
 * @author:高振中
 * @date:2018-04-22 23:23:06
 **/
@Service
public class MenuService {
	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private MenuDao dao; // 注入sys_menu数据访问层

	/**
	 * @方法说明:新增sys_menu记录
	 **/
	@Transactional
	public long save(Menu menu) {
		return dao.saveReturnPK(menu);
	}

	/**
	 * @方法说明:删除sys_menu记录(多条)
	 **/
	public int delete(Long ids[]) {
		// return dao.deleteLogic(ids);//逻辑删除
		return dao.delete(ids);// 物理删除
	}

	/**
	 * @方法说明:按ID查找单个sys_menu记录
	 **/
	public Menu findById(Long id) {
		return dao.findById(id);
	}

	/**
	 * @方法说明:更新sys_menu记录
	 **/
	@Transactional
	public int update(Menu menu) {
		return dao.update(menu);
	}

	/**
	 * @方法说明:按条件查询分页sys_menu列表
	 **/
	public Page<Menu> queryPage(MenuCond cond) {
		return dao.queryPage(cond);
	}

	/**
	 * @方法说明:按条件查询不分页sys_menu列表(使用范型)
	 **/
	public List<Menu> queryList() {
		List<Menu> list = dao.queryList(new MenuCond());

		return TreeUtil.asTree(list);
	}

	/**
	 * @方法说明:按条件查询sys_menu记录个数
	 **/
	public long queryCount(MenuCond cond) {
		return dao.queryCount(cond);
	}
}