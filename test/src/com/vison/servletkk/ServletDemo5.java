package com.vison.servletkk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo5 extends HttpServlet
{
	// ����̰߳�ȫ�������Ѱ취�� ����Ҫʹ��ȫ�ֱ���������ʹ�þֲ�����
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int num = 1;
		num++;
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(num);

	}
}
