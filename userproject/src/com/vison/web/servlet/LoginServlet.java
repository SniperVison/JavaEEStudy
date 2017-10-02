package com.vison.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.vison.domain.User;
import com.vison.exception.UsersException;
import com.vison.service.UserService;
import com.vison.service.impl.UserServiceImpl;

public final class LoginServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		// response.setContentType("text/html;charset=UTF-8");
		User user = new User();

		try
		{
			BeanUtils.populate(user, request.getParameterMap());
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		} catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
		UserService us = new UserServiceImpl();
		// user = us.login(user);
		User u;
		try
		{
			u = us.login(user);
			// 分发转向
			if (u != null)
			{
				// 如果登录成功，就把user对象放到session对象中
				request.getSession().setAttribute("u", user);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} else
			{
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}

		} catch (UsersException e)
		{
			// System.out.println("账户或密码错误！");
			e.printStackTrace();
			;
			// 登录失败跳回到登录页面
			// request.setAttribute("msg", e.getMessage());
			// request.getRequestDispatcher("/login.jsp").forward(request,
			// response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
