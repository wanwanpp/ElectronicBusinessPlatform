package com.wq.core.query.product;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王萍 on 2017/1/3 0003.
 */

@Getter
@Setter
public class BrandQuery {

    private Integer id;
    private String name;
    private String description;
    private String imgUrl;
    private String webSite;
    private Integer sort;
    private Integer isDisplay;


    private boolean nameLike;
    /***********查询字段指定*************************************/
    private String fields;
    private final static int DEFAULT_SIZE=10;
    public int pageSize = DEFAULT_SIZE;
    private int startRow;
    private int pageNumber;

    public void setPageSize(int pageSize){
        this.pageSize = pageSize;
        this.startRow = (pageSize-1)*this.pageSize;
    }

    public void setPageNumber(int pageNumber){
        this.pageNumber = pageNumber;
        this.startRow = (pageSize-1)*this.pageSize;
    }


    public boolean isNameLike() {
        return nameLike;
    }


    @Getter
    @Setter
    public class OrderField {

//        字段
        private String fieldName;
//        字段按什么顺序排
        private String order;

        public OrderField(String fieldName, String order) {
            super();
            this.fieldName = fieldName;
            this.order = order;
        }
    }

    private List<OrderField> orderFields = new ArrayList<OrderField>();

    public void orderByName(boolean isAsc) {
        orderFields.add(new OrderField("name", isAsc ? "asc" : "desc"));
    }

    public void orderById(boolean isAsc) {
        orderFields.add(new OrderField("id", isAsc ? "asc" : "desc"));
    }
}
