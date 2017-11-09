package com.vison.proxy;

import org.junit.Test;

import com.vison.service.UserService;
import com.vison.service.UserServiceImpl;

public class CglibProxyDemo
{
	@Test
	// Cglib代理，继承代理
	public void fun()
	{
		UserServiceProxyFactory2 factory = new UserServiceProxyFactory2();
		UserService usProxy = factory.getUserServiceProxy();
		usProxy.save();
		usProxy.delete();
		// 判断代理对象是否属于被代理对象类型
		// 说明了 代理对象继承了被代理对象，简单来说就是父子关系
		System.out.println(usProxy instanceof UserServiceImpl);// true
	}
}
