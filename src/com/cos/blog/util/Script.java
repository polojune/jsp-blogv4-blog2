package com.cos.blog.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {
	public static void back(String msg, HttpServletResponse response) {
		
		try {
			PrintWriter out = response.getWriter();
			response.setCharacterEncoding("utf-8");	// web.xml에 설정하는 게 더 나은 부분
			response.setContentType("text/html;charset=utf-8");	// 이건 web.xml 아님 JSON일 수도 있으므로
			out.println("<script>");
			out.println("alert('" + msg + "');");
			out.println("history.back();");
			out.println("</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}