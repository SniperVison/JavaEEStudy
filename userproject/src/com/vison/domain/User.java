package com.vison.domain;

import java.io.Serializable;
import java.util.Date;

//用户数据实现序列化接口是为了避免内存溢出或者服务器宕机的时候，用户信息丢失
public class User implements Serializable
{
	private int id;
	private String username;
	private String password;
	private String email;
	private Date birthday;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
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

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
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
