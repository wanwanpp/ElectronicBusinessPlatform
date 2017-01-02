package com.wq.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 王萍 on 2016/12/30 0030.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @RequestMapping(value = "/list.do")
    public String list() {
        return "product/list";
    }
}
