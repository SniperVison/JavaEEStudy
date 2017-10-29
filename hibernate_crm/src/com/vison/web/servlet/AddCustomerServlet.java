package com.vison.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.vison.domain.Customer;
//servlet注解，可以用来替代xml配置信息的
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
		// 1、获得参数并封装到Customer对象中
		Customer c = new Customer();
		try
		{
			BeanUtils.populate(c, request.getParameterMap());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		// 2、调用service保存客户
		customerService.save(c);
		// 3、重定向到客户列表
		response.sendRedirect(request.getContextPath() + "/listCustomerServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);

	}

}
