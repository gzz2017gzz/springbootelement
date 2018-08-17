package com.dl.demo.sys.adminroledept;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dl.demo.sys.admindept.AdminDept;

/**
 * @类说明:角色部门数据逻辑层
 * @author:高振中
 * @date:2018-08-10 09:21:48
 **/
@Service
public class AdminRoleDeptService {
	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private AdminRoleDeptDao dao; // 注入角色部门数据访问层

	/**
	 * @方法说明:批量插入角色部门记录
	 **/
	@Transactional
	public int[] insertBatch(List<AdminRoleDept> list, Integer role_id) {
		dao.delete(role_id);
		return dao.insertBatch(list);
	}

	/**
	 * @方法说明:按条件查询不分页角色部门列表(使用范型)
	 **/
	public List<AdminRoleDept> queryList(AdminRoleDeptCond cond) {
		return dao.queryList(cond);
	}

	/**
	 * @方法说明:按人员主键查询数据授权信息
	 **/
	public List<AdminDept> queryAuthDepts(Integer user_id) {
		return dao.queryAuthDepts(user_id);
	}
}