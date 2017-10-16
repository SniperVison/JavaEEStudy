package com.vison.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener
{
	// 直接访问一个jsp的时候就创建HttpSession对象
	@Override
	public void sessionCreated(HttpSessionEvent arg0)
	{
		System.out.println("HttpSession对象创建了");
	}
	/*销毁对象有四种方法：
	 * 1、默认超时：30min
	 * 2、关闭服务器
	 * 3、invalidate()方法销毁session
	 * 4、setMaxInactiveInterval 设置超时时间
	 * */

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0)
	{
		System.out.println("HttpSession对象销毁了");

	}

}
