package com.itheima.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClearServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����һ��Cookie����
		Cookie ck = new Cookie("lastAccessTime", "");
		ck.setPath("/");//Ҫ���ñ�ɾ��Cookie��path��������ܻ�ɾ�����
		ck.setMaxAge(0);//�൱��ɾ��
		response.addCookie(ck);//��ckд�ؿͻ��˻���
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
