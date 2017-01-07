package com.wq.core.dao.user;

import com.wq.core.bean.user.Buyer;

/**
 * Created by 王萍 on 2017/1/7 0007.
 */
public interface BuyerDao {

    public Buyer getBuyerByUsername(String username);
}
