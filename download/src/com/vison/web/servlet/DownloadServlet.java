package com.vison.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// ����һ��Ҫ���ص��ļ�
		String filename = "���۰�.csv";// csv�ļ�����Excel�ļ�
		// �����ļ����ı���
		/*������Windows 10 �� �û������ַ����Ѿ��޸���  ������"msie"��
		���ݣ�"����"��������� ("MSIE") ������ɾ����
		"like Gecko" ��������ӣ��Ա������������һ�£���
		������汾�������°汾 ("rv") ���Ʊ��档
		win 10 ie user-agent
		Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko ie 11
		win 10 edge user-agent
		Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393 edge
		
		���ԾͲ�����ʹ��msie�ж��Ƿ���IE �����.*/
		// System.out.println(request.getHeader("user-agent"));
		// win10 ie����edge ����� ������ϵͳ��ie
		if (request.getHeader("user-agent").toLowerCase().contains("msie")
				|| request.getHeader("user-agent").toLowerCase().contains("like gecko"))
		{
			filename = URLEncoder.encode(filename, "UTF-8");// ������ȫ���ļ�����ʽ��ΪUTF-8
		} else
		{
			filename = new String(filename.getBytes("UTF-8"), "iso-8859-1");// ��UTF-8��ʽת��Ϊiso-8859-1����������Ƿ�����->�ͻ���
		}
		// ��֪�����Ҫ�����ļ�, ����content-disposition
		response.setHeader("content-disposition", "attachment;filename=" + filename);
		// �����ļ�MIME����,�����ļ����Զ�����ļ�����
		response.setContentType(this.getServletContext().getMimeType(filename));
		// ��֪������ʹ��ʲô����
		response.setCharacterEncoding("GBK");// ���ص��ļ��������п������룬����Ӻ�ϵͳ�ĸ�ʽ����GBK��UTF-8֮�䳢�ԣ�������UTF-8���������ˣ�GBK����������

		// ����һ���ļ������
		PrintWriter out = response.getWriter();
		out.write("���ӻ�,20\n");
		out.write("ϴ�»�,10\n");
		out.write("����,9\n");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);

	}

}
