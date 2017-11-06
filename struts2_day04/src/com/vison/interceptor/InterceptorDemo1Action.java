package com.vison.interceptor;

import com.opensymphony.xwork2.ActionSupport;

public class InterceptorDemo1Action extends ActionSupport
{

	@Override
	public String execute() throws Exception
	{
		System.out.println("InterceptorDemo1Action~~~~execute");
		return SUCCESS;
	}

	public String add() throws Exception
	{
		System.out.println("InterceptorDemo1Action~~~~add");
		return SUCCESS;
	}

	public String delete() throws Exception
	{
		System.out.println("InterceptorDemo1Action~~~~delete");
		return SUCCESS;
	}

	public String update() throws Exception
	{
		System.out.println("InterceptorDemo1Action~~~~update");
		return SUCCESS;
	}

	public String find() throws Exception
	{
		System.out.println("InterceptorDemo1Action~~~~find");
		return SUCCESS;
	}

}
