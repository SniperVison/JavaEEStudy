package com.vison.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.vison.domain.Book;
import com.vison.service.BookServiceImpl;
import com.vison.util.UUIDUtil;

public class AddBookServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");

		// ��ȡ��������
		Book book = new Book();
		try
		{
			BeanUtils.populate(book, request.getParameterMap());
			book.setId(UUIDUtil.getUUID());// �ֶ�����һ�����ID
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		// ����ҵ���߼�
		BookServiceImpl bs = new BookServiceImpl();
		bs.addBook(book);
		// �ַ�ת��
		// ��д/�������·��������ڱ����·��
		request.getRequestDispatcher("bookListServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}