package com.vison.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�˴���Ϊʵ���ļ����ع���
public class HttpServletResponseDemo2 extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// ��ȡͼƬ��·��
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/timg.jpg");
		// ͨ��·���õ�һ��������
		FileInputStream fis = new FileInputStream(path);
		// �����ֽ������
		ServletOutputStream sos = response.getOutputStream();
		// �õ�Ҫ���ص��ļ���
		String filename = path.substring(path.lastIndexOf("\\"));
		/*���������Ƶ�ϵ�д��������ʵ�ʲ������У������ڡ�+1���������������Խ��
		 * String filename = path.substring(path.lastIndexOf("\\" + 1));*/

		// �����ļ����ı����ʽ
		filename = URLEncoder.encode(filename, "UTF-8");// ������ȫ���ļ�����ΪUTF-8
		// ��֪�ͻ���Ҫ�����ļ�
		response.setHeader("content-disposition", "attachment;filename=" + filename);
		response.setHeader("content-type", "image/jpeg");
		// ִ���������
		int len = 0;
		byte[] b = new byte[1024];
		while ((len = fis.read(b)) != -1)
		{
			sos.write(b, 0, len);
		}
		sos.close();
		fis.close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
