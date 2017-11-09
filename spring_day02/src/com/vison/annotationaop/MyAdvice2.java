package com.vison.annotationaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//֪ͨ��

//��ʾ������һ��֪ͨ��
@Aspect
public class MyAdvice2
{
	/*�ڶ���ע�ⷽʽ����дһ��������Ȼ���������������ע�������+���ʽ������ķ���ʹ������ע��
	*/
	// ǰ��֪ͨ
	// ָ���÷�����ǰ��֪ͨ����ָ�������
	@Pointcut("execution(* com.vison.service.UserServiceImpl.*()) ")
	public void annotationaop()
	{
	}

	@Before("MyAdvice2.annotationaop()")
	public void before()
	{
		System.out.println("ǰ��֪ͨ��~~");
	}

	// ����֪ͨ
	// ָ���÷����Ǻ���֪ͨ����ָ�������
	@AfterReturning("MyAdvice2.annotationaop() ")
	public void afterReturning()
	{
		System.out.println("����֪ͨ(��������쳣�������)����~~~");
	}

	// ����֪ͨ
	// ָ���÷����ǻ���֪ͨ����ָ�������
	@Around("MyAdvice2.annotationaop()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable
	{
		System.out.println("���ǻ���֪֮ͨǰ�Ĳ���");
		// ����Ŀ�귽��
		Object proceed = pjp.proceed();
		System.out.println("���ǻ���֪֮ͨ��Ĳ���");
		return proceed;
	}

	// �쳣����֪ͨ
	// ָ���÷������쳣����֪ͨ����ָ�������
	@AfterThrowing("MyAdvice2.annotationaop() ")
	public void afterException()
	{
		System.out.println("�����쳣~~@��@��");
	}

	// ����֪ͨ(�����Ƿ�����쳣�������)
	// ָ���÷����Ǻ���֪ͨ����ָ�������
	@After("MyAdvice2.annotationaop() ")
	public void after()
	{
		System.out.println("����֪ͨ(�����Ƿ�����쳣�������)");
	}
}
