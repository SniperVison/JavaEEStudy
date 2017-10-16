package com.vison.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//监听域对象的创建和销毁
public class MyServletContextListener implements ServletContextListener
{
	// 关闭服务器销毁
	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
		System.out.println("ServletContext对象销毁了");
	}

	// 开启服务器就创建
	@Override
	public void contextInitialized(ServletContextEvent arg0)
	{
		System.out.println("ServletContext对象创建了");
	}

}
