package com.vison.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

//������:�����ִ�����ʽ���̳�MethodFilterInterceptor  ��������������
//����:�������������صķ���
//������Щ��������Ҫ����      
//������Щ������Ҫ����     
public class MyInterceptor3 extends MethodFilterInterceptor
{
	// ��һ�ֲ���:����+ǰ����
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception
	{
		// ǰ����
		System.out.println("MyInterceptor3ǰ����");
		// ����
		invocation.invoke();
		// ����
		System.out.println("MyInterceptor3����");

		return null;
	}

	// ��һ�ַ�ʽ�����н��(����InterceptorDemo1Action):
	/*MyInterceptor3ǰ����
	InterceptorDemo1Action~~~~
	MyInterceptor3����*/
	// ��ת��ָ��ҳ��

	// �ڶ��ֲ���:
	// �����У�ֱ����ת��һ�����ҳ��,��ִ�к������������Լ�Action��ֱ�ӽ���Result������(��struts.xml�ļ��е�����)������ҳ����ת
	/*
	
	
		protected String doIntercept2(ActionInvocation invocation) throws Exception
		{
			// ǰ����
			System.out.println("MyInterceptor3ǰ����");
			// ����
			// invocation.invoke(); �����з��в�����û��ǰ����
			// ����
			System.out.println("MyInterceptor3����");
	
			return "success";
		}*/

	// �ڶ��ַ�ʽ�����н��������InterceptorDemo1Action����
	/*	MyInterceptor3ǰ����
		MyInterceptor3����*/
	// ��ת��ָ��ҳ��

}
