package com.vison.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor
{
	// ָ�������ص�¼��������������������
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception
	{
		// 1--���session
		Map<String, Object> session = ActionContext.getContext().getSession();
		// 2--��õ�¼��ʶ
		Object object = session.get("user");
		// 3--�жϵ�¼��ʶ�Ƿ����

		// ������->û��¼->�ض��򵽵�¼ҳ��
		if (object == null)
			return "toLogin";
		// ����->�Ѿ���¼->����
		else
			return invocation.invoke();
	}

}
