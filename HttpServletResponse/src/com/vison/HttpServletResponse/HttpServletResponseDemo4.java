package com.vison.HttpServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletResponseDemo4 extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");// ���ÿͻ���Ӧʹ��UTF-8�����ʽ
		/*response.setIntHeader("refresh", 1);// ����1sˢ��һ��
		Random r = new Random();
		response.getWriter().write(r.nextInt() + "");//ͳһת��Ϊ�ַ���*/
		response.getWriter().write("ע��ɹ���3������ת����ҳ");// ��ͻ���д���ı���Ϣ
		// ����3������ת
		response.setHeader("refresh", "3;url=/HttpServletResponse/demo5");// ����3����demo4��ת��demo5
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
