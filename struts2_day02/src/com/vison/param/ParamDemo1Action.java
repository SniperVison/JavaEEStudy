package com.vison.param;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

//struts2��λ�ò���
/*ÿ������Action(�̰߳�ȫ��)ʱ���ᴴ���µ�Actionʵ������[���Բ��������ǳ�Ա����](��������servlet[���̲߳���ȫ���������]����Ҫ�ڷ�������[���ֲ������������ǳ�Ա����]����Ϊ�������ܱ�֤���ݲ�������)*/

//��ʽһ:����������ò���(��struts2�ٷ��Ƽ���ȡ��������ʽ��������ʵ���������ã�����̫����)��׼���������������ͬ������(����Getter&Setter����)
public class ParamDemo1Action extends ActionSupport
{

	public ParamDemo1Action()
	{
		super();
		System.out.println("ParamDemo1Action~~~~~~~");
	}

	private String name;
	// �Զ�����ת����ֻ��ת��8��������������Լ���Ӧ�İ�װ��
	private Integer age;

	// ֧���ض������ַ���ת��ΪDate,����yyyy-MM-dd
	private Date birthday;

	public String execute() throws Exception
	{
		System.out.println("name����ֵ:" + name + ",age����ֵ:" + age + ",birthday����ֵ:" + birthday);
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

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public Date getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

}
