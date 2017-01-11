package com.wq.core.dao.user;


import com.wq.core.bean.user.Addr;
import com.wq.core.query.user.AddrQuery;

import java.util.List;

public interface AddrDao {

	/**
	 * 添加
	 * @param addr
	 */
	public Integer addAddr(Addr addr);

	/**
	 * 根据主键查找
	 */
	public Addr getAddrByKey(Integer id);

	/**
	 * 根据主键批量查找
	 */
	public List<Addr> getAddrsByKeys(List<Integer> idList);

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
	public Integer updateAddrByKey(Addr addr);

	/**
	 * 分页查询
	 * @param addrQuery
	 */
	public List<Addr> getAddrListWithPage(AddrQuery addrQuery);

	/**
	 * 集合查询
	 * @param addrQuery
	 */
	public List<Addr> getAddrList(AddrQuery addrQuery);
	
	/**
	 * 总条数
	 * @param addrQuery
	 */
	public int getAddrListCount(AddrQuery addrQuery);
}
