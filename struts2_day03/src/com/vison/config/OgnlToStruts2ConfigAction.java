package com.vison.config;

import com.opensymphony.xwork2.ActionSupport;

public class OgnlToStruts2ConfigAction extends ActionSupport
{
	private String name;

	@Override
	public String execute() throws Exception
	{
		name = "jingjing";// �����������ʱ�����ݿ��ѯ������
		System.out.println("OgnlToStruts2ConfigAction~~~~~~~~");
		return SUCCESS;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
