package com.vison.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.vison.domain.Customer;
import com.vison.utils.HibernateUtil;

//学习HQL语法
public class HQLDemo
{
	// 基本语法
	@Test
	public void fun1()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		String hql1 = "from com.vison.domain.Customer"; // 完整写法
		String hql2 = "from Customer";// 简单写法（前提是包内外没有其他相同类名的的类）
		String hql3 = "from java.lang.Object";// 查询全部表，实际意义不大
		Query query = session.createQuery(hql1);

		List<Customer> list = query.list();
		System.out.println(list);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	// 排序
	@Test
	public void fun2()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		String hql1 = "from com.vison.domain.Customer order by cust_id asc"; // 完整写法
		String hql2 = "from com.vison.domain.Customer order by cust_id desc"; // 完整写法

		Query query = session.createQuery(hql2);

		List<Customer> list = query.list();
		System.out.println(list);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	// 条件查询
	@Test
	public void fun3()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		/*指定查询哪一个
		 * String hql1 = "from com.vison.domain.Customer where cust_id=?";
		 query.setParameter(0, 2L);
		String hql2 = "from com.vison.domain.Customer where cust_id=:id";// 效果同上
		 query.setParameter("id", 2L);
		*/

		// 分页查询
		String hql1 = "from com.vison.domain.Customer";
		Query query = session.createQuery(hql1);
		// limit ?,?
		// (当前页数-1)*每页条数
		query.setFirstResult(2);
		query.setMaxResults(2);

		List<Customer> list = query.list();
		System.out.println(list);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	@Test
	// 统计查询
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

	// 投影查询
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
