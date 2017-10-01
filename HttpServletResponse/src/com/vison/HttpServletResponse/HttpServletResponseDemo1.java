package com.vison.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�˴���Ϊѧϰ�����ʽ�ı任
public class HttpServletResponseDemo1 extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/*
		 * ����һ��
		 * // ��������Ĭ�ϵı���ΪISO-8859-1������֧�����ģ�tomcat�涨��
		// ͬʱchrome���°汾û���ֶ��޸ı����ʽ��ѡ���Ҫ���ز����Charset��
		response.setCharacterEncoding("UTF-8");// ���߷�����Ӧ��ʹ��UTF-8�����ı�
		response.setHeader("content-type", "text/html;charset=UTF-8");// ���߿ͻ���Ҫʹ��ʲô����
		*/

		// ��������
		// ���Ҹ��߷�����Ӧ��ʹ��UTF-8�����ı�,���߿ͻ���Ҫʹ��ʲô����
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();// �õ�һ���ַ������
		out.write("hello vison��  ���ğ�");// ��ͻ�����Ӧ�ı�����
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
