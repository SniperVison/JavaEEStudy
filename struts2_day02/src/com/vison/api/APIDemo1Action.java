package com.vison.api;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//�����action�л��ԭ��ServletAPI
public class APIDemo1Action extends ActionSupport
{
	// ��ʽһ�� ͨ��ActionContext��ȡ
	public String execute() throws Exception
	{
		// request��=>map(struts2�����Ƽ�ʹ��ԭ��request��,��ΪActionContext������������request�������������һ����)
		// ���Ƽ�
		Map<String, Object> requestScope = (Map<String, Object>) ActionContext.getContext().get("request");
		// �Ƽ���ʽ
		ActionContext.getContext().put("name", "requestVison");

		// session��=>map
		Map<String, Object> sessionScope = ActionContext.getContext().getSession();
		sessionScope.put("name", "sessionVison");
		// application��=>map
		Map<String, Object> applicationScope = ActionContext.getContext().getApplication();
		applicationScope.put("name", "applicationVison");
		return "success";
	}

}
