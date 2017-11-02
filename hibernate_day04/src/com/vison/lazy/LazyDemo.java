package com.vison.lazy;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.vison.domain.Customer;
import com.vison.utils.HibernateUtil;

//——————————————学习类级别加载策略————————————————————————
//懒加载|延迟加载（为了提高效率，推荐使用延迟加载（懒加载））

//注意：使用懒加载时，要确保调用属性加载数据时，session还是打开的，否则会报懒加载初始化异常，不能初始化代理对象，没有session （org.hibernate.LazyInitializationException: could not initialize proxy - no Session）

public class LazyDemo
{
	// get方法:立即加载，执行方法时立即发送sql语句查询结果
	@Test
	public void fun1()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		Customer c = session.get(Customer.class, 2L);
		System.out.println(c);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	@Test
	// load方法（默认策略是true）：是在执行时，不发送任何sql语句，返回一个对象，使用该对象时，才执行查询
	// 这种现象就是延迟加载，仅仅获得但没有使用，在使用时才进行查询
	// 是否对类进行延迟加载，可以通过在相对应的xxx.hbm.xml文件中的class元素上配置lazy属性来控制
	// lazy:true
	// 加载时，不查询，会在使用属性时，根据关联的session查询数据库，加载数据,实体类使用的是代理对象（详情可以设置断点Debug在Variables查看，带$$的就是代理对象）
	// lazy:false 加载时立即查询 ，实体类使用的是直接对象，load方法与get方法没有区别
	public void fun2()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		Customer c = session.load(Customer.class, 2L);
		// ---------------------------------------------
		System.out.println(c);
		beginTransaction.commit();
		session.close();
		// System.out.println(c);//此步是要使用属性，必须在session关闭前使用，不然会报异常

	}
}
