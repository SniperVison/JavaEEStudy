package com.vison.injection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vison.bean.User;

public class ConstructorInjection
{
	// 测试构造函数注入
	@Test
	public void fun()
	{
		// 1--创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/vison/injection/applicationContext.xml");
		// 2--向容器“要”user对象
		User u = (User) ac.getBean("constructorInjection");

		// 3--打印User对象
		System.out.println(u);
	}

}
