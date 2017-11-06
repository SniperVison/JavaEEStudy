package com.vison.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

//拦截器:第三种创建方式，继承MethodFilterInterceptor  方法过滤拦截器
//功能:定制拦截器拦截的方法
//定制哪些方法不需要拦截      
//定制哪些方法需要拦截     
public class MyInterceptor3 extends MethodFilterInterceptor
{
	// 第一种操作:放行+前后处理
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception
	{
		// 前处理
		System.out.println("MyInterceptor3前处理");
		// 放行
		invocation.invoke();
		// 后处理
		System.out.println("MyInterceptor3后处理");

		return null;
	}

	// 第一种方式的运行结果(拦截InterceptorDemo1Action):
	/*MyInterceptor3前处理
	InterceptorDemo1Action~~~~
	MyInterceptor3后处理*/
	// 跳转到指定页面

	// 第二种操作:
	// 不放行，直接跳转到一个结果页面,不执行后续的拦截器以及Action，直接交给Result处理结果(即struts.xml文件中的内容)，进行页面跳转
	/*
	
	
		protected String doIntercept2(ActionInvocation invocation) throws Exception
		{
			// 前处理
			System.out.println("MyInterceptor3前处理");
			// 放行
			// invocation.invoke(); 不进行放行操作，没有前后处理
			// 后处理
			System.out.println("MyInterceptor3后处理");
	
			return "success";
		}*/

	// 第二种方式的运行结果（拦截InterceptorDemo1Action）：
	/*	MyInterceptor3前处理
		MyInterceptor3后处理*/
	// 跳转到指定页面

}
