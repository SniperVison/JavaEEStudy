package com.vison.result;

import com.opensymphony.xwork2.ActionSupport;

public class ResultDemo1Action extends ActionSupport
{
	public String execute() throws Exception
	{
		System.out.println("demo1");
		return "success";
	}

}
