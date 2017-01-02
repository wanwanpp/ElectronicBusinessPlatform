package com.wq.core.controller;

import com.wq.core.bean.product.Brand;
import com.wq.core.service.product.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 王萍 on 2016/12/30 0030.
 */
@Controller
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/list.do")
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        Brand brand = new Brand();
        brand.setIsDisplay(1);
        List<Brand> brands = brandService.getBrandList(brand);
        model.addAttribute("brands",brands);

        return "brand/list";
    }

    @RequestMapping("/toAdd.do")
    public String toAdd(){
        return "brand/add";
    }

}
