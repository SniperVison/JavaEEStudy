package com.vison.service.impl;

import com.vison.dao.CustomerDao;
import com.vison.dao.impl.CustomerDaoImpl;
import com.vison.domain.Customer;
import com.vison.service.CustomerService;

public class CustomerServiceImpl implements CustomerService
{
	public CustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public void save(Customer c)
	{
		customerDao.save(c);
	}

}
