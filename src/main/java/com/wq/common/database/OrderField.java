package com.wq.common.database;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderField {

    private String fieldName;
    private String order;

    public OrderField(String fieldName, String order) {
        super();
        this.fieldName = fieldName;
        this.order = order;
    }
}