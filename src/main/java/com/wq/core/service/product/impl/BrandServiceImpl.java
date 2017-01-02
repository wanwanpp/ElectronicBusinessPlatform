package com.wq.core.service.product.impl;

import com.wq.core.bean.product.Brand;
import com.wq.core.dao.product.BrandDao;
import com.wq.core.service.product.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Brand> getBrandList(Brand brand) {
        return brandDao.getBrandList(brand);
    }
}
