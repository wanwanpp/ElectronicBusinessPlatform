package com.wq.core.service.product;

import com.wq.core.bean.product.Color;
import com.wq.core.query.product.ColorQuery;

import java.util.List;

/**
 * Created by 王萍 on 2017/1/4 0004.
 */
public interface ColorService {

    public List<Color> getColorList(ColorQuery colorQuery);

    public Color getColorById(Integer id);

    public List<Color> getColorByIds(List<Integer> ids);

}
