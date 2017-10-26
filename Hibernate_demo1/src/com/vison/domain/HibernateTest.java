package com.vison.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class HibernateTest
{
	@Test
	public void fun()
	{
		// 1����ȡ�����ļ�
		Configuration conf = new Configuration().configure();
		// 2���������ô���Factory
		SessionFactory sessionFactory = conf.buildSessionFactory();
		// 3��ͨ����ȡ�������ݿ��session����
		Session session = sessionFactory.openSession();
		// 4���������ݿ�
		User u = new User();
		u.setName("vison");
		u.setPassword("123");
		session.save(u);
		// 5���ر���Դ
		session.close();
		sessionFactory.close();

	}

}
