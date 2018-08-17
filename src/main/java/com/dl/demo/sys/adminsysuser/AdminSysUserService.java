package com.dl.demo.sys.adminsysuser;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dl.demo.common.MD5Util;
import com.dl.demo.common.base.Page;

/**
 * @类说明:用户数据逻辑层
 * @author:高振中
 * @date:2018-08-10 09:21:48
 **/
@Service
public class AdminSysUserService {
	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private AdminSysUserDao dao; // 注入用户数据访问层

	/**
	 * @方法说明:新增用户记录
	 **/
	@Transactional
	public int save(AdminSysUser adminSysUser) {
		adminSysUser.setPassword(MD5Util.getMD5("888888"));
		return dao.save(adminSysUser);
	}

	/**
	 * @方法说明:删除用户记录(多条)
	 **/
	public int delete(Integer ids[]) {
		// return dao.deleteLogic(ids);//逻辑删除
		return dao.delete(ids);// 物理删除
	}

	/**
	 * @方法说明:更新用户记录
	 **/
	@Transactional
	public int update(AdminSysUser adminSysUser) {
		return dao.update(adminSysUser);
	}

	/**
	 * @方法说明:按条件查询分页用户列表
	 **/
	public Page<AdminSysUser> queryPage(AdminSysUserCond cond) {
		return dao.queryPage(cond);
	}

	/**
	 * @方法说明:按条件查询不分页用户列表(使用范型)
	 **/
	public List<AdminSysUser> queryList(AdminSysUserCond cond) {
		return dao.queryList(cond);
	}

	/**
	 * @方法说明:按ID查找单个用户记录
	 **/
	// public AdminSysUser findById(Integer id) {
	// return dao.findById(id);
	// }

	/**
	 * @方法说明:按条件查询用户记录个数
	 **/
	public long queryCount(AdminSysUserCond cond) {
		return dao.queryCount(cond);
	}

	/**
	 * @方法说明:重置用户密码
	 **/
	int updatePassword(Integer user_id, String password) {
		return dao.updatePassword(user_id, MD5Util.getMD5(password));
	}
}