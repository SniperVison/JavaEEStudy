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
		// 1--����Serviceִ�е�¼����
		User u = us.login(user);
		// 2--�����ص�User�������session����Ϊ��¼��ʶ
		ActionContext.getContext().getSession().put("user", u);
		// 3--�ض�����Ŀ����ҳ
		return "toHome";
	}

	// ʹ��ģ��������User�������ջ��
	@Override
	public User getModel()
	{
		return user;
	}

}
