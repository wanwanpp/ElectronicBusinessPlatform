package com.wq.core.service.product;

import com.wq.core.bean.product.Brand;

import java.util.List;

/**
 * Created by 王萍 on 2016/12/30 0030.
 */
public interface BrandService {

    public List<Brand> getBrandList(Brand brand);

    public Integer addBrand(Brand brand);

    public void deleteBrandById(Integer id);

    public void deleteBrandByIds(Integer[] ids);

    public Brand getBrandById(Integer id);

    public void updateBrand(Brand brand);

}
