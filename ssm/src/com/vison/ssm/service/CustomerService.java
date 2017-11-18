package com.vison.ssm.service;

import com.vison.common.utils.Page;
import com.vison.ssm.pojo.Customer;
import com.vison.ssm.pojo.QueryVo;

public interface CustomerService
{
	// 通过四个条件，查询分页对象
	Page<Customer> selectPageByQueryVo(QueryVo vo);

	// 通过ID查询客户
	Customer selectCustomerById(Integer id);

}
