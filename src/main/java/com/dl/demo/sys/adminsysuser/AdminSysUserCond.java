package com.dl.demo.sys.adminsysuser;

import java.util.List;

import com.dl.demo.common.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @类说明:用户查询条件实体类
 * @author:高振中
 * @date:2018-08-10 09:21:48
 **/
@Setter
@Getter
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class AdminSysUserCond extends BaseCondition {

	/**
	 * @方法说明:拼加自定义条件
	 **/
	@Override
	public void addCondition() {
		add(user_id, "AND t.user_id <> ?");
		add(user_id_eq, "AND t.user_id=?");
		add(name, "AND t.name LIKE ?", 3);
		add(password, "AND t.password = ?");
		add(phone, "AND t.phone LIKE ?", 3);
		add(phone_eq, "AND t.phone = ?");
		add(gender, "AND t.gender = ?");
		// add(status, "AND t.status = ?");
		// add(department_id, "AND t.department_id = ?");
		// add(wechat, "AND t.wechat LIKE ?", 3);
		// add(remark, "AND t.remark LIKE ?", 3);
		add(ids, "AND t.user_id IN ");
	}

	// 查询条件,把不用的条件清理掉
	private Integer user_id;// 主键不等于
	private Integer user_id_eq;// 主键等于
	private String name;// 姓名
	// private Integer code;// 编号
	private String password;// 密码
	private String phone;// 手机号
	private String phone_eq;// 手机号等于
	private Byte gender;// 性别
	private Byte status;// 状态
	private Integer department_id;// 部门ID
	private String wechat;// 微信号
	private String remark;// 备注
	private List<Integer> ids;// 主键列表

}