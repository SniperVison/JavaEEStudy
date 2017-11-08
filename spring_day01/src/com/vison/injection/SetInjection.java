package com.vison.injection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vison.bean.User;

public class SetInjection
{
	// ����setע��
	@Test
	public void fun()
	{
		// 1--������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/vison/injection/applicationContext.xml");
		// 2--��������Ҫ��user����
		User u = (User) ac.getBean("setinjection");

		// 3--��ӡUser����
		System.out.println(u);

	}
}
