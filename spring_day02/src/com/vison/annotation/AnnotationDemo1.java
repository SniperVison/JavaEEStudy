package com.vison.annotation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vison.bean.User;

public class AnnotationDemo1
{
	@Test
	public void fun()
	{
		// 1--创建容器对象
		// ApplicationContext ac = new
		// ClassPathXmlApplicationContext("applicationContext.xml");
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 2--向容器“要”user对象
		/*User u1 = (User) ac.getBean("user");
		User u2 = (User) ac.getBean("user");
		*/

		User u = (User) ac.getBean("user");
		// 3--打印User对象
		// System.out.println(u1 == u2);
		System.out.println(u);
		// 测试销毁方法
		ac.close();
	}

}
