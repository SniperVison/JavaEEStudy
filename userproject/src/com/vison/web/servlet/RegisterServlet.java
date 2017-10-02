package com.vison.web.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.vison.domain.User;
import com.vison.service.UserService;
import com.vison.service.impl.UserServiceImpl;

public class RegisterServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		User user = new User();

		try
		{// ����һ���ֶ�ע��һ������ת����
			ConvertUtils.register(new Converter()
			{

				public Object convert(Class type, Object value)
				{
					Date date1 = null;
					if (value instanceof String)
					{
						String date = (String) value;
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						try
						{
							date1 = sdf.parse(date);
						} catch (ParseException e)
						{
							e.printStackTrace();
						}

					}
					return date1;
				}
			}, Date.class);

			// �����������õ���ע��һ������ת����
			// ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.populate(user, request.getParameterMap());
			UserService us = new UserServiceImpl();
			us.register(user);
		} /*catch (IllegalAccessException e)
			{
			e.printStackTrace();
			} catch (InvocationTargetException e)
			{
			e.printStackTrace();
			} */catch (Exception e)
		{
			e.printStackTrace();
		}
		response.getWriter().write("ע��ɹ���1����ת����ҳ");
		response.setHeader("refresh", "1;url=" + request.getContextPath() + "/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
