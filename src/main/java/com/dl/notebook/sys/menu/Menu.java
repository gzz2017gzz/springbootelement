package com.dl.notebook.sys.menu;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.Data;

/**
 * @类说明:sys_menu实体类
 * @author:高振中
 * @date:2018-04-22 23:23:06
 **/

@Data
public class Menu {

	// 数据库中的字段
	private Long id;// id
	private String icon;// icon
	private Long parent_id;// parent_id
	private String tip;// tip
	private String title;// title
	private String url;// url
	private List<Menu> children = Lists.newArrayList();

}