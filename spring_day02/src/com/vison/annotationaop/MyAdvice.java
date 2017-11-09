package com.vison.annotationaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//通知类

//表示该类是一个通知类
@Aspect
public class MyAdvice
{
	/*第一种注解方式：直接在对应的注解里面加入表达式“
	execution(* com.vison.service.UserServiceImpl.*())”，不过这种比较繁琐，不利于修改
	
	*/

	// 前置通知
	// 指定该方法是前置通知，并指定切入点
	@Before("execution(* com.vison.service.UserServiceImpl.*()) ")

	public void before()
	{
		System.out.println("前置通知！~~");
	}

	// 后置通知
	// 指定该方法是后置通知，并指定切入点
	@AfterReturning("execution(* com.vison.service.UserServiceImpl.*()) ")
	public void afterReturning()
	{
		System.out.println("后置通知(如果出现异常不会调用)！！~~~");
	}

	// 环绕通知
	// 指定该方法是环绕通知，并指定切入点
	@Around("execution(* com.vison.service.UserServiceImpl.*())")
	public Object around(ProceedingJoinPoint pjp) throws Throwable
	{
		System.out.println("这是环绕通知之前的部分");
		// 调用目标方法
		Object proceed = pjp.proceed();
		System.out.println("这是环绕通知之后的部分");
		return proceed;
	}

	// 异常拦截通知
	// 指定该方法是异常拦截通知，并指定切入点
	@AfterThrowing("execution(* com.vison.service.UserServiceImpl.*()) ")
	public void afterException()
	{
		System.out.println("出现异常~~@￥@￥");
	}

	// 后置通知(无论是否出现异常都会调用)
	// 指定该方法是后置通知，并指定切入点
	@After("execution(* com.vison.service.UserServiceImpl.*()) ")
	public void after()
	{
		System.out.println("后置通知(无论是否出现异常都会调用)");
	}
}
