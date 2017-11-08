package com.vison.injection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vison.bean.CollectionBean;

public class ComplexTypeInjection
{
	// 测试复杂类型注入
	@Test
	public void fun()
	{
		// 1--创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/vison/injection/applicationContext.xml");
		// 2--向容器“要”user对象
		CollectionBean cb = (CollectionBean) ac.getBean("cb");

		// 3--打印User对象
		System.out.println(cb);
	}
}
