package com.vison.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// response.setContentType("text/html;charset=UTF-8");
		// request.setCharacterEncoding("UTF-8");
		// ��Ϊ�ϴ��ļ���Ҫʹ�õ�enctype="multipart/form-data"������request.getParameter()��ʧЧ�ģ���ʹ��IO�����в����ſ����������
		/*	String username = request.getParameter("username");
			String upload = request.getParameter("upload");
			System.out.println(username);
			System.out.println(upload);*/
		// ʹ��IO�������������
		ServletInputStream sis = request.getInputStream();
		int len = 0;
		byte[] b = new byte[1024];
		while ((len = sis.read(b)) != -1)
		{
			System.out.println(new String(b, 0, len));
		}
		sis.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);

	}

}
