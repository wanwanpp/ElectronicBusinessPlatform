package com.wq.core.query.product;

import com.wq.common.database.OrderField;
import com.wq.core.query.BaseQuery;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王萍 on 2017/1/6 0006.
 */

@Getter
@Setter
public class SkuQuery extends BaseQuery {

    private Integer id;
    private Integer productId;
    private Integer colorId;
    private String size;
    private boolean sizeLike;

    private Double deliveFee;
    private Double skuPrice;
    private Integer stockInventory;
    private Integer skuUpperLimit;
    private String location;
    private boolean locationLike;

    private String skuImg;
    private boolean skuImgLike;

    private Integer skuSort;
    private String skuName;
    private boolean skuNameLike;

    private Double marketPrice;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String createUserId;
    private boolean createUserIdLike;

    private String updateUserId;
    private boolean updateUserIdLike;

    private Integer lastStatus;
    private Integer skuType;
    private Integer sales;

    private List<OrderField> orderFields = new ArrayList<OrderField>();
}
