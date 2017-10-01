package com.vison.HttpServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//demo6 &demo7两个是实现重定向功能的
public class HttpServletResponseDemo6 extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("浏览器A:我要借钱！");
		System.out.println("服务端B:我没钱，但是我可以告诉你问谁借！");

		/*这是实现重定向的方法一，不推荐
		 * response.setStatus(302);// 告诉客户端重新定向新的资源
		response.setHeader("location", "/HttpServletResponse/demo7");//告诉客户端要去访问哪个URL
		*/ System.out.println("浏览器A:我去借钱了");
		// 这是实现重定向的方法二，推荐使用
		response.sendRedirect("/HttpServletResponse/demo7");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
