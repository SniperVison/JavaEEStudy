package com.vison.param;

import com.opensymphony.xwork2.ActionSupport;
import com.vison.domain.User;

//struts2如何获得参数
//方式2:对象驱动获得参数
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
