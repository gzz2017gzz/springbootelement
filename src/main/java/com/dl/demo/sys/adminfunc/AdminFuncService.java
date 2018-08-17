package com.dl.demo.sys.adminfunc;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @类说明:菜单数据逻辑层
 * @author:高振中
 * @date:2018-08-10 09:21:48
 **/
@Service
public class AdminFuncService {
	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private AdminFuncDao dao; // 注入菜单数据访问层

	/**
	 * @方法说明:新增菜单记录
	 **/
	@Transactional
	public int save(AdminFunc adminFunc) {
		return dao.save(adminFunc);
	}

	/**
	 * @方法说明:删除菜单记录(多条)
	 **/
	public int delete(Integer ids[]) {
		// return dao.deleteLogic(ids);//逻辑删除
		return dao.delete(ids);// 物理删除
	}

	/**
	 * @方法说明:更新菜单记录
	 **/
	@Transactional
	public int update(AdminFunc adminFunc) {
		return dao.update(adminFunc);
	}

	/**
	 * @方法说明:按条件查询不分页菜单列表(使用范型)
	 **/
	public List<AdminFunc> queryList(AdminFuncCond cond) {
		List<AdminFunc> list = dao.queryList(cond) ;
		Map<Integer, AdminFunc> treeMap = Maps.newHashMap();// 用map来定位上级结点
		List<AdminFunc> treeList = Lists.newArrayList();// 最终返回的treelist
		for (AdminFunc dept : list) {
			treeMap.put(dept.getFunc_id(), dept);// 将vo放到map中
			if (dept.getParent_id() == 0) {// 如果是根结点直接放到treeList中
				treeList.add(dept);
			}
			if (treeMap.get(dept.getParent_id()) != null) {
				treeMap.get(dept.getParent_id()).getChildren().add(dept);// children
			}
		}
		treeMap.clear();
		return treeList;
	}

	/**
	 * @方法说明:按条件查询菜单记录个数
	 **/
	public long queryCount(AdminFuncCond cond) {
		return dao.queryCount(cond);
	}
}