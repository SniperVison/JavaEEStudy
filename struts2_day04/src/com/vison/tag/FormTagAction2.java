package com.vison.tag;

import com.opensymphony.xwork2.ActionSupport;

//��jsp����дstruts2����ǩ��Ȼ��Action���������
public class FormTagAction2 extends ActionSupport
{

	private String name;

	@Override
	public String execute() throws Exception
	{
		System.out.println(name);

		/*��action����Ӵ��󣬶�Ӧtag2_form.jsp�е�����µķǱ���ǩ*/
		this.addActionError("�˼����絹�Ŷ�");

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
