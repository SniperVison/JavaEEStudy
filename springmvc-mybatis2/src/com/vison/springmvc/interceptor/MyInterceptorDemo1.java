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
		System.out.println("����ǰ1");
		// return false;������
		// �ж��û��Ƿ��¼�����û�е�¼�����ض��򵽵�¼ҳ�棬�����У������¼�ˣ��ͷ�����
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
		return true;// ����
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception
	{
		System.out.println("������1");

	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception
	{
		System.out.println("ҳ����Ⱦ��1");

	}

}
