package com.vison.ServletConfig;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigDemo1 extends HttpServlet
{

	public ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException
	{
		this.config = config;
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// 第一种方式，需要 使用到config变量
		String encoding = config.getInitParameter("encoding");// 获取配置文件中的信息
		System.out.println(encoding);

		// 第二种方式,同样 需要 先 init方法及其所 声明的变量config
		/*String encoding = super.getServletConfig().getInitParameter("encoding");
		System.out.println(encoding);*/

		// 第三种方式，需要 先注释 init方法及其所 声明的变量config
		/*String encoding = super.getInitParameter("encoding");
		System.out.println(encoding);*/

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{

	}

}
