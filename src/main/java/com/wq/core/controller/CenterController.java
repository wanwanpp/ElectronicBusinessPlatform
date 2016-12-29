package com.wq.core.controller;

import com.wq.core.bean.TestTb;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 王萍 on 2016/12/29 0029.
 */

@Controller
public class CenterController {

    @RequestMapping("/test/springmvc.do")
    public String testSpringmvc(TestTb testTb, ModelMap modelMap) {
        System.out.println(testTb);
        return "success";


    }
}
