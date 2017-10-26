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
		// 1、读取配置文件
		Configuration conf = new Configuration().configure();
		// 2、根据配置创建Factory
		SessionFactory sessionFactory = conf.buildSessionFactory();
		// 3、通过获取操作数据库的session对象
		Session session = sessionFactory.openSession();
		// 4、操作数据库
		User u = new User();
		u.setName("vison");
		u.setPassword("123");
		session.save(u);
		// 5、关闭资源
		session.close();
		sessionFactory.close();

	}

}
