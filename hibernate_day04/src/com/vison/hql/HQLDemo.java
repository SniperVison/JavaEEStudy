package com.vison.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.vison.domain.Customer;
import com.vison.utils.HibernateUtil;

//ѧϰHQL�﷨
public class HQLDemo
{
	// �����﷨
	@Test
	public void fun1()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		String hql1 = "from com.vison.domain.Customer"; // ����д��
		String hql2 = "from Customer";// ��д����ǰ���ǰ�����û��������ͬ�����ĵ��ࣩ
		String hql3 = "from java.lang.Object";// ��ѯȫ����ʵ�����岻��
		Query query = session.createQuery(hql1);

		List<Customer> list = query.list();
		System.out.println(list);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	// ����
	@Test
	public void fun2()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		String hql1 = "from com.vison.domain.Customer order by cust_id asc"; // ����д��
		String hql2 = "from com.vison.domain.Customer order by cust_id desc"; // ����д��

		Query query = session.createQuery(hql2);

		List<Customer> list = query.list();
		System.out.println(list);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	// ������ѯ
	@Test
	public void fun3()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		/*ָ����ѯ��һ��
		 * String hql1 = "from com.vison.domain.Customer where cust_id=?";
		 query.setParameter(0, 2L);
		String hql2 = "from com.vison.domain.Customer where cust_id=:id";// Ч��ͬ��
		 query.setParameter("id", 2L);
		*/

		// ��ҳ��ѯ
		String hql1 = "from com.vison.domain.Customer";
		Query query = session.createQuery(hql1);
		// limit ?,?
		// (��ǰҳ��-1)*ÿҳ����
		query.setFirstResult(2);
		query.setMaxResults(2);

		List<Customer> list = query.list();
		System.out.println(list);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	@Test
	// ͳ�Ʋ�ѯ
	/*min,max,avg,count,sum*/
	public void fun4()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		/*String hqlCount = "select count(*) from com.vison.domain.Customer";
		Query query = session.createQuery(hqlCount);
		*/
		/*String hqlSum = "select sum(cust_id) from com.vison.domain.Customer";
		Query query = session.createQuery(hqlCount);*/

		/* String hqlAvg = "select avg(cust_id) from com.vison.domain.Customer";
		Query query = session.createQuery(hqlAvg);*/
		/*String hqlMax = "select max(cust_id) from com.vison.domain.Customer";
		Query query = session.createQuery(hqlMax);*/
		String hqlMin = "select min(cust_id) from com.vison.domain.Customer";
		Query query = session.createQuery(hqlMin);

		Number number = (Number) query.uniqueResult();
		System.out.println(number);
		/*
		 *  Object uniqueResult = query.uniqueResult();
		 * List<Customer> list = query.list();
		System.out.println(list);*/
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();
	}

	// ͶӰ��ѯ
	@Test
	public void fun5()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		/*String hql1 = "select cust_name from com.vison.domain.Customer";
		Query query = session.createQuery(hql1);
		List<Object> list = query.list();
		System.out.println(list);*/
		/*
				String hql2 = "select cust_name,cust_id from com.vison.domain.Customer";
				Query query = session.createQuery(hql2);
				List<Object[]> list = query.list();
				System.out.println(list);*/

		String hql3 = "select new Customer(cust_id ,cust_name)from com.vison.domain.Customer";
		Query query = session.createQuery(hql3);
		List<Object[]> list = query.list();
		System.out.println(list);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

}
