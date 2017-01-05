package com.wq.core.dao.product;

import com.wq.core.bean.product.Feature;
import com.wq.core.query.product.FeatureQuery;

import java.util.List;

/**
 * Created by 王萍 on 2017/1/4 0004.
 */
public interface FeatureDao {

    public List<Feature> getFeatureList(FeatureQuery featureQuery);
}
