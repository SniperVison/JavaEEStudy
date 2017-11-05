package com.vison.valuestack;

import com.opensymphony.xwork2.ActionSupport;

public class ValueStackDemo1Action extends ActionSupport
{

	@Override
	public String execute() throws Exception
	{
		System.out.println("ValueStackDemo1Action");
		return SUCCESS;
	}

}
