package com.vison.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.vison.service.UserService;
import com.vison.service.UserServiceImpl;

//��̬�����ʾ������
public class UserServiceProxyFactory implements InvocationHandler
{
	private UserService us;

	public UserServiceProxyFactory(UserService us)
	{
		super();
		this.us = us;
	}

	public UserService getUserServiceProxy()
	{
		// ���ɶ�̬����
		UserService usProxy = (UserService) Proxy.newProxyInstance(UserServiceProxyFactory.class.getClassLoader(),
				UserServiceImpl.class.getInterfaces(), this);
		// ����
		return usProxy;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		System.out.println("������");
		Object invoke = method.invoke(us, args);
		System.out.println("�ύ����");
		return invoke;
	}
}
