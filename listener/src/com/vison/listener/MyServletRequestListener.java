package com.vison.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

//request�����Ƿ�������ʱ����������Ӧ����ʱ������.
public class MyServletRequestListener implements ServletRequestListener
{
	// �������������
	@Override
	public void requestDestroyed(ServletRequestEvent arg0)
	{
		System.out.println("ServletRequest����������");
	}

	// ����jsp�ȵȾʹ���
	@Override
	public void requestInitialized(ServletRequestEvent arg0)
	{
		System.out.println("ServletRequest���󴴽���");
	}

}
