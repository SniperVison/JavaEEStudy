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
		// 使用md5加密算法加密密码
		password = MD5Util.md5(password);
		System.out.println(password);
		UserService us = new UserService();
		User user = us.findUser(username, password);
		if (user != null)
		{
			String autologin = request.getParameter("autologin");
			Cookie cookie = new Cookie("user", user.getUsername() + "&" + user.getPassword());
			cookie.setPath("/");// 这里表示保存在当前应用里面
			if (autologin != null)// 要把用户信息保存到cookie中
			{
				cookie.setMaxAge(60 * 60 * 24 * 7);// 把cookie对象保存7天
			} else// 要清楚Cookie对象的数据
			{
				cookie.setMaxAge(0);// 销毁cookie
			}
			response.addCookie(cookie);// 把cookie对象保存到客户端中
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else
		{
			request.setAttribute("msg", "账户或密码错误，请重新登录");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);

	}

}
