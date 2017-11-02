package com.vison.lazy_fetch;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import com.vison.domain.Customer;
import com.vison.domain.LinkMan;
import com.vison.utils.HibernateUtil;

//�������� �ӳټ���|ץȡ����
public class Demo1
{
	@Test
	// ���ϼ���Ĺ���
	// fetch��select �����ѯ
	// lazy��true �ӳټ��أ�ʹ������ʱ�ż���
	public void fun1()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		Customer c = session.get(Customer.class, 2L);
		Set<LinkMan> linkMans = c.getLinkMans();// ��������
		System.out.println(linkMans);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	@Test
	// ���ϼ���Ĺ���
	// fetch��select �����ѯ
	// lazy��false �������ؼ�������
	public void fun2()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		Customer c = session.get(Customer.class, 2L);
		Set<LinkMan> linkMans = c.getLinkMans();// ��������
		System.out.println(linkMans);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	@Test
	// ���ϼ���Ĺ���
	// fetch��select �����ѯ
	// lazy��extra(��������) ,��������Ч������һ�£����ֻ��ü��ϵ�size��ֻ��ѯ���ϵ�size��count��䣩
	public void fun3()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		Customer c = session.get(Customer.class, 2L);
		Set<LinkMan> linkMans = c.getLinkMans();// ��������
		System.out.println(linkMans.size());
		System.out.println(linkMans);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();
	}

	@Test
	// ���ϼ���Ĺ���
	// fetch��join ����ѯ
	// lazy��true|false|extra ȫ����ʧЧ��������������
	public void fun4()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		Customer c = session.get(Customer.class, 2L);
		Set<LinkMan> linkMans = c.getLinkMans();// ��������
		System.out.println(linkMans.size());
		System.out.println(linkMans);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	@SuppressWarnings(
	{ "rawtypes", "unchecked" })
	@Test
	// ���ϼ���Ĺ���
	// fetch��subselect �Ӳ�ѯ
	// lazy��true ������
	public void fun5()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		String hql = "from Customer";
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		for (Customer c : list)
		{
			System.out.println(c);
			System.out.println(c.getLinkMans().size());
			System.out.println(c.getLinkMans());
		}
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	@SuppressWarnings(
	{ "rawtypes", "unchecked" })
	@Test
	// ���ϼ���Ĺ���
	// fetch��subselect �Ӳ�ѯ
	// lazy��false ��������
	public void fun6()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		String hql = "from Customer";
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		for (Customer c : list)
		{
			System.out.println(c);
			System.out.println(c.getLinkMans().size());
			System.out.println(c.getLinkMans());
		}
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	@SuppressWarnings(
	{ "rawtypes", "unchecked" })
	@Test
	// ���ϼ���Ĺ���
	// fetch��subselect �Ӳ�ѯ
	// lazy��extra ��������
	public void fun7()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		String hql = "from Customer";
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		for (Customer c : list)
		{
			System.out.println(c);
			System.out.println(c.getLinkMans().size());
			System.out.println(c.getLinkMans());
		}
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}
}
