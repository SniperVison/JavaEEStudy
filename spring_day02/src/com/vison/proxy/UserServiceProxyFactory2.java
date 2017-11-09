package com.vison.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.vison.service.UserService;
import com.vison.service.UserServiceImpl;

//cglib�����ʾ��
public class UserServiceProxyFactory2 implements MethodInterceptor
{

	public UserService getUserServiceProxy()
	{
		// ���������ɴ������
		Enhancer en = new Enhancer();

		// ���ö�˭���д���
		en.setSuperclass(UserServiceImpl.class);
		// ����Ҫ��ʲô
		en.setCallback(this);
		// �����������
		UserService us = (UserService) en.create();
		return us;
	}

	@Override
	public Object intercept(Object proxyobj, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable
	{
		// ������
		System.out.println("������");
		// ����ԭ�з���
		Object returnValue = methodProxy.invokeSuper(proxyobj, arg);

		// �ύ����
		System.out.println("�ύ����");
		return returnValue;
	}

}
