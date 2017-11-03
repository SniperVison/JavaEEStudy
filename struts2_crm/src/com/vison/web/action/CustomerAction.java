package com.vison.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;
import com.vison.domain.Customer;
import com.vison.service.CustomerService;
import com.vison.service.impl.CustomerServiceImpl;

@SuppressWarnings("serial")
public class CustomerAction extends ActionSupport
{

	private CustomerService cs = new CustomerServiceImpl();

	public String list() throws Exception
	{
		// 1--���ܲ���
		String cust_name = ServletActionContext.getRequest().getParameter("cust_name");
		// 2--�������߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		// 3--�жϲ���ƴװ����
		if (StringUtils.isNotBlank(cust_name))
		{
			dc.add(Restrictions.ilike("cust_name", "%" + cust_name + "%"));
		}
		// 4--����Service�����߶��󴫵�
		List<Customer> list = cs.getAll(dc);
		// 5--�����ص�list����request��ת����list.jsp��ʾ
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}

}