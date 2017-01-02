package com.wq.core.dao.product;

import com.wq.core.bean.product.Brand;

import java.util.List;

/**
 * Created by 王萍 on 2016/12/30 0030.
 */
public interface BrandDao {

    public List<Brand> getBrandList(Brand brand);
}
