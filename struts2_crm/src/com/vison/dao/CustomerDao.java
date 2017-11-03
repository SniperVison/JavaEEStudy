package com.vison.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.vison.domain.Customer;

public interface CustomerDao
{
	// ����ͻ�
	void save(Customer c);

	// ��ѯ���пͻ�
	List<Customer> getAll();

	// ����id��ÿͻ�
	Customer getById(Long cust_id);

	// ����������ѯ���пͻ�
	List<Customer> getAll(DetachedCriteria dc);

}
