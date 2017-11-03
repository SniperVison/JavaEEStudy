package com.vison.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

//如何在action中获得原生ServletAPI
public class APIDemo3Action extends ActionSupport
		implements ServletRequestAware, ServletResponseAware, SessionAware, ApplicationAware
{

	// 方式3：通过实现(ervletRequestAware, ServletResponseAware, SessionAware,
	// ApplicationAware等等)接口方式
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map<String, Object> session;
	private Map<String, Object> application;

	public String execute() throws Exception
	{
		System.out.println("原生request:" + request);
		System.out.println("原生response:" + response);
		System.out.println("原生session:" + session);
		System.out.println("原生application:" + application);
		return "success";
	}

	// 原生request
	@Override
	public void setServletRequest(HttpServletRequest request)
	{
		this.request = request;
	}

	// 原生application
	@Override
	public void setApplication(Map<String, Object> application)
	{
		this.application = application;
	}

	// 原生session
	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}

	// 原生response
	@Override
	public void setServletResponse(HttpServletResponse response)
	{
		this.response = response;
	}

}
