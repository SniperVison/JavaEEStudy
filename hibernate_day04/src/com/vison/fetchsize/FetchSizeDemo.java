package com.vison.fetchsize;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import com.vison.domain.Customer;
import com.vison.utils.HibernateUtil;

//批量抓取
//抓取数量

//在Customer.hbm.xml文件中加入batch-size属性
public class FetchSizeDemo
{
	@SuppressWarnings(
	{ "unchecked", "rawtypes" })
	@Test
	public void fun()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ----------------------------------------------------------------------
		String hql = "from Customer";
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		for (Customer c : list)
		{
			System.out.println(c.getLinkMans());
		}
		// ----------------------------------------------------------------------

		beginTransaction.commit();
		session.close();
	}

}
