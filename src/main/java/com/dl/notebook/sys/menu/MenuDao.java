package com.dl.notebook.sys.menu;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.dl.notebook.common.base.BaseDao;
import com.dl.notebook.common.base.Page;
import com.dl.notebook.common.base.SqlUtil;

/**
 * @类说明:sys_menu数据访问层
 * @author:高振中
 * @date:2018-04-22 23:23:06
 **/
@Repository
public class MenuDao extends BaseDao {
	private StringBuilder select = new StringBuilder();
	private StringBuilder insert = new StringBuilder();

	/**
	 * @方法说明:构造方法,用于拼加SQL及初始化工作
	 **/
	public MenuDao() {
		select.append("SELECT t.id,t.icon,t.parent_id,t.tip,t.title,t.url");
		select.append(" FROM sys_menu t WHERE 1=1");

		insert.append("INSERT INTO sys_menu (icon,parent_id,tip,title,url)");
		insert.append(" VALUES (:icon,:parent_id,:tip,:title,:url)");
	}


	/**
	 * @方法说明:新增sys_menu记录并返回自增涨主键值
	 **/
	public long saveReturnPK(Menu vo) {
		return saveKey(vo, insert.toString(), "id");
	}

	/**
	 * @方法说明:批量插入sys_menu记录
	 **/
	public int[] insertBatch(List<Menu> list) {
		return batchOperate(list, insert.toString());
	}

	/**
	 * @方法说明:物理删除sys_menu记录(多条)
	 **/
	public int delete(Long ids[]) {
		String sql = "DELETE FROM sys_menu WHERE id" + SqlUtil.ArrayToIn(ids);
		return jdbcTemplate.update(sql);
	}

	/**
	 * @方法说明:按ID查找单个sys_menu实体
	 **/
	public Menu findById(Long id) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(" AND t.id=?");
		return jdbcTemplate.queryForObject(sb.toString(), new Object[] { id }, new BeanPropertyRowMapper<>(Menu.class));
	}

	/**
	 * @方法说明:更新sys_menu记录
	 **/
	public int update(Menu vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE sys_menu SET icon=?,parent_id=?,tip=?,title=?,url=?");
		sql.append(" WHERE id=? ");
		Object[] params = { vo.getIcon(), vo.getParent_id(), vo.getTip(), vo.getTitle(), vo.getUrl(), vo.getId() };
		return jdbcTemplate.update(sql.toString(), params);
	}

	/**
	 * @方法说明:按条件查询分页sys_menu列表
	 **/
	public Page<Menu> queryPage(MenuCond cond) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(cond.getCondition());
		// sb.append(cond.getOrderSql());//增加排序子句;
		// logger.info(SqlUtil.showSql(sb.toString(),cond.getArray()));//显示SQL语句
		return queryPage(sb.toString(), cond, Menu.class);
	}

	/**
	 * @方法说明:按条件查询不分页sys_menu列表
	 **/
	public List<Menu> queryList(MenuCond cond) {
		StringBuilder sb = new StringBuilder(select);
		sb.append(cond.getCondition());
		sb.append(" ORDER BY id ASC");
		return jdbcTemplate.query(sb.toString(), cond.getArray(), new BeanPropertyRowMapper<>(Menu.class));
	}

	/**
	 * @方法说明:按条件查询sys_menu记录个数
	 **/
	public long queryCount(MenuCond cond) {
		String countSql = "SELECT COUNT(1) FROM sys_menu t WHERE 1=1" + cond.getCondition();
		return jdbcTemplate.queryForObject(countSql, cond.getArray(), Long.class);
	}

	/**
	 * @方法说明:逻辑删除sys_menu记录(多条)
	 **/
	public int deleteLogic(Long ids[]) {
		String sql = "UPDATE sys_menu SET delete_remark=1 WHERE id" + SqlUtil.ArrayToIn(ids);
		return jdbcTemplate.update(sql);
	}
}