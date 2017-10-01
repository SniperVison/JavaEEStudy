package com.itheima.history;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.naming.LinkLoopException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.entity.Book;
import com.itheima.util.DBUtil;

public class ShowBookDetail extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//��ʾͼ�����ϸ��Ϣ
		//���id
		String id = request.getParameter("id");
		Book book = DBUtil.findBookById(id);
		//out.write(book.toString());
		out.print(book);
		
		//�ѵ�ǰ����������idд�ص��ͻ���
		String historyBookId = organizeId(id,request);
		Cookie ck = new Cookie("historyBookId",historyBookId);
		ck.setPath("/");
		ck.setMaxAge(Integer.MAX_VALUE);//����cookie�ı���ʱ��
		
		response.addCookie(ck);//д�ص��ͻ���
		
	}

	/**
	 * �ͻ���							showAllBooks				showBookDetail
	 * û��Cookie						1						historyBookId=1
	 * ��Cookie����û��historyBookId		1						historyBookId=1
	 * historyBookId=1					2						historyBookId=2-1
	 * historyBookId=1-2				2						historyBookId=2-1
	 * historyBookId=1-2-3				2						historyBookId=2-1-3
	 * historyBookId=1-2-3				4						historyBookId=4-1-2
	 */
	
	private String organizeId(String id, HttpServletRequest request) {
		//�õ��ͻ��˵�Cookie
		Cookie[] cookies = request.getCookies();
		if(cookies==null){
			return id;
		}
		
		//������û��name����historyBookId��cookie
		Cookie historyBook = null;
		for (int i = 0; i < cookies.length; i++) {
			if("historyBookId".equals(cookies[i].getName())){
				historyBook = cookies[i];
			}
		}
		
		//���û��historyBookId��cookie���򻹷���id
		if(historyBook==null){
			return id;
		}
		
		String value = historyBook.getValue();// 2-1-3
		String[] values = value.split("-");
		LinkedList<String> list = new LinkedList<String>(Arrays.asList(values));

		if(list.size()<3){ // 1 2
			if(list.contains(id)){
				list.remove(id);//���������ǰid��ֵ����ɾ�����id
			}
		}else{
			if(list.contains(id)){
				list.remove(id);
			}else{//˵����3�����id��
				list.removeLast();//�����һ��idɾ�� 
			}
		}
		list.addFirst(id);//�������id��ӵ���ǰ��
		
		StringBuffer sb = new StringBuffer();
		for (int i=0; i< list.size();i++) {
			if(i>0){
				sb.append("-");
			}
			sb.append(list.get(i));
		}
		
		System.out.println(sb);  //1-2-3
		
		return sb.toString();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
