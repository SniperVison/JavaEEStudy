package com.vison.client;

import java.util.Scanner;

import com.vison.server.DoLogin;
import com.vison.user.User;

public class Login
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û����� ");
		String name = sc.nextLine();
		System.out.println("���������룺 ");
		String pwd = sc.nextLine();
		DoLogin dl = new DoLogin();
		User uu = dl.findUser(name, pwd);
		if (uu != null)
		{
			System.out.println("��ӭ�㣺 " + uu.getName());
		} else
		{
			System.out.println("�û��������������");
		}

	}

}
