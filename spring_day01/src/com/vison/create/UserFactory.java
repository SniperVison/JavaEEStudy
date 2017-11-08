package com.vison.create;

import com.vison.bean.User;

public class UserFactory
{

	// 创建方式二:静态工厂创建
	public static User createUser()
	{
		System.out.println("静态工厂创建User对象");
		return new User();
	}

	// 创建方式三：实例工厂创建
	public User createUser2()
	{
		System.out.println("实例工厂创建User对象");
		return new User();
	}
}
