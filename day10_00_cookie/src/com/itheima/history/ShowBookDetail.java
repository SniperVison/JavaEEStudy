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
		//显示图书的详细信息
		//获得id
		String id = request.getParameter("id");
		Book book = DBUtil.findBookById(id);
		//out.write(book.toString());
		out.print(book);
		
		//把当前浏览过的书的id写回到客户端
		String historyBookId = organizeId(id,request);
		Cookie ck = new Cookie("historyBookId",historyBookId);
		ck.setPath("/");
		ck.setMaxAge(Integer.MAX_VALUE);//设置cookie的保存时间
		
		response.addCookie(ck);//写回到客户端
		
	}

	/**
	 * 客户端							showAllBooks				showBookDetail
	 * 没有Cookie						1						historyBookId=1
	 * 有Cookie，但没有historyBookId		1						historyBookId=1
	 * historyBookId=1					2						historyBookId=2-1
	 * historyBookId=1-2				2						historyBookId=2-1
	 * historyBookId=1-2-3				2						historyBookId=2-1-3
	 * historyBookId=1-2-3				4						historyBookId=4-1-2
	 */
	
	private String organizeId(String id, HttpServletRequest request) {
		//得到客户端的Cookie
		Cookie[] cookies = request.getCookies();
		if(cookies==null){
			return id;
		}
		
		//查找有没有name叫做historyBookId的cookie
		Cookie historyBook = null;
		for (int i = 0; i < cookies.length; i++) {
			if("historyBookId".equals(cookies[i].getName())){
				historyBook = cookies[i];
			}
		}
		
		//如果没有historyBookId的cookie，则还返回id
		if(historyBook==null){
			return id;
		}
		
		String value = historyBook.getValue();// 2-1-3
		String[] values = value.split("-");
		LinkedList<String> list = new LinkedList<String>(Arrays.asList(values));

		if(list.size()<3){ // 1 2
			if(list.contains(id)){
				list.remove(id);//如果包含当前id的值，则删除这个id
			}
		}else{
			if(list.contains(id)){
				list.remove(id);
			}else{//说明有3本书的id了
				list.removeLast();//把最后一个id删除 
			}
		}
		list.addFirst(id);//最新书的id添加到最前面
		
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
