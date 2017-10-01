package com.vison.ServletConfig;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigDemo1 extends HttpServlet
{

	public ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException
	{
		this.config = config;
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// ��һ�ַ�ʽ����Ҫ ʹ�õ�config����
		String encoding = config.getInitParameter("encoding");// ��ȡ�����ļ��е���Ϣ
		System.out.println(encoding);

		// �ڶ��ַ�ʽ,ͬ�� ��Ҫ �� init���������� �����ı���config
		/*String encoding = super.getServletConfig().getInitParameter("encoding");
		System.out.println(encoding);*/

		// �����ַ�ʽ����Ҫ ��ע�� init���������� �����ı���config
		/*String encoding = super.getInitParameter("encoding");
		System.out.println(encoding);*/

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{

	}

}
