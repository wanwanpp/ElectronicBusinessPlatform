package com.wq.common.web.session;

import com.wq.common.web.Constants;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created by 王萍 on 2017/1/7 0007.
 */

public class HttpSessionProvider implements SessionProvider {
    public void setAttribute(HttpServletRequest request, String name, Serializable value) {
        HttpSession session = request.getSession();
        if (session!=null){
            session.setAttribute(name,value);
        }
    }

    public Serializable getAttribute(HttpServletRequest request, String name) {
//        不重新创建新的session，使用已有的session
        HttpSession session = request.getSession(false);
        if (session!=null){
            return (Serializable) session.getAttribute(name);
        }else return null;

    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(false);
        if (null!=session){
            session.invalidate();
        }

        Cookie cookie = new Cookie(Constants.SESSION_ID,null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    public String getSessionId(HttpServletRequest request) {

       return request.getSession().getId();

//        直接从请求中返回sessionId
//        return request.getRequestedSessionId();
    }
}
