package com.vison.util;

import java.util.UUID;

public class UUIDUtil
{
	public static String getUUID()
	{
		// �õ������һ���ַ���
		return UUID.randomUUID().toString();
	}

	/*public static void main(String[] args)
	{
		System.out.println(getUUID());
	}*/
}
