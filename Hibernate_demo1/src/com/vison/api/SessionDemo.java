package com.vison.api;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.vison.domain.User;

//session������:���hibernate��������ݿ�֮������ӣ��Ự����session������JDBC�����connection���󣬻�������ɶ����ݿ������ݵ���ɾ�Ĳ����
//����session��hibernate�������ݿ�ĺ��Ķ���
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
			// 1�����������ÿղι���
			// 2����ȡָ���������ļ�->�ղμ��ط���������src�µ�hibernate.cfg.xml�ļ�
			Configuration conf = new Configuration().configure();
			// 3������������Ϣ������SessionFactory����
			sessionFactory = conf.buildSessionFactory();
			// 4�����session,��һ���µ�session����
			session = sessionFactory.openSession();
			// 5��session��ò��������Transaction����
			// ����һ����ȡ���������transaction����,����������
			/* 
			Transaction transaction = session.getTransaction();
			transaction.begin();
			*/
			// ����������ȡ���������beginTransaction���󲢿������񣨽���ʹ�ã�
			beginTransaction = session.beginTransaction();
			// -----------------------------------------------------------
			// int i = 10 / 0; // ���Իع�����

			// ��
			addUser(session);

			// ɾ
			deleteUser(session);

			// ��
			updateUser(session);

			// ����id�飨�ȼ򵥵ģ�
			selectUserSimple(session);

			// -----------------------------------------------------------
			beginTransaction.commit();// �ύ����

		} catch (HibernateException e)
		{
			beginTransaction.rollback();// �ع�����
		} finally
		{
			// �ͷ���Դ
			session.close();
			sessionFactory.close();
		}

	}

	public void deleteUser(Session session)
	{
		// 1����ȡҪɾ���Ķ���
		User u = session.get(User.class, 3);
		// 2��ִ��delete
		session.delete(u);
	}

	public void updateUser(Session session)
	{
		// 1����ȡҪ�޸ĵĶ���
		User u = session.get(User.class, 2);
		// 2���޸�
		u.setName("lvshijing");
		// 3��ִ��update
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
