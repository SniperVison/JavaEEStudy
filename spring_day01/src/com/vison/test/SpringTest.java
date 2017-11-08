package com.vison.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vison.bean.User;

public class SpringTest
{
	// ʾ��
	@Test
	public void fun()
	{
		// 1--������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 2--��������Ҫ��user����
		User u = (User) ac.getBean("user");
		// 3--��ӡUser����
		System.out.println(u);
	}

	// ���󴴽���ʽһ: �ղι��촴������
	@Test
	public void fun2()
	{
		// 1--������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/vison/create/applicationContext.xml");
		/*// 2--��������Ҫ��user����
		User u = (User) ac.getBean("user");
		// 3--��ӡUser����
		System.out.println(u);*/
	}

	// ���󴴽���ʽ��: ��̬������������
	@Test
	public void fun3()
	{
		// 1--������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/vison/create/applicationContext.xml");
		// 2--��������Ҫ��user����
		User u = (User) ac.getBean("user2");
		// 3--��ӡUser����
		System.out.println(u);
	}

	// ���󴴽���ʽ��: ʵ��������������(��̬����)
	@Test
	public void fun4()
	{
		// 1--������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/vison/create/applicationContext.xml");
		// 2--��������Ҫ��user����
		User u = (User) ac.getBean("user3");
		// 3--��ӡUser����
		System.out.println(u);
	}

}
