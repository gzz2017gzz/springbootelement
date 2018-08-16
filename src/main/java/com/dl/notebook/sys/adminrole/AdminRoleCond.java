package com.dl.notebook.sys.adminrole;
import com.dl.notebook.common.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @类说明:角色查询条件实体类
 * @author:高振中
 * @date:2018-08-10 09:21:48
 **/
@Setter
@Getter
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminRoleCond extends BaseCondition {

	/**
	 * @方法说明:拼加自定义条件 
	 **/
	@Override
	public void addCondition() { 
		add(id, "AND t.id <> ?");
		add(name, "AND t.name LIKE ?", 3);
		add(remark, "AND t.remark LIKE ?", 3);
		//add(ids, "AND t.id IN ");
	}

	//查询条件,把不用的条件清理掉
	private Integer id;// 主键不等于
	private String name;// 名称
	private String remark;// 备注
	//private List<Long> ids;// 主键列表

}