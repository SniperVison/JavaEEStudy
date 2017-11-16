package com.vison.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable
{
	private Integer id;
	private String username;
	private String sex;
	private Date birthday;
	private String address;

	// ���Ӷ���-��������
	private List<Orders> ordersList;

	public List<Orders> getOrdersList()
	{
		return ordersList;
	}

	public void setOrderList(List<Orders> ordersList)
	{
		this.ordersList = ordersList;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public Date getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	@Override
	public String toString()
	{
		return "User [id=" + id + ", username=" + username + ", sex=" + sex + ", birthday=" + birthday + ", address="
				+ address + ", orderList=" + ordersList + "]";
	}

}