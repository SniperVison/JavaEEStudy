package com.vison.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//���������Ĵ���������
public class MyServletContextListener implements ServletContextListener
{
	// �رշ���������
	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
		System.out.println("ServletContext����������");
	}

	// �����������ʹ���
	@Override
	public void contextInitialized(ServletContextEvent arg0)
	{
		System.out.println("ServletContext���󴴽���");
	}

}
