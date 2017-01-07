package com.wq.core.bean.product;

import com.wq.common.web.Constants;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by 王萍 on 2017/1/4 0004.
 */
@Getter
@Setter
public class Img implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer productId;
    private String url;
    private Integer isDef;

    public String getAllUrl() {
        return Constants.IMAGE_URL + url;
    }
}
