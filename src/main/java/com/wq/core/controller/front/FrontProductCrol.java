package com.wq.core.controller.front;

import com.wq.common.page.Pagination;
import com.wq.core.bean.product.*;
import com.wq.core.query.product.*;
import com.wq.core.service.product.*;
import com.wq.common.web.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by 王萍 on 2017/1/5 0005.
 */

@Controller
@RequestMapping("/product/display")
public class FrontProductCrol {

    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductService productService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private FeatureService featureService;
    @Autowired
    private SkuService skuService;
    @Autowired
    private ColorService colorService;

    @RequestMapping("/list.shtml")
    public String list(Integer pageNo, Integer brandId, String brandName, Integer typeId, String typeName, ModelMap model) {

        FeatureQuery featureQuery = new FeatureQuery();
        List<Feature> features = featureService.getFeatureList(featureQuery);
        model.addAttribute("features", features);

        StringBuilder params = new StringBuilder();
        ProductQuery productQuery = new ProductQuery();
        productQuery.setPageNo(Pagination.cpn(pageNo));
        productQuery.setPageSize(Product.FRONT_PAGE_SIZE);
        productQuery.orderbyId(false);

        boolean flag = false;

        Map<String, String> query = new LinkedHashMap<String, String>();

        if (null != brandId) {
            productQuery.setBrandId(brandId);
            flag = true;
            model.addAttribute("brandId", brandId);
            model.addAttribute("brandName", brandName);
            query.put("品牌", brandName);
            params.append("&").append("brandId=").append(brandId).append("&brandName=").append(brandName);
        } else {
            BrandQuery brandQuery = new BrandQuery();
            brandQuery.setIsDisplay(Constants.YES);
            brandQuery.setFields("id,name");
            List<Brand> brands = brandService.getBrandList(brandQuery);
            model.addAttribute("brands", brands);
        }

        if (null != typeId) {
            productQuery.setTypeId(typeId);
            flag = true;
            model.addAttribute("typeId", typeId);
            model.addAttribute("typeName", typeName);
            query.put("类型", typeName);
            params.append("&").append("typeId=").append(typeId).append("&typeName=").append(typeName);
        } else {
            TypeQuery typeQuery = new TypeQuery();
            typeQuery.setIsDisplay(Constants.YES);
            typeQuery.setParentId(0);
            typeQuery.setFields("id,name");
            List<Type> types = typeService.getTypeList(typeQuery);
            model.addAttribute("types", types);
        }

        model.addAttribute("flag", flag);
        model.addAttribute("query", query);

        Pagination pagination = productService.getProductListWithPage(productQuery);
        String url = "/product/display/list.shtml";
        pagination.pageView(url, params.toString());
        model.addAttribute("pagination", pagination);

        return "product/product";
    }

    @RequestMapping("/detail.shtml")
    public String detail(ModelMap model, Integer id) {

        Product product = productService.getProductById(id);
        List<Sku> skus = skuService.getStock(id);
        if (!CollectionUtils.isEmpty(skus)) {
            List<Integer> colorIds = new LinkedList<Integer>();
            for (Sku sku:skus){
                if (!colorIds.contains(sku.getColorId())){
                    colorIds.add(sku.getColorId());
                }
            }

            model.addAttribute("colors",colorService.getColorByIds(colorIds));
            model.addAttribute("skus",skus);
        }

        model.addAttribute("product",product);
        return "product/productDetail";
    }
}
