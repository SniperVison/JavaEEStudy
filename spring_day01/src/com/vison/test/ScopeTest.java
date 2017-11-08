package com.vison.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vison.bean.User;

public class ScopeTest
{
	// 对象创建方式一: 空参构造创建对象
	@Test
	public void fun()
	{
		// 1--创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/vison/test/applicationContext.xml");
		// 2--向容器“要”user对象
		User u1 = (User) ac.getBean("scopetest");
		User u2 = (User) ac.getBean("scopetest");
		User u3 = (User) ac.getBean("scopetest");
		User u4 = (User) ac.getBean("scopetest");

		// scope:singleton(默认是单例，大多数情况下)->true 单例对象，被标识为单例的对象在spring容器中只会存在一个实例
		// scope:prototype(多例，整合struts2时，ActionBean必须配置多例)->false
		// 多例原型，被标识为多例的对象，每次再获得才会创建，每次创建都是新的对象
		// request(用处不大):web环境下，对象与request生命周期一致
		// session(用处不大):web环境下，对象与session生命周期一致
		// 3--打印User对象
		System.out.println(u1 == u2);

	}
}
