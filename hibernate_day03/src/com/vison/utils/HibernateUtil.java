package com.vison.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//##结论：保证在web项目中，只创建一个SessionFactory 
public class HibernateUtil
{
	private static SessionFactory sessionFactory;
	// 为了保证在web项目中，只创建一个SessionFactory ，此处使用静态代码块创建一个SessionFactory对象
	static
	{
		// 1、创建，调用空参构造
		// 2、读取指定主配置文件->空参加载方法，加载src下的hibernate.cfg.xml文件
		Configuration conf = new Configuration().configure();
		// 3、根据配置信息，创建SessionFactory对象
		sessionFactory = conf.buildSessionFactory();
	}

	// 创建一个全新的session
	public static Session openSession()
	{
		Session session = sessionFactory.openSession();
		return session;
	}

	// 获取与线程绑定的session
	// *******注意:通过getCurrentSession方法获得session对象，当提交事务时，session会自动关闭，所以千万不要手动调用close关闭，不然会报异常
	public static Session getCurrentSession()
	{
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession;
	}

	// 测试是否能创建session
	/*@Test
	public void test1()
	{
		Session openSession = HibernateUtil.openSession();
		System.out.println(openSession);
	}*/
}
