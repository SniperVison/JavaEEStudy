package com.vison.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.vison.domain.Customer;
import com.vison.utils.HibernateUtil;

//学习Criteria语法
public class CriteriaDemo
{
	// 基本查询
	@Test
	public void fun1()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		Criteria c = session.createCriteria(Customer.class);
		List<Customer> list = c.list();
		System.out.println(list);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	// 条件查询
	@Test
	public void fun2()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		Criteria c = session.createCriteria(Customer.class);
		// c.add(Restrictions.idEq(2L));
		c.add(Restrictions.eq("cust_id", 2L));
		List<Customer> list = c.list();
		System.out.println(list);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	// 分页查询，与HQL一样
	@Test
	public void fun3()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		Criteria c = session.createCriteria(Customer.class);
		// limit ?,?
		c.setFirstResult(0);
		c.setMaxResults(2);
		List<Customer> list = c.list();
		System.out.println(list);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	// 排序语法
	@Test
	public void fun4()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		Criteria c = session.createCriteria(Customer.class);
		// 升序
		// c.addOrder(Order.asc("cust_id"));
		// 降序
		c.addOrder(Order.desc("cust_id"));
		List<Customer> list = c.list();
		System.out.println(list);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	// 统计语法
	@Test
	public void fun5()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------

		Criteria c = session.createCriteria(Customer.class);
		// 设置查询目标,Projections里面有所有的聚合函数可以选择
		c.setProjection(Projections.rowCount());
		List<Customer> list = c.list();
		System.out.println(list);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}
}
