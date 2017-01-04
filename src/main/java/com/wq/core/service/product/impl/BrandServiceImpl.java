package com.wq.core.service.product.impl;

import com.wq.core.bean.product.Brand;
import com.wq.core.dao.product.BrandDao;
import com.wq.core.query.product.BrandQuery;
import com.wq.core.service.product.BrandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 王萍 on 2016/12/30 0030.
 */

@Service
@Transactional
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandDao brandDao;

    public List<Brand> getBrandList(BrandQuery brandQuery) {
        return brandDao.getBrandList(brandQuery);
    }

    public Integer addBrand(Brand brand) {
        return brandDao.addBrand(brand);
    }

    public void deleteBrandById(Integer id) {
         brandDao.deleteBrandById(id);
    }

    public void deleteBrandByIds(Integer[] ids) {
        brandDao.deleteBrandByIds(ids);
    }

    public Brand getBrandById(Integer id) {
        return brandDao.getBrandById(id);
    }

    public void updateBrand(Brand brand) {
        brandDao.updateBrand(brand);
    }
}
