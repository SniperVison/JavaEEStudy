package com.vison.param;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

//struts2如何获得参数
/*每次请求Action(线程安全的)时都会创建新的Action实例对象[所以参数可以是成员变量](而参数在servlet[有线程不安全的问题存在]中是要在方法里面[即局部变量，不能是成员变量]，因为这样才能保证数据不被覆盖)*/

//方式一:属性驱动获得参数(是struts2官方推荐获取参数的形式，但是现实开发不常用，步骤太繁杂)，准备与参数键名称相同的属性(就是Getter&Setter方法)
public class ParamDemo1Action extends ActionSupport
{

	public ParamDemo1Action()
	{
		super();
		System.out.println("ParamDemo1Action~~~~~~~");
	}

	private String name;
	// 自动类型转换，只能转换8大基本数据类型以及对应的包装类
	private Integer age;

	// 支持特定类型字符串转换为Date,例如yyyy-MM-dd
	private Date birthday;

	public String execute() throws Exception
	{
		System.out.println("name参数值:" + name + ",age参数值:" + age + ",birthday参数值:" + birthday);
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
