package com.wq.common.web.springmvc;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 王萍 on 2016/12/30 0030.
 */
public class BindingInitializer implements WebBindingInitializer {
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
    }
}
