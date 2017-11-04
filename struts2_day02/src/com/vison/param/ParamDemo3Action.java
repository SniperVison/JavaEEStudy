package com.vison.param;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vison.domain.User;

//struts2如何获得参数
//方式3:模型驱动获得参数(缺点只能返回一个对象)
public class ParamDemo3Action extends ActionSupport implements ModelDriven<User>
{
	// 准备user成员变量,并且手动创建一个User对象
	private User user = new User();

	public String execute() throws Exception
	{
		System.out.println(user);
		return SUCCESS;
	}

	@Override
	public User getModel()
	{
		return user;
	}

}
