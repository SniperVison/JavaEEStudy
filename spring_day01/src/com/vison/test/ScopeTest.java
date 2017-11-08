package com.vison.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vison.bean.User;

public class ScopeTest
{
	// ���󴴽���ʽһ: �ղι��촴������
	@Test
	public void fun()
	{
		// 1--������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/vison/test/applicationContext.xml");
		// 2--��������Ҫ��user����
		User u1 = (User) ac.getBean("scopetest");
		User u2 = (User) ac.getBean("scopetest");
		User u3 = (User) ac.getBean("scopetest");
		User u4 = (User) ac.getBean("scopetest");

		// scope:singleton(Ĭ���ǵ���������������)->true �������󣬱���ʶΪ�����Ķ�����spring������ֻ�����һ��ʵ��
		// scope:prototype(����������struts2ʱ��ActionBean�������ö���)->false
		// ����ԭ�ͣ�����ʶΪ�����Ķ���ÿ���ٻ�òŻᴴ����ÿ�δ��������µĶ���
		// request(�ô�����):web�����£�������request��������һ��
		// session(�ô�����):web�����£�������session��������һ��
		// 3--��ӡUser����
		System.out.println(u1 == u2);

	}
}
