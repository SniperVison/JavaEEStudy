package com.vison.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//##���ۣ���֤��web��Ŀ�У�ֻ����һ��SessionFactory 
public class HibernateUtil
{
	private static SessionFactory sessionFactory;
	// Ϊ�˱�֤��web��Ŀ�У�ֻ����һ��SessionFactory ���˴�ʹ�þ�̬����鴴��һ��SessionFactory����
	static
	{
		// 1�����������ÿղι���
		// 2����ȡָ���������ļ�->�ղμ��ط���������src�µ�hibernate.cfg.xml�ļ�
		Configuration conf = new Configuration().configure();
		// 3������������Ϣ������SessionFactory����
		sessionFactory = conf.buildSessionFactory();
	}

	// ����һ��ȫ�µ�session
	public static Session openSession()
	{
		Session session = sessionFactory.openSession();
		return session;
	}

	// ��ȡ���̰߳󶨵�session
	// *******ע��:ͨ��getCurrentSession�������session���󣬵��ύ����ʱ��session���Զ��رգ�����ǧ��Ҫ�ֶ�����close�رգ���Ȼ�ᱨ�쳣
	public static Session getCurrentSession()
	{
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession;
	}

	// �����Ƿ��ܴ���session
	/*@Test
	public void test1()
	{
		Session openSession = HibernateUtil.openSession();
		System.out.println(openSession);
	}*/
}
