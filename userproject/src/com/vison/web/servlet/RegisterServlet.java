package com.vison.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.vison.domain.User;
import com.vison.service.UserService;
import com.vison.service.impl.UserServiceImpl;

public class RegisterServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// ��ȡ������
		User user = new User();
		try
		{
			BeanUtils.populate(user, request.getParameterMap());

			// ����ҵ���߼�
			UserService us = new UserServiceImpl();
			us.register(user);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		// �ַ�ת��
		response.getWriter().write("ע��ɹ�,1�����ת����ҳ");
		response.setHeader("refresh", "1;url=" + request.getContextPath() + "/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
