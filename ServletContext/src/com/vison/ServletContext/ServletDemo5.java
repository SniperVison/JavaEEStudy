package com.vison.ServletContext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Demo5&Demo6ʵ������ת��
public class ServletDemo5 extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("Demo5:��Ҫ����");
		System.out.println("Demo5:�������Ұ첻�ˣ��ҿ��԰������˰�");
		// ������ת���� Demo6�����´�������
		ServletContext application = this.getServletContext();
		application.getRequestDispatcher("/Demo6").forward(request, response);
		// �������� һ��
		// д����this.getServletContext().getRequestDispatcher("/Demo6").forward(request,
		// response);
		System.out.println("Demo5:������");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
