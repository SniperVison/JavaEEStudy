package com.vison.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.vison.domain.Book;
import com.vison.service.BookServiceImpl;

public class UpdateBookServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		Book book = new Book();
		try
		{
			BeanUtils.populate(book, request.getParameterMap());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		BookServiceImpl bs = new BookServiceImpl();
		bs.updateBook(book);
		// Ìø×ª
		request.getRequestDispatcher("/bookListServlet").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
