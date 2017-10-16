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
		// 得到application对象中的集合
		ServletContext application = session.getServletContext();
		// 得到session对象，并放入到list集合
		List<HttpSession> list = (List<HttpSession>) application.getAttribute("sessions");
		list.add(session);
		System.out.println("添加了:" + session.getId());

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0)
	{
	}

}
