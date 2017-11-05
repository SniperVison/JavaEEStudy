package com.vison.ognl2struts2;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.vison.bean.User;

//ʵ������ģ������ֻ���ڡ���ֵǰ�������ܲ����Ķ���ѹ��ջ������

//Ognl��Struts2�Ľ��
//ͨ��ģ��������ȡ������ʽ��(ʵ��ModelDriven�ӿ�):��Է�ʽһ���򵥺ܶ࣬����ԭ����һ����
public class ParamToOgnlDemo1Action2 extends ActionSupport implements ModelDriven<User>
{
	private User u = new User();

	@Override
	public String execute() throws Exception
	{
		// ѹ��ջ��
		// 1--��ȡֵջ(ValueStack)
		ValueStack vs = ActionContext.getContext().getValueStack();
		// ��uѹ��ջ��
		vs.push(u);
		System.out.println(u);
		return SUCCESS;
	}

	@Override
	public User getModel()
	{
		return u;
	}

}
