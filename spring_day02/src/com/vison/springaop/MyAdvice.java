package com.vison.springaop;

import org.aspectj.lang.ProceedingJoinPoint;

//֪ͨ��
public class MyAdvice
{
	// ǰ��֪ͨ->Ŀ�귽������֮ǰ����
	// ����֪ͨ(��������쳣�������)->��Ŀ�귽������֮�����
	// ����֪ͨ->��Ŀ�귽��֮ǰ��֮�󶼵���
	// �쳣����֪ͨ->��������쳣���ͻ����
	// ����֪ͨ(�����Ƿ�����쳣�������)->��Ŀ�귽������֮�����

	// ǰ��֪ͨ
	public void before()
	{
		System.out.println("ǰ��֪ͨ��~~");
	}

	// ����֪ͨ
	public void afterReturning()
	{
		System.out.println("����֪ͨ(��������쳣�������)����~~~");
	}

	// ����֪ͨ
	public Object around(ProceedingJoinPoint pjp) throws Throwable
	{
		System.out.println("���ǻ���֪֮ͨǰ�Ĳ���");
		// ����Ŀ�귽��
		Object proceed = pjp.proceed();
		System.out.println("���ǻ���֪֮ͨ��Ĳ���");
		return proceed;
	}

	// �쳣����֪ͨ
	public void afterException()
	{
		System.out.println("�����쳣~~@��@��");
	}

	// ����֪ͨ(�����Ƿ�����쳣�������)
	public void after()
	{
		System.out.println("����֪ͨ(�����Ƿ�����쳣�������)");
	}
}
