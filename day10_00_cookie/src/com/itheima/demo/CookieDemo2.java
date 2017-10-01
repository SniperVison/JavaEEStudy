package com.itheima.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		for (int i = 0;cookies!=null && i < cookies.length; i++) {
			if("lastAccessTime".equals(cookies[i].getName())){//判断当前Cookie中的name是否是想要的cookie
				long l = Long.parseLong(cookies[i].getValue());//如果是想要的Cookie，则把Cookie中的value取出
				out.write("你的最后访问时间为："+new Date(l).toLocaleString());//yyyy-MM-dd
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
