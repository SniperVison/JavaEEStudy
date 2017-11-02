package com.vison.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.vison.domain.Customer;
import com.vison.utils.HibernateUtil;

//HQL语法，多表查询语法,不常用
public class HQLDemo2
{
	/*-----原生SQL---------------*/
	// 交叉连接-笛卡尔积（避免）
	/*select * from A,B*/
	// 内连接
	// ！！！1-隐式内连接
	/*select * from A,B where b.aid=a.id*/
	// ！！！2-显示内连接
	/*select * from A inner join B on b.aid=a.id*/
	// 外连接
	// ！！！ 1-左外连接
	/*select * from A left [outer] join B on b.aid=a.id*/
	// ！！！2-右外连接
	/*select * from A right [outer] join B on b.aid=a.id*/
	// ---------------------------------------------------------------------------

	/*HQL的多表查询*/
	// 内连接->将连接的两端对象分别返回，放到数组中
	@Test
	public void fun1()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// --------------------------------------------------------------
		String hqlInner = "from Customer c inner join  c.linkMans ";
		Query query = session.createQuery(hqlInner);
		List<Object[]> list = query.list();
		for (Object[] objects : list)
		{
			System.out.println(Arrays.toString(objects));
		}

		// --------------------------------------------------------------
		beginTransaction.commit();
		session.close();
	}

	@Test
	// 迫切内连接==帮我们进行封装，返回值就是一个对象
	// 要将Customer的toString方法修改成自己迫切需要的字符串
	public void fun2()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// --------------------------------------------------------------
		// 迫切查询，sql语句需要加入fetch
		String hqlInner = "from Customer c inner  join fetch  c.linkMans ";
		Query query = session.createQuery(hqlInner);
		List<Customer> list = query.list();

		System.out.println(list);

		// --------------------------------------------------------------
		beginTransaction.commit();
		session.close();
	}

	// ！！！2--右外连接->将连接的两端对象分别返回，放到数组中
	@Test
	public void fun4()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// --------------------------------------------------------------
		String hqlInner = "from Customer c right join  c.linkMans ";
		Query query = session.createQuery(hqlInner);
		List<Object[]> list = query.list();
		for (Object[] objects : list)
		{
			System.out.println(Arrays.toString(objects));
		}

		// --------------------------------------------------------------
		beginTransaction.commit();
		session.close();
	}

	// 外连接
	// ！！！1--左外连接->将连接的两端对象分别返回，放到数组中
	@Test
	public void fun3()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// --------------------------------------------------------------
		String hqlInner = "from Customer c left join  c.linkMans ";
		Query query = session.createQuery(hqlInner);
		List<Object[]> list = query.list();
		for (Object[] objects : list)
		{
			System.out.println(Arrays.toString(objects));
		}

		// --------------------------------------------------------------
		beginTransaction.commit();
		session.close();
	}

}
