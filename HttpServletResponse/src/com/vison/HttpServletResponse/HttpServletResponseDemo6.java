package com.vison.HttpServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//demo6 &demo7������ʵ���ض����ܵ�
public class HttpServletResponseDemo6 extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("�����A:��Ҫ��Ǯ��");
		System.out.println("�����B:��ûǮ�������ҿ��Ը�������˭�裡");

		/*����ʵ���ض���ķ���һ�����Ƽ�
		 * response.setStatus(302);// ���߿ͻ������¶����µ���Դ
		response.setHeader("location", "/HttpServletResponse/demo7");//���߿ͻ���Ҫȥ�����ĸ�URL
		*/ System.out.println("�����A:��ȥ��Ǯ��");
		// ����ʵ���ض���ķ��������Ƽ�ʹ��
		response.sendRedirect("/HttpServletResponse/demo7");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
