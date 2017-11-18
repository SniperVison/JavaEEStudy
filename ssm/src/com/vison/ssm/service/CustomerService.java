package com.vison.ssm.service;

import com.vison.common.utils.Page;
import com.vison.ssm.pojo.Customer;
import com.vison.ssm.pojo.QueryVo;

public interface CustomerService
{
	// ͨ���ĸ���������ѯ��ҳ����
	Page<Customer> selectPageByQueryVo(QueryVo vo);

	// ͨ��ID��ѯ�ͻ�
	Customer selectCustomerById(Integer id);

}
