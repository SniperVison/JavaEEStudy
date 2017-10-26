package com.vison.api;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.vison.domain.User;

//session对象功能:表达hibernate框架与数据库之间的连接（会话），session类似于JDBC年代的connection对象，还可以完成对数据库中数据的增删改查操作
//所以session是hibernate操作数据库的核心对象
public class SessionDemo
{
	@Test
	public void fun3()
	{

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction beginTransaction = null;
		try
		{
			// 1、创建，调用空参构造
			// 2、读取指定主配置文件->空参加载方法，加载src下的hibernate.cfg.xml文件
			Configuration conf = new Configuration().configure();
			// 3、根据配置信息，创建SessionFactory对象
			sessionFactory = conf.buildSessionFactory();
			// 4、获得session,打开一个新的session对象
			session = sessionFactory.openSession();
			// 5、session获得操作事务的Transaction对象
			// 方法一：获取操作事务的transaction对象,并开启事务
			/* 
			Transaction transaction = session.getTransaction();
			transaction.begin();
			*/
			// 方法二：获取操作事务的beginTransaction对象并开启事务（建议使用）
			beginTransaction = session.beginTransaction();
			// -----------------------------------------------------------
			// int i = 10 / 0; // 测试回滚操作

			// 增
			addUser(session);

			// 删
			deleteUser(session);

			// 改
			updateUser(session);

			// 根据id查（先简单的）
			selectUserSimple(session);

			// -----------------------------------------------------------
			beginTransaction.commit();// 提交事务

		} catch (HibernateException e)
		{
			beginTransaction.rollback();// 回滚事务
		} finally
		{
			// 释放资源
			session.close();
			sessionFactory.close();
		}

	}

	public void deleteUser(Session session)
	{
		// 1、获取要删除的对象
		User u = session.get(User.class, 3);
		// 2、执行delete
		session.delete(u);
	}

	public void updateUser(Session session)
	{
		// 1、获取要修改的对象
		User u = session.get(User.class, 2);
		// 2、修改
		u.setName("lvshijing");
		// 3、执行update
		session.update(u);
	}

	public void selectUserSimple(Session session)
	{
		User user = session.get(User.class, 2);
		System.out.println(user);
	}

	public void addUser(Session session)
	{
		User u = new User();
		u.setName("tom");
		u.setPassword("666");
		session.save(u);
	}

}
