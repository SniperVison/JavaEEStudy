package com.vison.ssm.mapper;

import java.util.List;

import com.vison.ssm.pojo.Customer;
import com.vison.ssm.pojo.QueryVo;

public interface CustomerDao
{
	// ������
	Integer customerCountByQueryVo(QueryVo vo);

	// �����
	List<Customer> selectCustomerListByQueryVo(QueryVo vo);

	// ͨ��ID��ѯ�ͻ�
	Customer selectCustomerById(Integer id);

}
