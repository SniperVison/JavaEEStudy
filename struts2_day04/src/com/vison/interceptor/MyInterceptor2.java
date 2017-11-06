package com.vison.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

//拦截器:第二种创建方式，继承AbstractInterceptor->struts2的体贴
//帮我们实现了init和destroy方法，我们如果不需要实现这两个方法，就可以只实现interceptor方法
public class MyInterceptor2 extends AbstractInterceptor
{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception
	{
		return null;
	}

}
