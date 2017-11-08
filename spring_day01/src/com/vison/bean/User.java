package com.vison.bean;

public class User
{
	private String name;
	private Integer age;
	private Car car;

	public Car getCar()
	{
		return car;
	}

	public void setCar(Car car)
	{
		this.car = car;
	}

	public User()
	{
		System.out.println("空参构造方法创建User对象");
	}

	public User(String name, Integer age, Car car)
	{
		super();
		this.name = name;
		this.age = age;
		this.car = car;
	}

	public User(String name, Integer age)
	{
		System.out.println("User(String name, Integer age)!!");
		this.name = name;
		this.age = age;
	}

	public User(String name, Car car)
	{
		System.out.println("User(String name, Car car)!!!");
		this.name = name;
		this.car = car;
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

	@Override
	public String toString()
	{
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}

	public void init()
	{
		System.out.println("初始化方法！！！");
	}

	public void destroy()
	{
		System.out.println("销毁方法！！！！");
	}

}
