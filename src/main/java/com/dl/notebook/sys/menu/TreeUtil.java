package com.dl.notebook.sys.menu;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;



public class TreeUtil {

	public static List<Menu> asTree(List<Menu> List) {
		Map<Long, Menu> treeMap = Maps.newHashMap();// 用map来定位上级结点
		List<Menu> treeList = Lists.newArrayList();// 最终返回的treelist
		for (Menu menu : List) {
			treeMap.put(menu.getId(), menu);// 将vo放到map中
			if (menu.getParent_id() == 0L) {// 如果是根结点直接放到treeList中
				treeList.add(menu);
			}
			if (treeMap.get(menu.getParent_id()) != null) {
				treeMap.get(menu.getParent_id()).getChildren().add(menu);// children
			}
		}
		treeMap.clear();
		return treeList;
	}

}
