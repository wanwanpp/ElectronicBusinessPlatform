package com.wq.core.controller.back;

import com.wq.core.bean.product.Brand;
import com.wq.core.query.product.BrandQuery;
import com.wq.core.service.product.BrandService;
import com.wq.common.web.Constants;
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
        BrandQuery brandQuery = new BrandQuery();
        brandQuery.setIsDisplay(Constants.YES);
        List<Brand> brands = brandService.getBrandList(brandQuery);
        model.addAttribute("brands",brands);

        return "brand/list";
    }

    @RequestMapping("/toAdd.do")
    public String toAdd(){
        return "brand/add";
    }

    @RequestMapping("/add.do")
    public String add(Brand brand){
        brandService.addBrand(brand);
        return "redirect:/brand/list.do";
    }

    @RequestMapping("/delete.do")
    public String delete(Integer id){
        brandService.deleteBrandById(id);
        return "redirect:/brand/list.do";
    }

    @RequestMapping("/batchDelete.do")
    public String batchDelete(Integer[] ids){
        brandService.deleteBrandByIds(ids);
        return "redirect:/brand/list.do";
    }

    @RequestMapping("/toEdit.do")
    public String toEdit(Integer id,ModelMap modelMap){
        modelMap.addAttribute("brand",brandService.getBrandById(id));
        return "brand/edit";
    }

    @RequestMapping("/edit.do")
    public String edit(Brand brand){
        brandService.updateBrand(brand);
        return "redirect:/brand/list.do";
    }

}
