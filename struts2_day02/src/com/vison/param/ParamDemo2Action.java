package com.vison.param;

import com.opensymphony.xwork2.ActionSupport;
import com.vison.domain.User;

//struts2��λ�ò���
//��ʽ2:����������ò���
public class ParamDemo2Action extends ActionSupport
{
	private User user;

	public String execute() throws Exception
	{
		System.out.println(user);
		return SUCCESS;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

}
