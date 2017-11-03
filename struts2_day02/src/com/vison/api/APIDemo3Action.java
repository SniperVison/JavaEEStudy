package com.vison.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

//�����action�л��ԭ��ServletAPI
public class APIDemo3Action extends ActionSupport
		implements ServletRequestAware, ServletResponseAware, SessionAware, ApplicationAware
{

	// ��ʽ3��ͨ��ʵ��(ervletRequestAware, ServletResponseAware, SessionAware,
	// ApplicationAware�ȵ�)�ӿڷ�ʽ
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map<String, Object> session;
	private Map<String, Object> application;

	public String execute() throws Exception
	{
		System.out.println("ԭ��request:" + request);
		System.out.println("ԭ��response:" + response);
		System.out.println("ԭ��session:" + session);
		System.out.println("ԭ��application:" + application);
		return "success";
	}

	// ԭ��request
	@Override
	public void setServletRequest(HttpServletRequest request)
	{
		this.request = request;
	}

	// ԭ��application
	@Override
	public void setApplication(Map<String, Object> application)
	{
		this.application = application;
	}

	// ԭ��session
	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}

	// ԭ��response
	@Override
	public void setServletResponse(HttpServletResponse response)
	{
		this.response = response;
	}

}
