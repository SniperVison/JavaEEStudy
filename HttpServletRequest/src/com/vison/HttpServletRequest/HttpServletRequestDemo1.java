package com.vison.HttpServletRequest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//此代码为实现与请求消息行的方法
public class HttpServletRequestDemo1 extends HttpServlet
{
	/*
	 * ①getMethod() ;获取请求方式
	 *重点： ②getRequestURL(); 返回客户端发出请求时的完整URL
	 *重点： ③getRequestURI();  返回请求行中的资源名部分
	 *非常重点： ④getContextPath(); 当前应用的虚拟目录
	 * ⑤getQueryString(); 返回请求行中的参数部分 
	 * */

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		System.out.println(request.getMethod());// Get请求方式
		System.out.println(request.getRequestURL());// 即为http://localhost:8080/HttpServletRequest/demo1
		System.out.println(request.getRequestURI());// 即为/HttpServletRequest/demo1
		System.out.println(request.getContextPath());// 即为/HttpServletRequest
		System.out.println(request.getQueryString());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
