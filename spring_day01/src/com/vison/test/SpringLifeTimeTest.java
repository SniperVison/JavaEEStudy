package com.vison.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vison.bean.User;

public class SpringLifeTimeTest
{
	// 测试spring容器的生命周期，初始化和销毁方法
	@Test
	public void fun()
	{
		// 1--创建容器对象
		/*		ApplicationContext ac = new ClassPathXmlApplicationContext("com/vison/test/applicationContext.xml");*/
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("com/vison/test/applicationContext.xml");

		// 2--向容器“要”user对象
		User u = (User) ac.getBean("springlifetimetest");
		System.out.println(u);

		/*	close方法是为了体验生命周期中的销毁方法，在ApplicationContext的实现类ClassPathXmlApplicationContext才有的，*/
		ac.close();

	}
}
