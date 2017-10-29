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
			// 1���session
			session = HibernateUtil.openSession();
			// 2��������
			beginTransaction = session.beginTransaction();
			// 3��ִ�б���
			session.save(c);
			// 4���ύ����
			beginTransaction.commit();
		} catch (Exception e)
		{
			beginTransaction.rollback();// ����ع�
		} finally
		{
			// 5���ر���Դ
			session.close();
		}

	}

}
