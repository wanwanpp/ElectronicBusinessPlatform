package com.wq.core.bean.product;

import com.wq.common.web.Constants;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by 王萍 on 2016/12/30 0030.
 */

@Getter
@Setter
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String description;
    private String imgUrl;
    private String webSite;
    private Integer sort;
    private Integer isDisplay;

//    此处的allUrl需要注意
    public String getAllUrl(){
        return Constants.IMAGE_URL + imgUrl;
    }

}
