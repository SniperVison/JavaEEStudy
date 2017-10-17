package com.vison.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vison.domain.PageBean;
import com.vison.service.BookServiceImpl;

public class PageServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		// ��ʼ��ÿҳ��ʾ�ļ�¼��
		int pageSize = 4;
		int currentPage = 1;// ��ǰҳ
		String currPage = request.getParameter("currentPage");// ����һҳ����һҳ�õ�������
		if (currPage != null)// ��һ�η�����Դʱ��currPage������null
		{
			currentPage = Integer.parseInt(currPage);
		}
		BookServiceImpl bs = new BookServiceImpl();
		// ��ҳ��ѯ��������PageBean����
		PageBean pb = bs.findBooksPage(currentPage, pageSize);
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}