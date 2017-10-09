package com.vison.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vison.domain.Book;
import com.vison.service.BookServiceImpl;

public class BookListServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		// 调用业务逻辑
		BookServiceImpl bsi = new BookServiceImpl();
		List<Book> list = bsi.findAllBooks();
		// 跳转页面
		request.setAttribute("books", list);// 把list放入到request对象中
		request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
