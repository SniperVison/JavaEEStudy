package com.vison.api;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

//如何在action中获得原生ServletAPI
public class APIDemo2Action extends ActionSupport
{

	// 方式2：通过ServletActionContext获取
	// 在struts2里面并不推荐，因为struts2旨在脱离原生的servlet，以提供更好的便利性
	public String execute() throws Exception
	{
		// 原生request
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println(request);

		// 原生session
		HttpSession session = request.getSession();
		System.out.println(session);

		// 原生response
		HttpServletResponse response = ServletActionContext.getResponse();
		System.out.println(response);

		// 原生ServletContext
		ServletContext servletContext = ServletActionContext.getServletContext();
		System.out.println(servletContext);
		return "success";
	}

}
