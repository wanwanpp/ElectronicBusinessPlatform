package com.wq.core.bean.product;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by 王萍 on 2017/1/4 0004.
 */
@Setter
@Getter
public class Feature implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String value;
    private Integer sort;
    private Integer idDel;
}
