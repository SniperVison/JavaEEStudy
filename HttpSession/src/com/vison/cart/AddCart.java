package com.vison.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vison.entity.Book;
import com.vison.util.DBUtil;

public class AddCart extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 根据id得到书
		String id = request.getParameter("id");
		Book book = DBUtil.findBookById(id);
		// 得到Session对象
		HttpSession session = request.getSession();
		// 从session中取出list（购物车）
		List<Book> list = (List<Book>) request.getSession().getAttribute("cart");
		if (list == null)
		{
			list = new ArrayList<Book>();
		}
		list.add(book);
		session.setAttribute("cart", list);// 把list放回到session

		out.print("成功加入购物车");

		// 这种情况下是客户端禁用Cookie，通过重写URL重新使服务器获取Cookie
		String url = request.getContextPath() + "/showAllBookServlet";
		response.setHeader("refresh", "3;url=" + response.encodeURL(url));

		// 这是正常使用的情况
		// response.setHeader("refresh", "3;url=" + request.getContextPath() +
		// "/showAllBookServlet");// 设置3秒后跳转

		// 设置立即跳转按键
		out.print("<a href='" + request.getContextPath() + "/showAllBookServlet'>如需立即跳转，请点击这里</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
