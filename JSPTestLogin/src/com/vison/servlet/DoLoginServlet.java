package com.vison.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoLoginServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// ��ȡ������
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		// ����ҵ���߼�
		if ("vison".equals(username) && "123".contentEquals(pwd))
		{
			request.getSession().setAttribute("name", username);
			request.getRequestDispatcher("/success.jsp").forward(request, response);
			// response.sendRedirect(request.getContextPath() + "/success.jsp");

		}

		else
			// response.sendRedirect(request.getContextPath() + "/login.jsp");
			request.setAttribute("msg", "�˻�����������������������룡");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		// �ַ�ת��

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
