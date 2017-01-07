package com.wq.core.service.staticpage;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import javax.servlet.ServletContext;
import java.io.*;
import java.util.Map;

/**
 * Created by 王萍 on 2017/1/6 0006.
 */
public class StaticPageServiceImpl implements StaticPageService, ServletContextAware {

    private Configuration configuration;

    public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
        this.configuration = freeMarkerConfigurer.getConfiguration();
    }

    //获取路径
    public String get(String path){
        return servletContext.getRealPath(path);
    }

    public void productIndex(Map<String,Object> data,Integer id) {
        //设置模板的文件夹路径
        //获取模板  /WEB-INF/ftl/prodcutDetail.html
        //输出路径  webapp/html/ + prouduct/ + id + ".html"
        String tpl = "productDetail.html";
        String outPath = get("/html/product/" + id + ".html");

        File f = new File(outPath);
        File p = f.getParentFile();

        if(!p.exists()){
            p.mkdirs();
        }
        try {
            Writer out = new OutputStreamWriter(new FileOutputStream(f), "UTF-8");
            Template template = configuration.getTemplate(tpl);
            template.process(data, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    private ServletContext servletContext;
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

}
