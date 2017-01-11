package com.wq.core.service.user;

import com.wq.core.bean.user.Buyer;

/**
 * Created by 王萍 on 2017/1/7 0007.
 */
public interface BuyerService {

    public Buyer getBuyerByUsername(String username);

    public void updateBuyer(Buyer buyer);
}
