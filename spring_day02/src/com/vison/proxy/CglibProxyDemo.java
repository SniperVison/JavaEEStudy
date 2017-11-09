package com.vison.proxy;

import org.junit.Test;

import com.vison.service.UserService;
import com.vison.service.UserServiceImpl;

public class CglibProxyDemo
{
	@Test
	// Cglib�����̳д���
	public void fun()
	{
		UserServiceProxyFactory2 factory = new UserServiceProxyFactory2();
		UserService usProxy = factory.getUserServiceProxy();
		usProxy.save();
		usProxy.delete();
		// �жϴ�������Ƿ����ڱ������������
		// ˵���� �������̳��˱�������󣬼���˵���Ǹ��ӹ�ϵ
		System.out.println(usProxy instanceof UserServiceImpl);// true
	}
}
