package com.wq.core.query.product;

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
public class TypeQuery extends BaseQuery {

    private Integer id;
    private String name;
    private Integer parentId;
    private String note;
    private Integer isDisplay;

    @Getter
    @Setter
    public class OrderField{

        private String fieldName;
        private String order;
        public OrderField(String fieldName,String order){
            super();
            this.fieldName=fieldName;
            this.order=order;
        }
    }

    private List<OrderField> orderFields = new ArrayList<OrderField>();
}
