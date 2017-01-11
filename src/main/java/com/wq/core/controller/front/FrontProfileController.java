package com.wq.core.controller.front;

import com.octo.captcha.service.image.ImageCaptchaService;
import com.wq.common.encode.Md5Pwd;
import com.wq.common.util.ResponseUtils;
import com.wq.common.web.Constants;
import com.wq.common.web.session.SessionProvider;
import com.wq.core.bean.country.City;
import com.wq.core.bean.country.Province;
import com.wq.core.bean.country.Town;
import com.wq.core.bean.user.Addr;
import com.wq.core.bean.user.Buyer;
import com.wq.core.query.country.CityQuery;
import com.wq.core.query.country.TownQuery;
import com.wq.core.query.user.AddrQuery;
import com.wq.core.service.country.CityService;
import com.wq.core.service.country.ProvinceService;
import com.wq.core.service.country.TownService;
import com.wq.core.service.user.AddrService;
import com.wq.core.service.user.BuyerService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private CityService cityService;

    @Autowired
    private TownService townService;

    @Autowired
    private AddrService addrService;

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
    public String index() {
        return "buyer/index";
    }

    @RequestMapping("/shopping/logout.shtml")
    public String logout(String returnUrl, HttpServletRequest request, HttpServletResponse response) {
        sessionProvider.logout(request, response);
        return "redirect" + returnUrl;
    }

    @RequestMapping("/buyer/profile.shtml")
    public String profile(HttpServletRequest request, ModelMap model) {
        Buyer buyer = (Buyer) sessionProvider.getAttribute(request, Constants.BUYER_SESSION);
        Buyer b = buyerService.getBuyerByUsername(buyer.getUsername());
        model.addAttribute("buyer", b);

        List<Province> provinces = provinceService.getProvinceList(null);
        CityQuery cityQuery = new CityQuery();
        cityQuery.setProvince(b.getProvince());
        List<City> cities = cityService.getCityList(cityQuery);
        TownQuery townQuery = new TownQuery();
        townQuery.setCity(b.getCity());
        List<Town> towns = townService.getTownList(townQuery);
        model.addAttribute("provinces", provinces);
        model.addAttribute("citys", cities);
        model.addAttribute("towns", towns);

        return "buyer/profile";
    }

    @RequestMapping("/buyer/province.shtml")
    @ResponseBody
    public void province(HttpServletResponse response) {
        List<Province> provinces = provinceService.getProvinceList(null);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("provinces", provinces);
        ResponseUtils.renderJson(response, jsonObject.toString());
    }

    @RequestMapping("/buyer/city.shtml")
    @ResponseBody
    public void city(String province, HttpServletResponse response) {
        CityQuery cityQuery = new CityQuery();
        cityQuery.setProvince(province);
        List<City> cities = cityService.getCityList(cityQuery);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cities", cities);
        ResponseUtils.renderJson(response, jsonObject.toString());
    }

    @RequestMapping(value = "/buyer/town.shtml")
    @ResponseBody
    public void town(String city, HttpServletResponse response) {
        TownQuery townQuery = new TownQuery();
        townQuery.setCity(city);
        List<Town> towns = townService.getTownList(townQuery);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("towns", towns);
        ResponseUtils.renderJson(response, jsonObject.toString());

    }

    @RequestMapping("/buyer/saveProfile.shtml")
    public void saveProfile(Buyer buyer, HttpServletResponse response) {

        buyerService.updateBuyer(buyer);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "保存成功");
        ResponseUtils.renderJson(response, jsonObject.toString());

    }

    @RequestMapping(value = "/buyer/deliver_address.shtml")
    public String deliverAddress(HttpServletRequest request, ModelMap model) {

        Buyer buyer = (Buyer) sessionProvider.getAttribute(request, Constants.BUYER_SESSION);

        AddrQuery addrQuery = new AddrQuery();
        addrQuery.setBuyerId(buyer.getUsername());
        List<Addr> addrs = addrService.getAddrList(addrQuery);
        model.addAttribute("addrs", addrs);

        return "buyer/deliver_address";
    }

    @RequestMapping("/buyer/saveAddress.shtml")
    public void saveAddress(HttpServletResponse response,HttpServletRequest request,Addr addr){


        JSONObject jsonObject = new JSONObject();
        if (null!=addr&&null!=addr.getId()){
            addrService.updateAddrByKey(addr);
            jsonObject.put("message","修改成功");
        }else {
            Buyer buyer = (Buyer) sessionProvider.getAttribute(request,Constants.BUYER_SESSION);
            addr.setBuyerId(buyer.getUsername());
            addrService.addAddr(addr);
            jsonObject.put("message","保存成功");
        }
        if (addr.getIsDef()!=0){
            AddrQuery addrQuery = new AddrQuery();
            addrQuery.setBuyerId(addr.getBuyerId());

            //这里只查出id是后面更新时找一个唯一的字段，确定更新字段
            addrQuery.setFields("id");
            List<Addr> addrs = addrService.getAddrList(addrQuery);
            for (Addr addr1:addrs){
                addr1.setIsDef(0);
                addrService.updateAddrByKey(addr);
            }
        }
        ResponseUtils.renderJson(response,jsonObject.toString());

    }

}
