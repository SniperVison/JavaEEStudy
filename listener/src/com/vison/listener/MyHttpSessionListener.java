package com.vison.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener
{
	// ֱ�ӷ���һ��jsp��ʱ��ʹ���HttpSession����
	@Override
	public void sessionCreated(HttpSessionEvent arg0)
	{
		System.out.println("HttpSession���󴴽���");
	}
	/*���ٶ��������ַ�����
	 * 1��Ĭ�ϳ�ʱ��30min
	 * 2���رշ�����
	 * 3��invalidate()��������session
	 * 4��setMaxInactiveInterval ���ó�ʱʱ��
	 * */

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0)
	{
		System.out.println("HttpSession����������");

	}

}
