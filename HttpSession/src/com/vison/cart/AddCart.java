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
		// ����id�õ���
		String id = request.getParameter("id");
		Book book = DBUtil.findBookById(id);
		// �õ�Session����
		HttpSession session = request.getSession();
		// ��session��ȡ��list�����ﳵ��
		List<Book> list = (List<Book>) request.getSession().getAttribute("cart");
		if (list == null)
		{
			list = new ArrayList<Book>();
		}
		list.add(book);
		session.setAttribute("cart", list);// ��list�Żص�session

		out.print("�ɹ����빺�ﳵ");

		// ����������ǿͻ��˽���Cookie��ͨ����дURL����ʹ��������ȡCookie
		String url = request.getContextPath() + "/showAllBookServlet";
		response.setHeader("refresh", "3;url=" + response.encodeURL(url));

		// ��������ʹ�õ����
		// response.setHeader("refresh", "3;url=" + request.getContextPath() +
		// "/showAllBookServlet");// ����3�����ת

		// ����������ת����
		out.print("<a href='" + request.getContextPath() + "/showAllBookServlet'>����������ת����������</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
