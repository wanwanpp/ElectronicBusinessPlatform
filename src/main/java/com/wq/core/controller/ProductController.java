package com.wq.core.controller;

import com.wq.common.page.Pagination;
import com.wq.core.bean.product.Brand;
import com.wq.core.bean.product.Color;
import com.wq.core.bean.product.Feature;
import com.wq.core.bean.product.Type;
import com.wq.core.query.product.*;
import com.wq.core.service.product.*;
import com.wq.core.web.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 王萍 on 2016/12/30 0030.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private ProductService productService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private FeatureService featureService;

    @Autowired
    private ColorService colorService;

    @RequestMapping(value = "/list.do")
    public String list(Integer pageNo, String name, Integer brandId, Integer isShow, ModelMap model) {
//默认加载品牌
        BrandQuery brandQuery = new BrandQuery();
        //设置 可见不可见
        brandQuery.setIsDisplay(Constants.YES);
        //设置只要Id Name
        brandQuery.setFields("id,name");

        List<Brand> brands = brandService.getBrandList(brandQuery);

        model.addAttribute("brands", brands);
        model.addAttribute("brandId", brandId);

        StringBuilder params = new StringBuilder();
        //设置条件的对象
        ProductQuery productQuery = new ProductQuery();
        //默认加载
        //1:设置未删除
        productQuery.setIsDel(Constants.YES);
        //2:设置下架状态
        productQuery.setIsShow(Constants.NO);

        productQuery.orderbyId(false);

        //Blank 1:去掉二侧的空串,再判断是否为空串   ""   "     "
        //Empty  直接判断是否为空串    ""  "      "
        //拼接查询条件
        if(null != name && StringUtils.isNotBlank(name)){
            productQuery.setName(name);
            params.append("&")
                    .append("name=" + name);
        }
        //品牌ID
        if(null != brandId){
            productQuery.setBrandId(brandId);
            params.append("&")
                    .append("brandId=" + brandId);
        }
        //上下架
        if(null != isShow){
            productQuery.setIsShow(isShow);
            params.append("&")
                    .append("isShow=" + isShow);
            model.addAttribute("isShow", isShow);
        }else{
            model.addAttribute("isShow", 0);
        }
        System.out.println(isShow);
        productQuery.setPageNo(Pagination.cpn(pageNo));//1 10

        productQuery.setPageSize(20);

        //分页对象的使用方法
        Pagination pagination = productService.getProductListWithPage(productQuery);
        String url = "/product/list.do";

        //String params = "brandId=1&name=2014瑜伽服套装新款&pageNo=1";
        pagination.pageView(url, params.toString());

        //<a href="javascript:void(0)" onclick="javascript:window.location.href='
        // /product/list.do?&=1&name=2014瑜伽服套装新款&pageNo=1'" />
        model.addAttribute("pagination", pagination);
        return "product/list";
    }

    @RequestMapping("/toAdd.do")
    public String toAdd(ModelMap model){

        TypeQuery typeQuery = new TypeQuery();
        typeQuery.setIsDisplay(Constants.YES);
        typeQuery.setFields("id,name");
        List<Type> types = typeService.getTypeList(typeQuery);
        model.addAttribute("types",types);

        BrandQuery brandQuery = new BrandQuery();
        brandQuery.setIsDisplay(Constants.YES);
        brandQuery.setFields("id,name");
        List<Brand> brands = brandService.getBrandList(brandQuery);
        model.addAttribute("brands",brands);

        FeatureQuery featureQuery = new FeatureQuery();
        featureQuery.setIdDel(Constants.YES);
        featureQuery.setFields("id,name");
        List<Feature> features = featureService.getFeatureList(featureQuery);
        model.addAttribute("features",features);

        ColorQuery colorQuery = new ColorQuery();
        colorQuery.setParentId(Constants.YES);
        List<Color> colors = colorService.getColorList(colorQuery);
        model.addAttribute("colors",colors);


        return "product/add";
    }
}
