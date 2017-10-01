package com.vison.HttpServletRequest;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletRequestDemo2 extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// testHeader(request);

		// 枚举，获得所有请求消息头的name
		Enumeration names = request.getHeaderNames();
		while (names.hasMoreElements())
		{
			String elem = (String) names.nextElement();
			System.out.println(elem + ":" + request.getHeader(elem));
		}

	}

	public void testHeader(HttpServletRequest request)
	{
		// 获得请求消息头的消息
		String header = request.getHeader("User-Agent");
		System.out.println(header);
		if (header.toLowerCase().contains("edge"))
			System.out.println("你使用的是Edge浏览器");
		else if (header.toLowerCase().contains("chrome"))
			System.out.println("你使用的Chrome浏览器");
		else
			System.out.println("你使用的是IE11浏览器");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
