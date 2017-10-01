package com.vison.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//此代码为实现文件下载功能
public class HttpServletResponseDemo2 extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 获取图片的路径
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/timg.jpg");
		// 通过路径得到一个输入流
		FileInputStream fis = new FileInputStream(path);
		// 创建字节输出流
		ServletOutputStream sos = response.getOutputStream();
		// 得到要下载的文件名
		String filename = path.substring(path.lastIndexOf("\\"));
		/*此语句是视频上的写法，但是实际不能运行，会由于“+1”的问题出现数组越界
		 * String filename = path.substring(path.lastIndexOf("\\" + 1));*/

		// 设置文件名的编码格式
		filename = URLEncoder.encode(filename, "UTF-8");// 将不安全的文件名改为UTF-8
		// 告知客户端要下载文件
		response.setHeader("content-disposition", "attachment;filename=" + filename);
		response.setHeader("content-type", "image/jpeg");
		// 执行输出操作
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
