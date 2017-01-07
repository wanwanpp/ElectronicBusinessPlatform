package com.wq.core.controller.front;

import com.octo.captcha.service.image.ImageCaptchaService;
import com.wq.common.encode.Md5Pwd;
import com.wq.common.web.Constants;
import com.wq.common.web.session.SessionProvider;
import com.wq.core.bean.user.Buyer;
import com.wq.core.service.user.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 王萍 on 2017/1/7 0007.l
 */
@Controller
public class FrontProfileController {

    @Autowired
    private ImageCaptchaService imageCaptchaService;

    @Autowired
    private SessionProvider sessionProvider;

    @Autowired
    private BuyerService buyerService;

    @Autowired
    private Md5Pwd md5Pwd;

    @RequestMapping(value = "/shopping/login.shtml", method = RequestMethod.GET)
    public String login() {
        return "buyer/login";
    }

    @RequestMapping(value = "/shopping/login.shtml", method = RequestMethod.POST)
    public String login(Buyer buyer, String captcha, String returnUrl, HttpServletRequest request, ModelMap model) {

        if (!StringUtils.isEmpty(captcha)) {
            if (imageCaptchaService.validateResponseForID(sessionProvider.getSessionId(request), captcha)) {
                if (null != buyer && !StringUtils.isEmpty(buyer.getUsername())) {
                    if (!StringUtils.isEmpty(buyer.getPassword())) {
                        Buyer b = buyerService.getBuyerByUsername(buyer.getUsername());
                        if (null != b) {
                            if (b.getPassword().equals(md5Pwd.encode(buyer.getPassword()))) {

                                sessionProvider.setAttribute(request, Constants.BUYER_SESSION, b);
                                if (!StringUtils.isEmpty(returnUrl)) {
                                    return "redirect:" + returnUrl;
                                } else {
                                    return "redirect:/buyer/index.shtml";
                                }
                            } else {
                                model.addAttribute("error", "密码错误");
                            }
                        } else {
                            model.addAttribute("error", "用户名输入错误");
                        }
                    } else {
                        model.addAttribute("error", "请输入密码");
                    }
                } else {
                    model.addAttribute("error", "请输入用户名");
                }
            } else {
                model.addAttribute("error", "验证码输入错误");
            }
        } else {
            model.addAttribute("error", "请填写验证码");
        }
        return "buyer/login";
    }

    //个人中心
    @RequestMapping(value = "/buyer/index.shtml")
    public String index(){
        return "buyer/index";
    }

    @RequestMapping("/shopping/logout.shtml")
    public String logout(String returnUrl, HttpServletRequest request, HttpServletResponse response){
        sessionProvider.logout(request,response);
        return "redirect"+returnUrl;
    }
}
