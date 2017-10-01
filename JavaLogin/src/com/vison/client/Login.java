package com.vison.client;

import java.util.Scanner;

import com.vison.server.DoLogin;
import com.vison.user.User;

public class Login
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名： ");
		String name = sc.nextLine();
		System.out.println("请输入密码： ");
		String pwd = sc.nextLine();
		DoLogin dl = new DoLogin();
		User uu = dl.findUser(name, pwd);
		if (uu != null)
		{
			System.out.println("欢迎你： " + uu.getName());
		} else
		{
			System.out.println("用户名或者密码错误！");
		}

	}

}
