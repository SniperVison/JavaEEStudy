package com.vison.result;

import com.opensymphony.xwork2.ActionSupport;

public class ResultDemo4Action extends ActionSupport
{
	public String execute() throws Exception
	{
		System.out.println("demo4");
		return "success";
	}

}
