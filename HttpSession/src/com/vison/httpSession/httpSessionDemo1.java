package com.vison.httpSession;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class httpSessionDemo1 extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String name = request.getParameter("name");
		// 得到一个HttpSession对象
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		response.getWriter().print(session.getId());

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
