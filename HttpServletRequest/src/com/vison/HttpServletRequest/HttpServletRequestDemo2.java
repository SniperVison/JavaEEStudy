package com.vison.HttpServletRequest;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletRequestDemo2 extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// testHeader(request);

		// ö�٣��������������Ϣͷ��name
		Enumeration names = request.getHeaderNames();
		while (names.hasMoreElements())
		{
			String elem = (String) names.nextElement();
			System.out.println(elem + ":" + request.getHeader(elem));
		}

	}

	public void testHeader(HttpServletRequest request)
	{
		// ���������Ϣͷ����Ϣ
		String header = request.getHeader("User-Agent");
		System.out.println(header);
		if (header.toLowerCase().contains("edge"))
			System.out.println("��ʹ�õ���Edge�����");
		else if (header.toLowerCase().contains("chrome"))
			System.out.println("��ʹ�õ�Chrome�����");
		else
			System.out.println("��ʹ�õ���IE11�����");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
