package com.wq.core.service.country;


import com.wq.common.page.Pagination;
import com.wq.core.bean.country.City;
import com.wq.core.query.country.CityQuery;

import java.util.List;

/**
 * 
 * @author lixu
 * @Date [2014-3-28 下午01:50:28]
 */
public interface CityService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addCity(City city);

	/**
	 * 根据主键查询
	 */
	public City getCityByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<City> getCitysByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * 
	 * @return
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateCityByKey(City city);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param cityQuery
	 *            查询条件
	 * @return
	 */
	public Pagination getCityListWithPage(CityQuery cityQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param cityQuery
	 *            查询条件
	 * @return
	 */
	public List<City> getCityList(CityQuery cityQuery);
}
