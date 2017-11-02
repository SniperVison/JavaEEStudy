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

//关联级别 延迟加载|抓取策略
public class Demo1
{
	@Test
	// 集合级别的关联
	// fetch：select 单表查询
	// lazy：true 延迟加载，使用数据时才加载
	public void fun1()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		Customer c = session.get(Customer.class, 2L);
		Set<LinkMan> linkMans = c.getLinkMans();// 关联级别
		System.out.println(linkMans);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	@Test
	// 集合级别的关联
	// fetch：select 单表查询
	// lazy：false 立即加载集合数据
	public void fun2()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		Customer c = session.get(Customer.class, 2L);
		Set<LinkMan> linkMans = c.getLinkMans();// 关联级别
		System.out.println(linkMans);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	@Test
	// 集合级别的关联
	// fetch：select 单表查询
	// lazy：extra(极其懒惰) ,与懒加载效果基本一致，如果只获得集合的size，只查询集合的size（count语句）
	public void fun3()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		Customer c = session.get(Customer.class, 2L);
		Set<LinkMan> linkMans = c.getLinkMans();// 关联级别
		System.out.println(linkMans.size());
		System.out.println(linkMans);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();
	}

	@Test
	// 集合级别的关联
	// fetch：join 多表查询
	// lazy：true|false|extra 全部都失效，都是立即加载
	public void fun4()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		Customer c = session.get(Customer.class, 2L);
		Set<LinkMan> linkMans = c.getLinkMans();// 关联级别
		System.out.println(linkMans.size());
		System.out.println(linkMans);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	@SuppressWarnings(
	{ "rawtypes", "unchecked" })
	@Test
	// 集合级别的关联
	// fetch：subselect 子查询
	// lazy：true 懒加载
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
	// 集合级别的关联
	// fetch：subselect 子查询
	// lazy：false 立即加载
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
	// 集合级别的关联
	// fetch：subselect 子查询
	// lazy：extra 极其懒惰
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
