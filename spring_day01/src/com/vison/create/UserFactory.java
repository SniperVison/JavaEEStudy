package com.vison.create;

import com.vison.bean.User;

public class UserFactory
{

	// ������ʽ��:��̬��������
	public static User createUser()
	{
		System.out.println("��̬��������User����");
		return new User();
	}

	// ������ʽ����ʵ����������
	public User createUser2()
	{
		System.out.println("ʵ����������User����");
		return new User();
	}
}
