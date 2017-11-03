package com.vison.result;

import com.opensymphony.xwork2.ActionSupport;

public class ResultDemo2Action extends ActionSupport
{
	public String execute() throws Exception
	{
		System.out.println("demo2");
		return "success";
	}

}
