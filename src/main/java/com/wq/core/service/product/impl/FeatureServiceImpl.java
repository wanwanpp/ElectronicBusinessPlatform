package com.wq.core.service.product.impl;

import com.wq.core.bean.product.Feature;
import com.wq.core.dao.product.FeatureDao;
import com.wq.core.query.product.FeatureQuery;
import com.wq.core.service.product.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 王萍 on 2017/1/4 0004.
 */

@Service
@Transactional
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    private FeatureDao featureDao;
    public List<Feature> getFeatureList(FeatureQuery featureQuery) {

        return featureDao.getFeatureList(featureQuery);
    }
}
