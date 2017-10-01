package com.vison.HttpServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletResponseDemo4 extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");// 设置客户端应使用UTF-8编码格式
		/*response.setIntHeader("refresh", 1);// 设置1s刷新一次
		Random r = new Random();
		response.getWriter().write(r.nextInt() + "");//统一转换为字符串*/
		response.getWriter().write("注册成功！3秒钟跳转到主页");// 向客户端写入文本信息
		// 设置3秒钟跳转
		response.setHeader("refresh", "3;url=/HttpServletResponse/demo5");// 设置3秒后从demo4跳转到demo5
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
