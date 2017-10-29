package com.vison.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vison.dao.CustomerDao;
import com.vison.domain.Customer;
import com.vison.utils.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao
{
	Transaction beginTransaction = null;
	Session session = null;

	@Override
	public void save(Customer c)
	{
		try
		{
			// 1获得session
			session = HibernateUtil.openSession();
			// 2、打开事务
			beginTransaction = session.beginTransaction();
			// 3、执行保存
			session.save(c);
			// 4、提交事务
			beginTransaction.commit();
		} catch (Exception e)
		{
			beginTransaction.rollback();// 事务回滚
		} finally
		{
			// 5、关闭资源
			session.close();
		}

	}

}
