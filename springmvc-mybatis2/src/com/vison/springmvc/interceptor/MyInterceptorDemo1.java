package com.vison.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptorDemo1 implements HandlerInterceptor
{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception
	{
		System.out.println("方法前1");
		// return false;不放行
		// 判断用户是否登录，如果没有登录，就重定向到登录页面，不放行，如果登录了，就放行了
		String requestURI = request.getRequestURI();
		if (!requestURI.contains("/login"))
		{
			String username = (String) request.getSession().getAttribute("USER_SESSION");
			if (username == null)
			{
				response.sendRedirect(request.getContextPath() + "/login.action");
				return false;
			}
		}
		return true;// 放行
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception
	{
		System.out.println("方法后1");

	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception
	{
		System.out.println("页面渲染后1");

	}

}
