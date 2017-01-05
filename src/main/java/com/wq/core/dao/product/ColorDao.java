package com.wq.core.dao.product;

import com.wq.core.bean.product.Color;
import com.wq.core.query.product.ColorQuery;

import java.util.List;

/**
 * Created by 王萍 on 2017/1/4 0004.
 */
public interface ColorDao {

    public List<Color> getColorList(ColorQuery colorQuery);
}
