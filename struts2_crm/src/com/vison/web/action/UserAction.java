package com.vison.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vison.domain.User;
import com.vison.service.UserService;
import com.vison.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User>
{

	private User user = new User();
	private UserService us = new UserServiceImpl();

	public String login() throws Exception
	{
		// 1--调用Service执行登录惭怍
		User u = us.login(user);
		// 2--将返回的User对象放入session域作为登录标识
		ActionContext.getContext().getSession().put("user", u);
		// 3--重定向到项目的首页
		return "toHome";
	}

	// 使用模型驱动把User对象放入栈顶
	@Override
	public User getModel()
	{
		return user;
	}

}
