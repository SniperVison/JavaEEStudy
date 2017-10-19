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
		// 设置一个要下载的文件
		String filename = "销售榜单.csv";// csv文件就是Excel文件
		// 设置文件名的编码
		/*但是在Windows 10 中 用户代理字符串已经修改了  不在是"msie"了
		兼容（"兼容"）和浏览器 ("MSIE") 令牌已删除。
		"like Gecko" 令牌已添加（以便与其他浏览器一致）。
		浏览器版本现在由新版本 ("rv") 令牌报告。
		win 10 ie user-agent
		Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko ie 11
		win 10 edge user-agent
		Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393 edge
		
		所以就不能在使用msie判断是否是IE 浏览器.*/
		// System.out.println(request.getHeader("user-agent"));
		// win10 ie或者edge 浏览器 和其他系统的ie
		if (request.getHeader("user-agent").toLowerCase().contains("msie")
				|| request.getHeader("user-agent").toLowerCase().contains("like gecko"))
		{
			filename = URLEncoder.encode(filename, "UTF-8");// 将不安全的文件名格式改为UTF-8
		} else
		{
			filename = new String(filename.getBytes("UTF-8"), "iso-8859-1");// 将UTF-8格式转换为iso-8859-1，这种情况是服务器->客户端
		}
		// 告知浏览器要下载文件, 设置content-disposition
		response.setHeader("content-disposition", "attachment;filename=" + filename);
		// 设置文件MIME类型,根据文件名自动获得文件类型
		response.setContentType(this.getServletContext().getMimeType(filename));
		// 告知服务器使用什么编码
		response.setCharacterEncoding("GBK");// 下载的文件，内容有可能乱码，这得视乎系统的格式，在GBK和UTF-8之间尝试，我这里UTF-8就是乱码了，GBK才是正常的

		// 创建一个文件输出流
		PrintWriter out = response.getWriter();
		out.write("电视机,20\n");
		out.write("洗衣机,10\n");
		out.write("冰箱,9\n");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);

	}

}
