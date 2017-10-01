package com.itheima.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
			//��ȡ�ͻ��˱����������ʱ��
			Cookie[] cookies = request.getCookies();//��ȡ�ͻ��˵�����Cookie����
			for (int i = 0;cookies!=null && i < cookies.length; i++) {
				if("lastAccessTime".equals(cookies[i].getName())){//�жϵ�ǰCookie�е�name�Ƿ�����Ҫ��cookie
					long l = Long.parseLong(cookies[i].getValue());//�������Ҫ��Cookie�����Cookie�е�valueȡ��
					out.write("���������ʱ��Ϊ��"+new Date(l).toLocaleString());//yyyy-MM-dd
				}
			}
		
			out.print("<a href='"+request.getContextPath()+"/servlet/clear'>clear</a>");
			//����cookie��
			Cookie ck = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
			//����cookie����Чʱ��,��λ����
			ck.setMaxAge(60*5);//����ʱ��Ϊ5����
			//����cookie��path
			//ck.setPath("/day10_00_cookie");
			//ck.setPath(request.getContextPath());//  /day10_00_cookie
			ck.setPath("/");//  /day10_00_cookie
			//��cookie��Ϣд�ص��ͻ���
			response.addCookie(ck);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
