package com.vison.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoLogin extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 获取表单数据
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String code = request.getParameter("code");
		String scode = (String) request.getSession().getAttribute("scode");
		// 处理业务逻辑
		if ("vison".equals(username) && "123".equals(pwd))
		{
			if (!code.equalsIgnoreCase(scode))
			{

				request.setAttribute("msg", "验证码错误");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			out.print("登录成功!");
		}
		// 分发转向
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
