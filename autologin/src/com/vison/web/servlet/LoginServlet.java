package com.vison.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vison.domain.User;
import com.vison.service.UserService;
import com.vison.util.MD5Util;

public class LoginServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// ʹ��md5�����㷨��������
		password = MD5Util.md5(password);
		System.out.println(password);
		UserService us = new UserService();
		User user = us.findUser(username, password);
		if (user != null)
		{
			String autologin = request.getParameter("autologin");
			Cookie cookie = new Cookie("user", user.getUsername() + "&" + user.getPassword());
			cookie.setPath("/");// �����ʾ�����ڵ�ǰӦ������
			if (autologin != null)// Ҫ���û���Ϣ���浽cookie��
			{
				cookie.setMaxAge(60 * 60 * 24 * 7);// ��cookie���󱣴�7��
			} else// Ҫ���Cookie���������
			{
				cookie.setMaxAge(0);// ����cookie
			}
			response.addCookie(cookie);// ��cookie���󱣴浽�ͻ�����
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else
		{
			request.setAttribute("msg", "�˻���������������µ�¼");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);

	}

}
