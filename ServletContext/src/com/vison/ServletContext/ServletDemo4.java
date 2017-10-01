package com.vison.ServletContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo4 extends HttpServlet
{
	// ע�⣺Tomcat���������õ����ļ�ȫ�Ǹ���
	// Myeclipse�е�WEB-INF�е��ļ���һ���ģ�����Ҫ��׼·��д���У�����ʹ��navigator��ͼģʽ,·�������ʮ��ע�⣬��Ȼ�ᱨjava.io.FileNotFoundException�쳣����ʾ�Ҳ����ļ���

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// ��ȡ��Դ·��,WEB-INF�µ��ļ�
		String path_1 = this.getServletContext().getRealPath("/WEB-INF/a.properties");// ����һ��Ҫ��/����ͷ
		// ����һ��Properties���󣬻�ȡ�ļ������ֵ
		Properties pro_1 = new Properties();
		pro_1.load(new FileInputStream(path_1));
		System.out.println(pro_1.getProperty("key"));
		// ��ӡ����Դ·��
		System.out.println(path_1);

		String path_2 = this.getServletContext().getRealPath("/WEB-INF/classes/b.properties");// ·��src�ǲ��Եģ�ʵ��·����/WEB-INF/classes
		Properties pro_2 = new Properties();
		pro_2.load(new FileInputStream(path_2));
		System.out.println(pro_2.getProperty("key"));
		System.out.println(path_2);

		String path_3 = this.getServletContext().getRealPath("WEB-INF/classes/com/vison/ServletContext/c.properties");// ͬ�ϣ�ʵ��·��/WEB-INF/classes/com/vison/ServletContext/c.properties
		Properties pro_3 = new Properties();
		pro_3.load(new FileInputStream(path_3));
		System.out.println(pro_3.getProperty("key"));
		System.out.println(path_3);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
