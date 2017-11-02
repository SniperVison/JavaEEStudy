package com.vison.lazy_fetch;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.vison.domain.Customer;
import com.vison.domain.LinkMan;
import com.vison.utils.HibernateUtil;

//关联级别 延迟加载|抓取策略

//关联属性策略结论：为了提高效率，fetch的选择上应选择select，lazy的取值应选择true，即全部使用默认值

//no-session问题的解决方法：扩大session的作用范围（使用filter，session，事务的关闭放在filter的放行操作之后执行）
public class Demo2
{
	@Test
	// 集合级别的关联
	// fetch：select 单表查询
	// lazy：proxy（默认值）-------Customer：true 懒加载
	public void fun1()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		LinkMan lm = session.get(LinkMan.class, 1L);
		Customer customer = lm.getCustomer();
		System.out.println(customer);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	@Test
	// 集合级别的关联
	// fetch：select 单表查询
	// lazy：proxy（默认值）-------Customer：false 立即加载
	public void fun2()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		LinkMan lm = session.get(LinkMan.class, 1L);
		Customer customer = lm.getCustomer();
		System.out.println(customer);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	@Test
	// 集合级别的关联
	// fetch：join 多表查询
	// lazy：全部失效
	public void fun3()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		LinkMan lm = session.get(LinkMan.class, 1L);
		Customer customer = lm.getCustomer();
		System.out.println(customer);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

}
