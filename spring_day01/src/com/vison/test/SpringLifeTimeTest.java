package com.vison.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vison.bean.User;

public class SpringLifeTimeTest
{
	// ����spring�������������ڣ���ʼ�������ٷ���
	@Test
	public void fun()
	{
		// 1--������������
		/*		ApplicationContext ac = new ClassPathXmlApplicationContext("com/vison/test/applicationContext.xml");*/
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("com/vison/test/applicationContext.xml");

		// 2--��������Ҫ��user����
		User u = (User) ac.getBean("springlifetimetest");
		System.out.println(u);

		/*	close������Ϊ���������������е����ٷ�������ApplicationContext��ʵ����ClassPathXmlApplicationContext���еģ�*/
		ac.close();

	}
}
