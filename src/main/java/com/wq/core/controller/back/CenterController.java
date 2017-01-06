package com.wq.core.controller.back;

import com.wq.core.bean.TestTb;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 王萍 on 2016/12/29 0029.
 */

@Controller
public class CenterController {


//    @InitBinder
//    public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        binder.registerCustomEditor(Date.class,new CustomDateEditor(df,false));
//    }

    @RequestMapping("/test/springmvc.do")
    public String testSpringmvc(TestTb testTb, ModelMap modelMap) {
        System.out.println(testTb);
        return "";
    }

    @RequestMapping("/index.do")
    public String index(){return "index";}

    @RequestMapping("/top.do")
    public String top(){return "top";}

    @RequestMapping("/main.do")
    public String main(){return "main";}

    @RequestMapping("/left.do")
    public String left(){return "left";}

    @RequestMapping("/right.do")
    public String right(){return "right";}

}
