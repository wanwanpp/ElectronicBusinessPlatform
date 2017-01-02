package com.wq.common.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtils {

	//发送JSON
    public static void renderJson(HttpServletResponse response, String text){
		render(response,"application/json;charset=UTF-8",text);
	}
	//发送xml
	public static void renderXml(HttpServletResponse response,String text){
		render(response,"text/xml;charset=UTF-8",text);
	}
	//发送text
	public static void renderText(HttpServletResponse response,String text){
		render(response,"text/plain;charset=UTF-8",text);
	}
	//发送
	public static void render(HttpServletResponse response,String contextType,String text){
		//设置传输类型
		response.setContentType(contextType);
		//发送
		try {
			response.getWriter().write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
