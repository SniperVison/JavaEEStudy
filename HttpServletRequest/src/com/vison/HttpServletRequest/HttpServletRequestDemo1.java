package com.vison.HttpServletRequest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�˴���Ϊʵ����������Ϣ�еķ���
public class HttpServletRequestDemo1 extends HttpServlet
{
	/*
	 * ��getMethod() ;��ȡ����ʽ
	 *�ص㣺 ��getRequestURL(); ���ؿͻ��˷�������ʱ������URL
	 *�ص㣺 ��getRequestURI();  �����������е���Դ������
	 *�ǳ��ص㣺 ��getContextPath(); ��ǰӦ�õ�����Ŀ¼
	 * ��getQueryString(); �����������еĲ������� 
	 * */

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		System.out.println(request.getMethod());// Get����ʽ
		System.out.println(request.getRequestURL());// ��Ϊhttp://localhost:8080/HttpServletRequest/demo1
		System.out.println(request.getRequestURI());// ��Ϊ/HttpServletRequest/demo1
		System.out.println(request.getContextPath());// ��Ϊ/HttpServletRequest
		System.out.println(request.getQueryString());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
