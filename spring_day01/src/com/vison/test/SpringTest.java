package com.vison.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vison.bean.User;

public class SpringTest
{
	// 示例
	@Test
	public void fun()
	{
		// 1--创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 2--向容器“要”user对象
		User u = (User) ac.getBean("user");
		// 3--打印User对象
		System.out.println(u);
	}

	// 对象创建方式一: 空参构造创建对象
	@Test
	public void fun2()
	{
		// 1--创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/vison/create/applicationContext.xml");
		/*// 2--向容器“要”user对象
		User u = (User) ac.getBean("user");
		// 3--打印User对象
		System.out.println(u);*/
	}

	// 对象创建方式二: 静态工厂创建对象
	@Test
	public void fun3()
	{
		// 1--创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/vison/create/applicationContext.xml");
		// 2--向容器“要”user对象
		User u = (User) ac.getBean("user2");
		// 3--打印User对象
		System.out.println(u);
	}

	// 对象创建方式三: 实例工厂创建对象(动态工厂)
	@Test
	public void fun4()
	{
		// 1--创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/vison/create/applicationContext.xml");
		// 2--向容器“要”user对象
		User u = (User) ac.getBean("user3");
		// 3--打印User对象
		System.out.println(u);
	}

}
