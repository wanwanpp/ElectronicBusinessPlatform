package com.wq.core.service.product.impl;

import com.wq.core.bean.product.Type;
import com.wq.core.dao.product.TypeDao;
import com.wq.core.query.product.TypeQuery;
import com.wq.core.service.product.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 王萍 on 2017/1/4 0004.
 */

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    public List<Type> getTypeList(TypeQuery typeQuery) {
        return typeDao.getTypeList(typeQuery);
    }
}
