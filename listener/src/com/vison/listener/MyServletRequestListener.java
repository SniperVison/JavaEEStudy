package com.vison.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

//request对象是发送请求时创建，当响应产生时，销毁.
public class MyServletRequestListener implements ServletRequestListener
{
	// 用完请求就销毁
	@Override
	public void requestDestroyed(ServletRequestEvent arg0)
	{
		System.out.println("ServletRequest对象销毁了");
	}

	// 访问jsp等等就创建
	@Override
	public void requestInitialized(ServletRequestEvent arg0)
	{
		System.out.println("ServletRequest对象创建了");
	}

}
