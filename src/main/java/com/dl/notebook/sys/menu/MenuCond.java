package com.dl.notebook.sys.menu;
import com.dl.notebook.common.base.BaseCondition;

import lombok.Getter;
import lombok.Setter;

/**
 * @类说明:sys_menu查询条件实体类
 * @author:高振中
 * @date:2018-04-22 23:23:06
 **/
@Setter
@Getter
public class MenuCond extends BaseCondition {

	/**
	 * @方法说明:拼加自定义条件 
	 **/
	@Override
	public void addCondition() { 
		//add(id, "AND t.id = ?");
		//add(icon, "AND t.icon LIKE ?", 3);
		//add(parent_id, "AND t.parent_id = ?");
		//add(tip, "AND t.tip LIKE ?", 3);
		//add(title, "AND t.title LIKE ?", 3);
		//add(url, "AND t.url LIKE ?", 3);
		//add(ids, "AND t.id IN ");
	}

	//查询条件,把不用的条件清理掉
	private Long id;// id
	private String icon;// icon
	private Long parent_id;// parent_id
	private String tip;// tip
	private String title;// title
	private String url;// url
	//private List<Long> ids;// 主键列表

}