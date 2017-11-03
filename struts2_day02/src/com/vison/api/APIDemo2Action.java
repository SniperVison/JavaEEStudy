package com.vison.api;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

//�����action�л��ԭ��ServletAPI
public class APIDemo2Action extends ActionSupport
{

	// ��ʽ2��ͨ��ServletActionContext��ȡ
	// ��struts2���沢���Ƽ�����Ϊstruts2ּ������ԭ����servlet�����ṩ���õı�����
	public String execute() throws Exception
	{
		// ԭ��request
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println(request);

		// ԭ��session
		HttpSession session = request.getSession();
		System.out.println(session);

		// ԭ��response
		HttpServletResponse response = ServletActionContext.getResponse();
		System.out.println(response);

		// ԭ��ServletContext
		ServletContext servletContext = ServletActionContext.getServletContext();
		System.out.println(servletContext);
		return "success";
	}

}
