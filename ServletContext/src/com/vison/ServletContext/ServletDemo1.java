package com.vison.ServletContext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo1 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// ͨ������GenericServlet��getServletContext�����õ�ServletContext�Ķ���
		ServletContext application = this.getServletContext();
		// ��ServletContext����һ����ֵ��
		application.setAttribute("name", "Vison");
		// ��ȡ����
		System.out.println(application.getClass().getName());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		super.doPost(req, resp);
	}

}