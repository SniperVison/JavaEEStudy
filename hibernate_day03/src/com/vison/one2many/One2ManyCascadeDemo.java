package com.vison.one2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.vison.domain.Customer;
import com.vison.domain.LinkMan;
import com.vison.utils.HibernateUtil;

//###注意:级联操作的意义在于简化操作，减少代码量，如果要用的话，只能用save-update，因为delete太危险了，会把表内容全删除的，all（因为是save-update+delete），所以也不能使用
//在Customer.hbm.xml或者LinkMan.hbm.xml文件中添加cascade属性，就可以进行级联操作了
public class One2ManyCascadeDemo
{

	// 一对多|多对一关系操作
	// cascade=save-update
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
		c.getLinkMans().add(lm1);
		c.getLinkMans().add(lm2);

		// 表达多对一，联系人属于哪个客户
		lm1.setCustomer(c);
		lm2.setCustomer(c);

		session.save(c);
		/*在Customer.hbm.xml文件中添加cascade（级联），就可以自动保存更新了
		session.save(lm1);
		session.save(lm2);
		*/
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

	// 测试删除客户时，级联删除客户下的联系人
	// cascade=delete
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

		// 3.2调用delete删除客户
		session.delete(c);

		// 4、提交事务
		beginTransaction.commit();
		// 5、关闭资源
		session.close();

	}

	// 保存联系人以及联系人对应的客户
	// 在LinkMan.hbm.xml文件中加入 cascade=save-update
	@Test
	public void fun4()
	{
		// 1、获得session
		Session session = HibernateUtil.openSession();
		// 2、开启事务
		Transaction beginTransaction = session.beginTransaction();
		// 3、操作
		Customer c = new Customer();
		c.setCust_name("魅族");

		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("黄章");
		// 表达一对多，客户下有多个联系人
		c.getLinkMans().add(lm1);

		// 表达多对一，联系人属于哪个客户
		lm1.setCustomer(c);

		session.save(lm1);

		// 4、提交事务
		beginTransaction.commit();
		// 5、关闭资源
		session.close();

	}
}
