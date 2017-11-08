package com.vison.injection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vison.bean.CollectionBean;

public class ComplexTypeInjection
{
	// ���Ը�������ע��
	@Test
	public void fun()
	{
		// 1--������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/vison/injection/applicationContext.xml");
		// 2--��������Ҫ��user����
		CollectionBean cb = (CollectionBean) ac.getBean("cb");

		// 3--��ӡUser����
		System.out.println(cb);
	}
}
