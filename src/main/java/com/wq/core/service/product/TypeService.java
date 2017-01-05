package com.wq.core.service.product;

import com.wq.core.bean.product.Type;
import com.wq.core.query.product.TypeQuery;

import java.util.List;

/**
 * Created by 王萍 on 2017/1/4 0004.
 */
public interface TypeService {

    public List<Type> getTypeList(TypeQuery typeQuery);
}
