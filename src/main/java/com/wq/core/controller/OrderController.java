package com.wq.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 王萍 on 2016/12/30 0030.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @RequestMapping(value = "/list.do")
    public String list() {
        return "order/list";
    }
}
