package com.wq;

import com.wq.common.junit.SpringJunitTest;
import com.wq.core.bean.TestTb;
import com.wq.core.service.test.TestTbService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by 王萍 on 2016/12/29 0029.
 */
public class TestTestTb extends SpringJunitTest {

    @Autowired
    private TestTbService testTbService;


    @Test
    public void testAdd() {

        TestTb testTb = new TestTb();
        testTb.setName("测试数据");
        testTb.setBirthday(new Date(System.currentTimeMillis()));
        testTbService.add(testTb);
    }
//    @Test
//    public void testAdd() {
//
//        TestTb testTb = new TestTb();
//        testTb.setName("测试事务");
//        testTb.setBirthday(new Timestamp(System.currentTimeMillis()));
//        testTbService.add(testTb);
//    }
}
