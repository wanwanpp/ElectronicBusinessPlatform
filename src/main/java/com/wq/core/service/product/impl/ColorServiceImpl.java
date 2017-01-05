package com.wq.core.service.product.impl;

import com.wq.core.bean.product.Color;
import com.wq.core.dao.product.ColorDao;
import com.wq.core.query.product.ColorQuery;
import com.wq.core.service.product.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 王萍 on 2017/1/4 0004.
 */

@Service
@Transactional
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorDao colorDao;

    public List<Color> getColorList(ColorQuery colorQuery) {
        return colorDao.getColorList(colorQuery);
    }
}
