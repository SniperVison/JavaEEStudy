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
		// 打开事务
		HibernateUtils.getCurrentSession().beginTransaction();

		try
		{
			// 1 根据客户id获得客户对象
			Long cust_id = lm.getCust_id();
			Customer c = cd.getById(cust_id);
			// 2 将客户放入LinkMan中表达关系
			lm.setCustomer(c);
			// 3 保存LinkMan
			lmd.save(lm);
		} catch (Exception e)
		{
			e.printStackTrace();
			// 回滚事务
			HibernateUtils.getCurrentSession().getTransaction().rollback();
		}
		// 提交事务
		HibernateUtils.getCurrentSession().getTransaction().commit();

	}

}
