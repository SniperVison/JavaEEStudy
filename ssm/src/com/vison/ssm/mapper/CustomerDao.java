package com.vison.ssm.mapper;

import java.util.List;

import com.vison.ssm.pojo.Customer;
import com.vison.ssm.pojo.QueryVo;

public interface CustomerDao
{
	// 总条数
	Integer customerCountByQueryVo(QueryVo vo);

	// 结果集
	List<Customer> selectCustomerListByQueryVo(QueryVo vo);

	// 通过ID查询客户
	Customer selectCustomerById(Integer id);

}
