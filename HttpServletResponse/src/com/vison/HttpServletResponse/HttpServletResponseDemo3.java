package com.vison.HttpServletResponse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

//此代码为实现验证码, jar包已经从网上找到代码，详情请看 package ：com.popchinese.web.util
public class HttpServletResponseDemo3 extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// guiMethod(response);//方法一：传统的GUI界面，不推荐使用

		// 告诉客户端不使用缓存
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setIntHeader("expires", 1);

		// 方法二：推荐使用导入ValidateCode的jar包，使用现成代码
		ValidateCode vdc = new ValidateCode(110, 25, 5, 20);// 第一个参数代表验证码框的宽度，第二个代表高度，第三个代表验证码数量的个数，第四个代表干扰线的数量
		vdc.write(response.getOutputStream());
	}

	public void guiMethod(HttpServletResponse response) throws IOException
	{
		int width = 110;
		int height = 25;
		// 在内存中创建一个图像对象
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 创建一个画笔
		Graphics g = img.getGraphics();
		// 给图片添加背景色
		g.setColor(Color.pink);
		g.fillRect(1, 1, width - 2, height - 2);

		// 给边框加一个颜色
		g.setColor(Color.orange);
		g.drawRect(0, 0, width - 1, height - 1);

		// 设置文本样式
		g.setColor(Color.blue);
		g.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));

		// 给图片添加文本
		Random rand = new Random();
		for (int i = 0, position = 20; i < 4 && position < 100; i++)
		{
			g.drawString(rand.nextInt(10) + "", position, 20);
			position += 20;
		}

		// 添加9条干扰线
		for (int i = 0; i < 9; i++)
			g.drawLine(rand.nextInt(width), rand.nextInt(height), rand.nextInt(width), rand.nextInt(height));

		// 将图片对象以流的方式输出到客户端
		ImageIO.write(img, "jpg", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
