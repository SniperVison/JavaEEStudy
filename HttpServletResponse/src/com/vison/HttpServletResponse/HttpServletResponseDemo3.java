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

//�˴���Ϊʵ����֤��, jar���Ѿ��������ҵ����룬�����뿴 package ��com.popchinese.web.util
public class HttpServletResponseDemo3 extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// guiMethod(response);//����һ����ͳ��GUI���棬���Ƽ�ʹ��

		// ���߿ͻ��˲�ʹ�û���
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setIntHeader("expires", 1);

		// ���������Ƽ�ʹ�õ���ValidateCode��jar����ʹ���ֳɴ���
		ValidateCode vdc = new ValidateCode(110, 25, 5, 20);// ��һ������������֤���Ŀ�ȣ��ڶ�������߶ȣ�������������֤�������ĸ��������ĸ���������ߵ�����
		vdc.write(response.getOutputStream());
	}

	public void guiMethod(HttpServletResponse response) throws IOException
	{
		int width = 110;
		int height = 25;
		// ���ڴ��д���һ��ͼ�����
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// ����һ������
		Graphics g = img.getGraphics();
		// ��ͼƬ��ӱ���ɫ
		g.setColor(Color.pink);
		g.fillRect(1, 1, width - 2, height - 2);

		// ���߿��һ����ɫ
		g.setColor(Color.orange);
		g.drawRect(0, 0, width - 1, height - 1);

		// �����ı���ʽ
		g.setColor(Color.blue);
		g.setFont(new Font("����", Font.BOLD | Font.ITALIC, 15));

		// ��ͼƬ����ı�
		Random rand = new Random();
		for (int i = 0, position = 20; i < 4 && position < 100; i++)
		{
			g.drawString(rand.nextInt(10) + "", position, 20);
			position += 20;
		}

		// ���9��������
		for (int i = 0; i < 9; i++)
			g.drawLine(rand.nextInt(width), rand.nextInt(height), rand.nextInt(width), rand.nextInt(height));

		// ��ͼƬ���������ķ�ʽ������ͻ���
		ImageIO.write(img, "jpg", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
