package com.vison.annotationaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//֪ͨ��

//��ʾ������һ��֪ͨ��
@Aspect
public class MyAdvice
{
	/*��һ��ע�ⷽʽ��ֱ���ڶ�Ӧ��ע�����������ʽ��
	execution(* com.vison.service.UserServiceImpl.*())�����������ֱȽϷ������������޸�
	
	*/

	// ǰ��֪ͨ
	// ָ���÷�����ǰ��֪ͨ����ָ�������
	@Before("execution(* com.vison.service.UserServiceImpl.*()) ")

	public void before()
	{
		System.out.println("ǰ��֪ͨ��~~");
	}

	// ����֪ͨ
	// ָ���÷����Ǻ���֪ͨ����ָ�������
	@AfterReturning("execution(* com.vison.service.UserServiceImpl.*()) ")
	public void afterReturning()
	{
		System.out.println("����֪ͨ(��������쳣�������)����~~~");
	}

	// ����֪ͨ
	// ָ���÷����ǻ���֪ͨ����ָ�������
	@Around("execution(* com.vison.service.UserServiceImpl.*())")
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
	@AfterThrowing("execution(* com.vison.service.UserServiceImpl.*()) ")
	public void afterException()
	{
		System.out.println("�����쳣~~@��@��");
	}

	// ����֪ͨ(�����Ƿ�����쳣�������)
	// ָ���÷����Ǻ���֪ͨ����ָ�������
	@After("execution(* com.vison.service.UserServiceImpl.*()) ")
	public void after()
	{
		System.out.println("����֪ͨ(�����Ƿ�����쳣�������)");
	}
}
