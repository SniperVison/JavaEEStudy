package com.vison.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vison.entity.Book;
import com.vison.util.DBUtil;

//如果客户端禁用Cookie时，记住把url中的"localhost"变成具体的本地IP地址

public class ShowAllBookServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		request.getSession();// 这个语句是在客户端禁用Cookie的情况下，必须要加上的，正常使用的情况无需加上
		out.print("本网站有以下好书:  <br/>");
		Map<String, Book> books = DBUtil.findAllBooks();
		for (Map.Entry<String, Book> book : books.entrySet())
		{
			String url = request.getContextPath() + "/addCart?id=" + book.getKey();
			/*这是正常情况下的使用，即客户端没有禁用Cookie
			 * out.print("<a href='" + request.getContextPath() + "/addCart?id=" + book.getKey() + "'target='_blank'>"
					+ book.getValue().getName() + "</a><br/>");*/

			// 这种情况下，是客户端（浏览器）禁用Cookie，通过重写URL重新获取Cookie
			out.print("<a href='" + response.encodeURL(url) + "'target='_blank'>" + book.getValue().getName()
					+ "</a><br/>");
		}
		// 方法二：这种情况下是禁用客户端（浏览器）Cookie，重写Cookie
		String url2 = request.getContextPath() + "/showCart";
		out.print("<a href='" + response.encodeURL(url2) + "'>查看购物车</a>");

		// 方法一：这种情况是客户端（浏览器）没有禁用Cookie
		// out.print("<a href='" + request.getContextPath() +
		// "/showCart'>查看购物车</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
