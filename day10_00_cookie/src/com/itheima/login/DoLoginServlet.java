package com.itheima.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//��ȡ������
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String remember = request.getParameter("remember");
		
		Cookie ck = new Cookie("userName", userName);
		ck.setPath("/");
		//����ҵ���߼�
		//�ַ�ת��
		if("tom".equals(userName)&&"123".equals(pwd)){
			if(remember!=null){
				ck.setMaxAge(Integer.MAX_VALUE);//����Cookie����Ч����ʱ��
			}else{
				ck.setMaxAge(0);//ɾ�� Cookie
			}
			response.addCookie(ck);//��Cookieд�ص��ͻ���
			out.write("��¼�ɹ���");
		}else{
			out.write("��¼ʧ�ܣ�");
			//����2���������µ�¼
			response.setHeader("refresh", "2;url="+request.getContextPath()+"/servlet/login");
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
