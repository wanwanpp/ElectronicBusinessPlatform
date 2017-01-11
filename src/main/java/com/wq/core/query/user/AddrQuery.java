package com.wq.core.query.user;


import com.wq.common.database.OrderField;
import com.wq.core.query.BaseQuery;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AddrQuery extends BaseQuery {
    /**
     * ==============================批量查询、更新、删除时的Where条件设置======================
     * ============
     **/
    private Integer id;

    private String buyerId;

    private boolean buyerIdLike;

    private String name;

    private boolean nameLike;

    private String city;

    private boolean cityLike;

    private String addr;

    private boolean addrLike;

    private String phone;

    private boolean phoneLike;

    private Integer isDef;


    private List<OrderField> orderFields = new ArrayList<OrderField>();

    /**
     * 设置排序按属性：id
     *
     * @param isAsc 是否升序，否则为降序
     */
    public AddrQuery orderbyId(boolean isAsc) {
        orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：buyer_id
     *
     * @param isAsc 是否升序，否则为降序
     */
    public AddrQuery orderbyBuyerId(boolean isAsc) {
        orderFields.add(new OrderField("buyer_id", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：name
     *
     * @param isAsc 是否升序，否则为降序
     */
    public AddrQuery orderbyName(boolean isAsc) {
        orderFields.add(new OrderField("name", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：city
     *
     * @param isAsc 是否升序，否则为降序
     */
    public AddrQuery orderbyCity(boolean isAsc) {
        orderFields.add(new OrderField("city", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：addr
     *
     * @param isAsc 是否升序，否则为降序
     */
    public AddrQuery orderbyAddr(boolean isAsc) {
        orderFields.add(new OrderField("addr", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：phone
     *
     * @param isAsc 是否升序，否则为降序
     */
    public AddrQuery orderbyPhone(boolean isAsc) {
        orderFields.add(new OrderField("phone", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：is_def
     *
     * @param isAsc 是否升序，否则为降序
     */
    public AddrQuery orderbyIsDef(boolean isAsc) {
        orderFields.add(new OrderField("is_def", isAsc ? "ASC" : "DESC"));
        return this;
    }
}
