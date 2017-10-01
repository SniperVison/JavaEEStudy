package com.vison.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//此代码为学习编码格式的变换
public class HttpServletResponseDemo1 extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/*
		 * 方法一：
		 * // 服务器中默认的编码为ISO-8859-1，它不支持中文，tomcat规定的
		// 同时chrome的新版本没有手动修改编码格式的选项，需要下载插件“Charset”
		response.setCharacterEncoding("UTF-8");// 告诉服务器应该使用UTF-8解析文本
		response.setHeader("content-type", "text/html;charset=UTF-8");// 告诉客户端要使用什么编码
		*/

		// 方法二：
		// 并且告诉服务器应该使用UTF-8解析文本,告诉客户端要使用什么编码
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();// 得到一个字符输出流
		out.write("hello vison！  黄文燊");// 向客户端响应文本内容
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
