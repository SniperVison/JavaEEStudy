package com.vison.param;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vison.domain.User;

//struts2��λ�ò���
//��ʽ3:ģ��������ò���(ȱ��ֻ�ܷ���һ������)
public class ParamDemo3Action extends ActionSupport implements ModelDriven<User>
{
	// ׼��user��Ա����,�����ֶ�����һ��User����
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
