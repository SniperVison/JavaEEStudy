package com.vison.result;

import com.opensymphony.xwork2.ActionSupport;

public class ResultDemo3Action extends ActionSupport
{
	public String execute() throws Exception
	{
		System.out.println("demo3");
		return "success";
	}

}
