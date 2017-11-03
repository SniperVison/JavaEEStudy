package com.vison.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.vison.domain.Customer;

public interface CustomerService
{
	// ����ͻ�
	void save(Customer c);

	// ������пͻ�
	List<Customer> getAll();

	// ����������ѯ���пͻ�
	List<Customer> getAll(DetachedCriteria dc);

}
