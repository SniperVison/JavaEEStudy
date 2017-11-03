package com.vison.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import com.vison.dao.CustomerDao;
import com.vison.domain.Customer;
import com.vison.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao
{

	public void save(Customer c)
	{
		// 1 ���session
		Session session = HibernateUtils.getCurrentSession();
		// 3 ִ�б���
		session.save(c);
	}

	public List<Customer> getAll()
	{
		// 1 ���session
		Session session = HibernateUtils.getCurrentSession();
		// 2 ����Criteria����
		Criteria c = session.createCriteria(Customer.class);
		return c.list();
	}

	public Customer getById(Long cust_id)
	{
		// 1 ���session
		Session session = HibernateUtils.getCurrentSession();
		return session.get(Customer.class, cust_id);
	}

	public List<Customer> getAll(DetachedCriteria dc)
	{
		// 1 ���session
		Session session = HibernateUtils.getCurrentSession();
		// 2 �����߶��������session
		Criteria c = dc.getExecutableCriteria(session);
		// 3 ִ�в�ѯ������
		return c.list();
	}

}
