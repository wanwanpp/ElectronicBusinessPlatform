package com.wq.core.service.test.impl;

import com.wq.core.bean.TestTb;
import com.wq.core.dao.TestTbDao;
import com.wq.core.service.test.TestTbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 王萍 on 2016/12/29 0029.
 */
@Service
@Transactional
public class TestTbServiceImpl implements TestTbService {

    @Autowired
    private TestTbDao testTbDao;

    public void add(TestTb testTb) {
        testTbDao.addTestTb(testTb);

//        throw new RuntimeException();
    }
}
