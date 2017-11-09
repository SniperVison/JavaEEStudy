package com.vison.proxy;

import org.junit.Test;

import com.vison.service.UserService;
import com.vison.service.UserServiceImpl;

public class ProxyDemo
{

	@Test
	// 动态代理
	public void fun()
	{
		UserService us = new UserServiceImpl();
		UserServiceProxyFactory factory = new UserServiceProxyFactory(us);
		UserService usProxy = factory.getUserServiceProxy();
		usProxy.save();
		usProxy.delete();

		// 代理对象与被代理对象实现了相同的接口
		// 所以代理对象与被代理对象没有继承关系，简单来说就像兄弟关系
		System.out.println(usProxy instanceof UserServiceImpl);
	}
}
