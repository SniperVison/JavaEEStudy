package com.vison.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vison.service.BookServiceImpl;

public class DeleteAllBooksServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 得到所有id
		String[] ids = request.getParameterValues("ids");
		// 调用删除业务
		BookServiceImpl bs = new BookServiceImpl();
		bs.deleteAllBooks(ids);
		request.getRequestDispatcher("/bookListServlet").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
