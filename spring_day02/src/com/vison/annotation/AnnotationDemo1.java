package com.vison.annotation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vison.bean.User;

public class AnnotationDemo1
{
	@Test
	public void fun()
	{
		// 1--������������
		// ApplicationContext ac = new
		// ClassPathXmlApplicationContext("applicationContext.xml");
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 2--��������Ҫ��user����
		/*User u1 = (User) ac.getBean("user");
		User u2 = (User) ac.getBean("user");
		*/

		User u = (User) ac.getBean("user");
		// 3--��ӡUser����
		// System.out.println(u1 == u2);
		System.out.println(u);
		// �������ٷ���
		ac.close();
	}

}
