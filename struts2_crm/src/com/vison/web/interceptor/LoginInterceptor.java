package com.vison.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor
{
	// 指定不拦截登录方法，其他方法都拦截
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception
	{
		// 1--获得session
		Map<String, Object> session = ActionContext.getContext().getSession();
		// 2--获得登录标识
		Object object = session.get("user");
		// 3--判断登录标识是否存在

		// 不存在->没登录->重定向到登录页面
		if (object == null)
			return "toLogin";
		// 存在->已经登录->放行
		else
			return invocation.invoke();
	}

}
