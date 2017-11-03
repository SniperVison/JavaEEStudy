package com.vison.api;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//如何在action中获得原生ServletAPI
public class APIDemo1Action extends ActionSupport
{
	// 方式一： 通过ActionContext获取
	public String execute() throws Exception
	{
		// request域=>map(struts2并不推荐使用原生request域,因为ActionContext的生存周期与request域的生存周期是一样的)
		// 不推荐
		Map<String, Object> requestScope = (Map<String, Object>) ActionContext.getContext().get("request");
		// 推荐方式
		ActionContext.getContext().put("name", "requestVison");

		// session域=>map
		Map<String, Object> sessionScope = ActionContext.getContext().getSession();
		sessionScope.put("name", "sessionVison");
		// application域=>map
		Map<String, Object> applicationScope = ActionContext.getContext().getApplication();
		applicationScope.put("name", "applicationVison");
		return "success";
	}

}
