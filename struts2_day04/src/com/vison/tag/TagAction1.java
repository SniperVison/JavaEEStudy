package com.vison.tag;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TagAction1 extends ActionSupport
{

	@Override
	public String execute() throws Exception
	{
		List<String> list = new ArrayList<>();
		list.add("jingjing");
		list.add("wenwen");
		list.add("yingying");
		list.add("lili");
		list.add("shenshen");
		ActionContext.getContext().put("list", list);
		return SUCCESS;
	}

}
