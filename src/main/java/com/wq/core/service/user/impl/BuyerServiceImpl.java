package com.wq.core.service.user.impl;

import com.wq.core.bean.user.Buyer;
import com.wq.core.dao.user.BuyerDao;
import com.wq.core.service.user.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 王萍 on 2017/1/7 0007.
 */

@Service
@Transactional
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private BuyerDao buyerDao;

    @Transactional(readOnly = true)
    public Buyer getBuyerByUsername(String username) {
        return buyerDao.getBuyerByUsername(username);
    }

    public void updateBuyer(Buyer buyer) {
        buyerDao.updateBuyer(buyer);
    }
}
