package com.vison.proxy;

import org.junit.Test;

import com.vison.service.UserService;
import com.vison.service.UserServiceImpl;

public class ProxyDemo
{

	@Test
	// ��̬����
	public void fun()
	{
		UserService us = new UserServiceImpl();
		UserServiceProxyFactory factory = new UserServiceProxyFactory(us);
		UserService usProxy = factory.getUserServiceProxy();
		usProxy.save();
		usProxy.delete();

		// ��������뱻�������ʵ������ͬ�Ľӿ�
		// ���Դ�������뱻�������û�м̳й�ϵ������˵�����ֵܹ�ϵ
		System.out.println(usProxy instanceof UserServiceImpl);
	}
}
