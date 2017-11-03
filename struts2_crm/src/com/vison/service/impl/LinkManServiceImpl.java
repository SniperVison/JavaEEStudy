package com.vison.service.impl;

import com.vison.dao.CustomerDao;
import com.vison.dao.LinkManDao;
import com.vison.dao.impl.CustomerDaoImpl;
import com.vison.dao.impl.LinkManDaoImpl;
import com.vison.domain.Customer;
import com.vison.domain.LinkMan;
import com.vison.service.LinkManService;
import com.vison.utils.HibernateUtils;

public class LinkManServiceImpl implements LinkManService
{

	private CustomerDao cd = new CustomerDaoImpl();
	private LinkManDao lmd = new LinkManDaoImpl();

	public void save(LinkMan lm)
	{
		// ������
		HibernateUtils.getCurrentSession().beginTransaction();

		try
		{
			// 1 ���ݿͻ�id��ÿͻ�����
			Long cust_id = lm.getCust_id();
			Customer c = cd.getById(cust_id);
			// 2 ���ͻ�����LinkMan�б���ϵ
			lm.setCustomer(c);
			// 3 ����LinkMan
			lmd.save(lm);
		} catch (Exception e)
		{
			e.printStackTrace();
			// �ع�����
			HibernateUtils.getCurrentSession().getTransaction().rollback();
		}
		// �ύ����
		HibernateUtils.getCurrentSession().getTransaction().commit();

	}

}
