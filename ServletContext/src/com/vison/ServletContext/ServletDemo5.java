package com.vison.ServletContext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Demo5&Demo6实现请求转发
public class ServletDemo5 extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("Demo5:我要办事");
		System.out.println("Demo5:你办的事我办不了，我可以帮你找人办");
		// 将请求转发给 Demo6，向下传递请求
		ServletContext application = this.getServletContext();
		application.getRequestDispatcher("/Demo6").forward(request, response);
		// 这是另外 一种
		// 写法：this.getServletContext().getRequestDispatcher("/Demo6").forward(request,
		// response);
		System.out.println("Demo5:办完了");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
