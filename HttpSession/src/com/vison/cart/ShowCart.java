package com.vison.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vison.entity.Book;

public class ShowCart extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("购物车有以下商品: <br/>");
		// 得到session对象
		List<Book> books = (List<Book>) request.getSession().getAttribute("cart");
		if (books == null)
		{
			out.print("购物车尚未有收藏的商品");
			response.setHeader("refresh", "3;url=" + request.getContextPath() + "/showAllBookServlet");// 设置3秒后跳转
			// response.sendRedirect(request.getContextPath()+"/showAllBookServlet");
			// 设置立即跳转按键
			out.print("<a href='" + request.getContextPath() + "/showAllBookServlet'>如需立即跳转，请点击这里</a>");
			return;
		}
		for (Book book : books)
		{
			out.write(book.getName() + "<br/>");
		}
		// 设置session的生存时间，重要的安全措施
		// session.setMaxInactiveInterval(5);// 此方法单位是秒
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
