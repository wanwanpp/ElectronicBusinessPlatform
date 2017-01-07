package com.wq.core.controller.back;

import com.wq.common.database.OrderField;
import com.wq.common.util.ResponseUtils;
import com.wq.core.bean.product.Sku;
import com.wq.core.query.product.SkuQuery;
import com.wq.core.service.product.ColorService;
import com.wq.core.service.product.SkuService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 王萍 on 2017/1/6 0006.
 */

@Controller
@RequestMapping("/sku")
public class SkuController {

    @Autowired
    private SkuService skuService;

    @Autowired
    private ColorService colorService;

    @RequestMapping("/list.do")
    public String list(Integer id, String no, ModelMap model) {

        SkuQuery skuQuery = new SkuQuery();
        skuQuery.setProductId(id);
        List<OrderField> orderFields = new LinkedList<OrderField>();
        orderFields.add(new OrderField("id","desc"));
        skuQuery.setOrderFields(orderFields);

        List<Sku> skus = skuService.getSkuList(skuQuery);

        model.addAttribute("skus",skus);
        model.addAttribute("no",no);

        return "sku/list";
    }

    @RequestMapping("/add.do")
    public void add(Sku sku, HttpServletResponse response){

        skuService.updateSku(sku);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message","保存成功");
        ResponseUtils.renderJson(response,jsonObject.toString());
    }

}
