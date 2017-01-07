package com.wq.core.dao.product;

import com.wq.core.bean.product.Sku;
import com.wq.core.query.product.SkuQuery;

import java.util.List;

/**
 * Created by 王萍 on 2017/1/6 0006.
 */
public interface SkuDao {

    List<Sku> getSkuList(SkuQuery skuQuery);

    Integer updateSku(Sku sku);

    List<Sku> getStock(Integer productId);
}
