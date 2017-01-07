package com.wq.core.bean.product;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by 王萍 on 2017/1/6 0006.
 */

@Getter
@Setter
public class Sku implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer productId;
    private Integer colorId;
    private String size;
    private Double deliveFee;
    private Double skuPrice;
    private Integer stockInventory;
    private Integer skuUpperLimit;
    private String location;
    private String skuImg;
    private Integer skuSort;
    private String skuName;
    private Double marketPrice;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String createUserId;
    private String updateUserId;
    private Integer lastStatus;
    private Integer skuType;
    private Integer sales;

    private Color color;
    private Product product;

}
