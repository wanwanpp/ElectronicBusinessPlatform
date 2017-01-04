package com.wq.core.dao.product;

import com.wq.core.bean.product.Brand;
import com.wq.core.query.product.BrandQuery;

import java.util.List;

/**
 * Created by 王萍 on 2016/12/30 0030.
 */
public interface BrandDao {

    public List<Brand> getBrandList(BrandQuery brandQuery);

    public Integer addBrand(Brand brand);

    public void deleteBrandById(Integer id);

    public void deleteBrandByIds(Integer[] ids);

    public Brand getBrandById(Integer id);

    public void updateBrand(Brand brand);
}
