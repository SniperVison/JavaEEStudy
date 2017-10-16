package com.vison.domain;

import java.io.Serializable;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

//session ��javaBean,Serializable���ڻ
/*
 * 1.HttpSessionBindingListener���������ܽ���
			ʹjavaBean�����ڱ��󶨵��Ự��ӻỰ��ȡ�������İ�ʱ�õ�֪ͨ
2.HttpSessionActivationListener���������ܽ���
			�󶨵��Ự�Ķ����������֪ͨ���ǻỰ�����ۻ��ͻỰ��������������¼�
3.ע������
			�������������Ƚ�����,������javaBean��ʵ�ֵģ����Ҳ���Ҫ��web.xml�ļ���ע�����.
			javaBean���������л���.
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
		System.out.println("User���󱻰���");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event)
	{
		System.out.println("User������������");
	}

}
