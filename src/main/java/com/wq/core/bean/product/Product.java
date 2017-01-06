package com.wq.core.bean.product;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 王萍 on 2017/1/4 0004.
 */
@Getter
@Setter
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    /**  前台每页数  */
    public static final int FRONT_PAGE_SIZE = 8;

    private Integer id;
    private String no;
    private String name;
    private Double weight;
    private Integer isNew;
    private Integer isHot;
    private Integer isCommend;
    private Date createTime;
    private String createUserId;
    private Date checkTime;
    private String checkUserId;
    private Integer isShow = 0;
    private Integer isDel = 1;
    private Integer typeId;
    private Integer brandId;
    private String keywords;
    private Integer sales;
    private String description;
    private String packageList;
    private String feature;//
    private String color;//9,10,11,12
    private String size;//S,L,XXL

    //添加外部对象
    //此处添加一个Img对象是为了给Img添加productId，在ProductServiceImpl中
    private Img img;
}
