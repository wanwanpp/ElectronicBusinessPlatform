package com.wq.core.service.product.impl;

import com.wq.core.bean.product.Sku;
import com.wq.core.dao.product.SkuDao;
import com.wq.core.query.product.SkuQuery;
import com.wq.core.service.product.ColorService;
import com.wq.core.service.product.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 王萍 on 2017/1/6 0006.
 */

@Service
@Transactional
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuDao skuDao;

    @Autowired
    private ColorService colorService;


    @Transactional(readOnly = true)
    public List<Sku> getSkuList(SkuQuery skuQuery) {
        List<Sku> skus = skuDao.getSkuList(skuQuery);

        for (Sku sku:skus){
            sku.setColor(colorService.getColorById(sku.getId()));
        }
        return skus;
    }

    public Integer updateSku(Sku sku) {
        return skuDao.updateSku(sku);
    }

    @Transactional(readOnly = true)
    public List<Sku> getStock(Integer productId) {
        List<Sku> skus = skuDao.getStock(productId);

        for (Sku sku:skus){
            sku.setColor(colorService.getColorById(sku.getId()));
        }
        return skus;
    }
}
