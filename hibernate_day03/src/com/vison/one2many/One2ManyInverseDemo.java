package com.vison.one2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.vison.domain.Customer;
import com.vison.domain.LinkMan;
import com.vison.utils.HibernateUtil;

//一对多|多对一关系操作
public class One2ManyInverseDemo
{
	// 一对多|多对一关系操作
	@Test
	public void fun()
	{
		// 1、获得session
		Session session = HibernateUtil.openSession();
		// 2、开启事务
		Transaction beginTransaction = session.beginTransaction();
		// 3、操作
		Customer c = new Customer();
		c.setCust_name("百度");

		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("李彦宏");

		LinkMan lm2 = new LinkMan();
		lm2.setLkm_name("吴伯恩");

		// 表达一对多，客户下有多个联系人
		// 如果客户(即一的一方)放弃维护与联系人的关系，维护关系的代码可以省略
		// c.getLinkMans().add(lm1);
		// c.getLinkMans().add(lm2);

		// 表达多对一，联系人属于哪个客户
		lm1.setCustomer(c);
		lm2.setCustomer(c);

		session.save(c);

		session.save(lm1);
		session.save(lm2);

		// 4、提交事务
		beginTransaction.commit();
		// 5、关闭资源
		session.close();

	}

	// 为客户增加联系人
	@Test
	public void fun2()
	{
		// 1、获得session
		Session session = HibernateUtil.openSession();
		// 2、开启事务
		Transaction beginTransaction = session.beginTransaction();
		// 3、操作
		// 3.1获得要操作的客户对象
		Customer c = session.get(Customer.class, 1L);

		// 3.2创建联系人
		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("雷军");

		// 3.3将联系人添加到客户，将客户设置到联系人中
		c.getLinkMans().add(lm1);
		lm1.setCustomer(c);

		// 3.4执行保存
		session.save(lm1);

		// 4、提交事务
		beginTransaction.commit();
		// 5、关闭资源
		session.close();

	}

	// 为客户删除联系人
	@Test
	public void fun3()
	{
		// 1、获得session
		Session session = HibernateUtil.openSession();
		// 2、开启事务
		Transaction beginTransaction = session.beginTransaction();
		// 3、操作
		// 3.1获得要操作的客户对象
		Customer c = session.get(Customer.class, 1L);

		// 3.2获取要移除的联系人
		LinkMan lm = session.get(LinkMan.class, 3L);

		// 3.3将联系人从客户集合中移除
		c.getLinkMans().remove(lm);// 这里已经是持久化状态了
		lm.setCustomer(null);// 这里已经是持久化状态了

		// 4、提交事务
		beginTransaction.commit();
		// 5、关闭资源
		session.close();

	}
}
