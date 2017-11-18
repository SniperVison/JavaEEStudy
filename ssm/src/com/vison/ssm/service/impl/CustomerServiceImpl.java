package com.vison.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vison.common.utils.Page;
import com.vison.ssm.mapper.CustomerDao;
import com.vison.ssm.pojo.Customer;
import com.vison.ssm.pojo.QueryVo;
import com.vison.ssm.service.CustomerService;

/**
 * �ͻ�����
 * 
 * @author Vison
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService
{

	@Autowired
	private CustomerDao customerDao;

	// ͨ���ĸ���������ѯ��ҳ����
	public Page<Customer> selectPageByQueryVo(QueryVo vo)
	{
		Page<Customer> page = new Page<Customer>();
		// ÿҳ��
		page.setSize(5);
		vo.setSize(5);
		if (vo != null)
		{
			// �жϵ�ǰҳ
			if (vo.getPage() != null)
			{
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage() - 1) * vo.getSize());
			}
			if (vo.getCustName() != null && !"".equals(vo.getCustName().trim()))
			{
				vo.setCustName(vo.getCustName().trim());
			}
			if (vo.getCustSource() != null && !"".equals(vo.getCustSource().trim()))
			{
				vo.setCustSource(vo.getCustSource().trim());
			}
			if (vo.getCustIndustry() != null && !"".equals(vo.getCustIndustry().trim()))
			{
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}
			if (vo.getCustLevel() != null && !"".equals(vo.getCustLevel().trim()))
			{
				vo.setCustLevel(vo.getCustLevel().trim());
			}
			// ������
			page.setTotal(customerDao.customerCountByQueryVo(vo));
			// �����
			page.setRows(customerDao.selectCustomerListByQueryVo(vo));
		}
		return page;
	}

	@Override
	public Customer selectCustomerById(Integer id)
	{
		return customerDao.selectCustomerById(id);

	}
}
