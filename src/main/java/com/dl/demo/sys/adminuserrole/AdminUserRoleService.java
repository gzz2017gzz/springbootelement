package com.dl.demo.sys.adminuserrole;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @类说明:用户角色数据逻辑层
 * @author:高振中
 * @date:2018-08-10 09:21:48
 **/
@Service
public class AdminUserRoleService {
	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private AdminUserRoleDao dao; // 注入用户角色数据访问层

	/**
	 * @方法说明:按条件查询不分页用户角色列表(使用范型)
	 **/
	public List<AdminUserRole> queryList(AdminUserRoleCond cond) {
		return dao.queryList(cond);
	}

	/**
	 * @方法说明:批量插入用户角色记录
	 **/
	@Transactional
	public int[] insertBatch(List<AdminUserRole> list, int user_id) {
		dao.delete(user_id);// 物理删除
		return dao.insertBatch(list);
	}
}