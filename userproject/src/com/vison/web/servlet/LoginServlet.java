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
			// �ַ�ת��
			if (u != null)
			{
				// �����¼�ɹ����Ͱ�user����ŵ�session������
				request.getSession().setAttribute("u", user);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} else
			{
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}

		} catch (UsersException e)
		{
			// System.out.println("�˻����������");
			e.printStackTrace();
			;
			// ��¼ʧ�����ص���¼ҳ��
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
