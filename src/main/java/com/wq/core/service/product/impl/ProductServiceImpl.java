package com.wq.core.service.product.impl;

import com.wq.common.page.Pagination;
import com.wq.core.bean.product.Img;
import com.wq.core.bean.product.Product;
import com.wq.core.dao.product.ImgDao;
import com.wq.core.dao.product.ProductDao;
import com.wq.core.query.product.ImgQuery;
import com.wq.core.query.product.ProductQuery;
import com.wq.core.service.product.ProductService;
import com.wq.common.web.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 王萍 on 2017/1/4 0004.
 */

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ImgDao imgDao;


    @Transactional(readOnly = true)
    public Pagination getProductListWithPage(ProductQuery productQuery) {
        //获取满足条件的商品总数
        int count = productDao.getProductListCount(productQuery);

        Pagination p = new Pagination(productQuery.getPageNo(), productQuery.getPageSize(), count);

        List<Product> products = productDao.getProductListWithPage(productQuery);

        for (Product product : products) {

            //为商品加载默认图片
            ImgQuery imgQuery = new ImgQuery();
            imgQuery.setProductId(product.getId());
            imgQuery.setIsDef(Constants.YES);
            List<Img> imgs = imgDao.getImgList(imgQuery);
            product.setImg(imgs.get(0));
        }

        p.setList(products);

        return p;
    }

    public Integer addProduct(Product product) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String no = dateFormat.format(new Date());
        product.setNo(no);
        product.setCreateTime(new Date(System.currentTimeMillis()));
        Integer i = productDao.addProduct(product);

        Img img = product.getImg();
        img.setProductId(product.getId());
        img.setIsDef(Constants.YES);
        imgDao.addImg(img);


        return i;
    }

    @Transactional(readOnly = true)
    public Product getProductById(Integer id) {

        Product product = productDao.getProductById(id);
        ImgQuery imgQuery = new ImgQuery();
        imgQuery.setProductId(product.getId());
        imgQuery.setIsDef(Constants.YES);
        List<Img> imgs = imgDao.getImgList(imgQuery);
        product.setImg(imgs.get(0));
        return product;
    }

    public Integer updateProductById(Product product) {
        return productDao.updateProductById(product);
    }
}
