package com.vison.annotationaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//通知类

//表示该类是一个通知类
@Aspect
public class MyAdvice2
{
	/*第二种注解方式：书写一个方法，然后在这个方法上面注解切入点+表达式，下面的方法使用它的注解
	*/
	// 前置通知
	// 指定该方法是前置通知，并指定切入点
	@Pointcut("execution(* com.vison.service.UserServiceImpl.*()) ")
	public void annotationaop()
	{
	}

	@Before("MyAdvice2.annotationaop()")
	public void before()
	{
		System.out.println("前置通知！~~");
	}

	// 后置通知
	// 指定该方法是后置通知，并指定切入点
	@AfterReturning("MyAdvice2.annotationaop() ")
	public void afterReturning()
	{
		System.out.println("后置通知(如果出现异常不会调用)！！~~~");
	}

	// 环绕通知
	// 指定该方法是环绕通知，并指定切入点
	@Around("MyAdvice2.annotationaop()")
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
	@AfterThrowing("MyAdvice2.annotationaop() ")
	public void afterException()
	{
		System.out.println("出现异常~~@￥@￥");
	}

	// 后置通知(无论是否出现异常都会调用)
	// 指定该方法是后置通知，并指定切入点
	@After("MyAdvice2.annotationaop() ")
	public void after()
	{
		System.out.println("后置通知(无论是否出现异常都会调用)");
	}
}
