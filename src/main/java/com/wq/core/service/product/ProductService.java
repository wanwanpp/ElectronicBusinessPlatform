package com.wq.core.service.product;

import com.wq.common.page.Pagination;
import com.wq.core.query.product.ProductQuery;

/**
 * Created by 王萍 on 2017/1/4 0004.
 */

public interface ProductService {

    public Pagination getProductListWithPage(ProductQuery productQuery);
}
