package com.wq.core.web.springmvc;

import com.wq.common.web.Constants;
import com.wq.common.web.session.SessionProvider;
import com.wq.core.bean.user.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 王萍 on 2017/1/7 0007.
 */
public class FrontInterceptor implements HandlerInterceptor {

    @Autowired
    private SessionProvider sessionProvider;

    public static final String INTERCEPTOR_URL="/buyer/";

    public static final String RETURNURL="returnUrl";

    private Integer adminId;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if (null!=adminId){
            Buyer b = new Buyer();
            b.setUsername("a");
            sessionProvider.setAttribute(request, Constants.BUYER_SESSION,b);
            request.setAttribute("isLogin",true);
        }else {
//            从session中取出buyer对象
            Buyer buyer = (Buyer) sessionProvider.getAttribute(request,Constants.BUYER_SESSION);
            //如果对象存在，将isLogin设为true
            if (null!=buyer){
                request.setAttribute("isLogin",true);
            }else {
                request.setAttribute("isLogin",false);
            }

            String requestURI = request.getRequestURI();
            //如果请求路径为需要保护的路径，进行拦截并判断是否允许通过
            if (requestURI.contains(INTERCEPTOR_URL)){
                //如果不满足就返回登陆界面进行登陆
                if (null==buyer){
                    response.sendRedirect("/shopping/login.shtml?"+RETURNURL+"="+requestURI);
                    return false;
                }
            }
        }
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
