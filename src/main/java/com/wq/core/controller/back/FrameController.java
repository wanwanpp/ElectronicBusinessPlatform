package com.wq.core.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 王萍 on 2016/12/30 0030.
 */
@Controller
@RequestMapping(value = "/frame")
public class FrameController {

    @RequestMapping(value = "/product_main.do")
    public String productMain() {
        return "frame/product_main";
    }

    @RequestMapping(value = "/product_left.do")
    public String productLeft() {
        return "frame/product_left";
    }

    @RequestMapping(value = "/order_main.do")
    public String orderMain() {
        return "frame/order_main";
    }

    @RequestMapping(value = "/order_left.do")
    public String orderLeft() {
        return "frame/order_left";
    }
}
