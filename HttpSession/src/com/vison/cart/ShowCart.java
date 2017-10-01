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
		out.print("���ﳵ��������Ʒ: <br/>");
		// �õ�session����
		List<Book> books = (List<Book>) request.getSession().getAttribute("cart");
		if (books == null)
		{
			out.print("���ﳵ��δ���ղص���Ʒ");
			response.setHeader("refresh", "3;url=" + request.getContextPath() + "/showAllBookServlet");// ����3�����ת
			// response.sendRedirect(request.getContextPath()+"/showAllBookServlet");
			// ����������ת����
			out.print("<a href='" + request.getContextPath() + "/showAllBookServlet'>����������ת����������</a>");
			return;
		}
		for (Book book : books)
		{
			out.write(book.getName() + "<br/>");
		}
		// ����session������ʱ�䣬��Ҫ�İ�ȫ��ʩ
		// session.setMaxInactiveInterval(5);// �˷�����λ����
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
