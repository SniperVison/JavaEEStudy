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

//����ͻ��˽���Cookieʱ����ס��url�е�"localhost"��ɾ���ı���IP��ַ

public class ShowAllBookServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		request.getSession();// ���������ڿͻ��˽���Cookie������£�����Ҫ���ϵģ�����ʹ�õ�����������
		out.print("����վ�����º���:  <br/>");
		Map<String, Book> books = DBUtil.findAllBooks();
		for (Map.Entry<String, Book> book : books.entrySet())
		{
			String url = request.getContextPath() + "/addCart?id=" + book.getKey();
			/*������������µ�ʹ�ã����ͻ���û�н���Cookie
			 * out.print("<a href='" + request.getContextPath() + "/addCart?id=" + book.getKey() + "'target='_blank'>"
					+ book.getValue().getName() + "</a><br/>");*/

			// ��������£��ǿͻ��ˣ������������Cookie��ͨ����дURL���»�ȡCookie
			out.print("<a href='" + response.encodeURL(url) + "'target='_blank'>" + book.getValue().getName()
					+ "</a><br/>");
		}
		// ������������������ǽ��ÿͻ��ˣ��������Cookie����дCookie
		String url2 = request.getContextPath() + "/showCart";
		out.print("<a href='" + response.encodeURL(url2) + "'>�鿴���ﳵ</a>");

		// ����һ����������ǿͻ��ˣ��������û�н���Cookie
		// out.print("<a href='" + request.getContextPath() +
		// "/showCart'>�鿴���ﳵ</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
