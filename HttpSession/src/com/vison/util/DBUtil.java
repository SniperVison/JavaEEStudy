package com.vison.util;

import java.util.HashMap;
import java.util.Map;

import com.vison.entity.Book;

public class DBUtil
{
	private static Map<String, Book> books = new HashMap<>();
	static
	{
		books.put("1", new Book("1", "C语言程序设计", 20, "谭浩强"));
		books.put("2", new Book("2", "算法入门", 36.6, "刘汝佳"));
		books.put("3", new Book("3", "Java编程思想", 78.9, "Bruce Eckel"));
		books.put("4", new Book("4", "西游记", 18.8, "吴承恩"));
	}

	// 得到所有书
	public static Map<String, Book> findAllBooks()
	{
		return books;
	}

	/**
	 * 根据ID查找指定的书
	 */
	public static Book findBookById(String id)
	{
		return books.get(id);
	}
}
