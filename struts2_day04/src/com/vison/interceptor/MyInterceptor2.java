package com.vison.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

//������:�ڶ��ִ�����ʽ���̳�AbstractInterceptor->struts2������
//������ʵ����init��destroy�����������������Ҫʵ���������������Ϳ���ֻʵ��interceptor����
public class MyInterceptor2 extends AbstractInterceptor
{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception
	{
		return null;
	}

}
