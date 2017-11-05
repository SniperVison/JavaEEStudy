package com.vison.ognl2struts2;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.util.ValueStack;
import com.vison.bean.User;

//ʵ������ģ������ֻ���ڡ���ֵǰ�������ܲ����Ķ���ѹ��ջ������
//prepare��������ִ��˳��Ҫ����params��������
//��ֵ��ѹջ������������Ҫ����struts2�е�Ĭ��������(��������һ��params�������ǽ��и�ֵ�����ġ�)
//����ʵ��ģ��������ǰ����Ҫ���ڡ���ֵǰ��������ѹ��ջ����������Ҫ��params������ǰ��prepare�������о�Ҫ����ѹջ����,����Ҫʵ��Preparble�ӿ�

//Ognl��Struts2�Ľ��
//ͨ��ģ��������ȡ������ʽһ(ʵ��preparble�ӿ�):�Ѷȴ���Ϊ�������Ҫ��struts2�Ŀ�ܺ���Ϥ
public class ParamToOgnlDemo1Action extends ActionSupport implements Preparable
{
	private User u = new User();

	// �����Ǹ�ֵ��ģ�������������ѹջ������û���õģ�����ͨ��ģ��������ȡ����ֵ
	@Override
	public String execute() throws Exception
	{/*
		// ѹ��ջ��
		// 1--��ȡֵջ(ValueStack)
		ValueStack vs = ActionContext.getContext().getValueStack();
		// ��uѹ��ջ��
		vs.push(u);*/
		System.out.println(u);
		return SUCCESS;
	}

	// ������Ǹ�ֵǰ�Ĳ��������������ѹջ��������ͨ��ģ��������ȡ����
	@Override
	public void prepare() throws Exception
	{
		// ѹ��ջ��
		// 1--��ȡֵջ(ValueStack)
		ValueStack vs = ActionContext.getContext().getValueStack();
		// ��uѹ��ջ��
		vs.push(u);

	}

}
