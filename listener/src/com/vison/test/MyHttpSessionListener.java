package com.vison.test;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener
{

	@Override
	public void sessionCreated(HttpSessionEvent arg0)
	{
		HttpSession session = arg0.getSession();
		// �õ�application�����еļ���
		ServletContext application = session.getServletContext();
		// �õ�session���󣬲����뵽list����
		List<HttpSession> list = (List<HttpSession>) application.getAttribute("sessions");
		list.add(session);
		System.out.println("�����:" + session.getId());

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0)
	{
	}

}
