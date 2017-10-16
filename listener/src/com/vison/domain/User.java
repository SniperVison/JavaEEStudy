package com.vison.domain;

import java.io.Serializable;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

//session 绑定javaBean,Serializable用于活化
/*
 * 1.HttpSessionBindingListener监听器功能介绍
			使javaBean对象在被绑定到会话或从会话中取消对它的绑定时得到通知
2.HttpSessionActivationListener监听器功能介绍
			绑定到会话的对象可以侦听通知它们会话将被钝化和会话将被激活的容器事件
3.注意事项
			这两个监听器比较特殊,它是由javaBean来实现的，并且不需要在web.xml文件中注册监听.
			javaBean必须是序列化的.
 */
public class User implements Serializable, HttpSessionBindingListener
{
	private String name;
	private int age;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event)
	{
		System.out.println("User对象被绑定了");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event)
	{
		System.out.println("User对象解除被绑定了");
	}

}
