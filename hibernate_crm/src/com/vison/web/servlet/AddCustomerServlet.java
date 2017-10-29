package com.vison.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.vison.domain.Customer;
//servletע�⣬�����������xml������Ϣ��
import com.vison.service.CustomerService;
import com.vison.service.impl.CustomerServiceImpl;

@WebServlet(name = "AddCustomerServlet", urlPatterns = "/addCustomerServlet")
public class AddCustomerServlet extends HttpServlet
{

	private CustomerService customerService = new CustomerServiceImpl();;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/*	response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");*/
		// 1����ò�������װ��Customer������
		Customer c = new Customer();
		try
		{
			BeanUtils.populate(c, request.getParameterMap());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		// 2������service����ͻ�
		customerService.save(c);
		// 3���ض��򵽿ͻ��б�
		response.sendRedirect(request.getContextPath() + "/listCustomerServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);

	}

}
