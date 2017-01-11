package com.wq.core.dao.country;


import com.wq.core.bean.country.Town;
import com.wq.core.query.country.TownQuery;

import java.util.List;

public interface TownDao {

	/**
	 * 添加
	 * @param town
	 */
	public Integer addTown(Town town);

	/**
	 * 根据主键查找
	 */
	public Town getTownByKey(Integer id);

	/**
	 * 根据主键批量查找
	 */
	public List<Town> getTownsByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 */
	public Integer updateTownByKey(Town town);

	/**
	 * 分页查询
	 * @param townQuery
	 */
	public List<Town> getTownListWithPage(TownQuery townQuery);

	/**
	 * 集合查询
	 * @param townQuery
	 */
	public List<Town> getTownList(TownQuery townQuery);
	
	/**
	 * 总条数
	 * @param townQuery
	 */
	public int getTownListCount(TownQuery townQuery);
}
