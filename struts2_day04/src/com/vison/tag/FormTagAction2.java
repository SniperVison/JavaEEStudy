package com.vison.tag;

import com.opensymphony.xwork2.ActionSupport;

//在jsp中书写struts2表单标签，然后Action类接受属性
public class FormTagAction2 extends ActionSupport
{

	private String name;

	@Override
	public String execute() throws Exception
	{
		System.out.println(name);

		/*在action中添加错误，对应tag2_form.jsp中的最底下的非表单标签*/
		this.addActionError("八级大狂风倒着读");

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
