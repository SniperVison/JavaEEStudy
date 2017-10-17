package com.vison.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vison.domain.User;
import com.vison.service.UserService;

public class AutoLoginFilter implements Filter
{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		// 1��ת����������HttpServletRequest,HttpServletResponse
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// 2������ҵ��
		// �õ�cookies����
		Cookie[] cookies = req.getCookies();
		Cookie cookie = null;
		String value = "";
		String username = "";
		String password = "";
		String uri = req.getRequestURI();// "/autologin/index.jsp"
		// System.out.println(uri);
		String path = req.getContextPath();// "/autologin"
		// System.out.println(path);
		path = uri.substring(path.length() + 1);// index.jsp
		// System.out.println(path);

		// ����������ȣ����Զ���¼
		if (!("index.jsp".equals(path) || "loginServlet".equals(path)))
		{
			User user = (User) req.getSession().getAttribute("user");
			// �û�û�е�¼������ִ���Զ���¼
			if (user == null)
			{
				System.out.println("*********�Զ���¼*****");
				for (int i = 0; cookies != null && i < cookies.length; i++)
				{
					if ("user".equals(cookies[i].getName()))
					{
						cookie = cookies[i];
						value = cookie.getValue();// vison&123
						String[] values = value.split("&");
						username = values[0];
						password = values[1];
					}

				}

				// ��¼����
				UserService us = new UserService();
				User u = us.findUser(username, password);
				// �����¼�ɹ������û���Ϣ���浽session��
				if (u != null)
				{
					req.getSession().setAttribute("user", u);
				}

			}
		}
		// 3������
		chain.doFilter(request, response);
	}

	@Override
	public void destroy()
	{
	}

}
