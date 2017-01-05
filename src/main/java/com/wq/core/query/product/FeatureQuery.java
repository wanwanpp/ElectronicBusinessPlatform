package com.wq.core.query.product;

import com.wq.common.database.OrderField;
import com.wq.core.query.BaseQuery;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王萍 on 2017/1/4 0004.
 */

@Getter
@Setter
public class FeatureQuery extends BaseQuery {

    private Integer id;
    private String name;
    private String value;
    private Integer sort;
    private Integer idDel;

    private List<OrderField> orderFields = new ArrayList<OrderField>();
}
