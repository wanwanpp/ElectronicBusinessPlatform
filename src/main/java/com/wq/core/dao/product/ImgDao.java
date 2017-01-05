package com.wq.core.dao.product;

import com.wq.core.bean.product.Img;
import com.wq.core.query.product.ImgQuery;

import java.util.List;

/**
 * Created by 王萍 on 2017/1/4 0004.
 */
public interface ImgDao {

    public List<Img> getImgList(ImgQuery imgQuery);
}
