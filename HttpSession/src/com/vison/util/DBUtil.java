package com.vison.util;

import java.util.HashMap;
import java.util.Map;

import com.vison.entity.Book;

public class DBUtil
{
	private static Map<String, Book> books = new HashMap<>();
	static
	{
		books.put("1", new Book("1", "C���Գ������", 20, "̷��ǿ"));
		books.put("2", new Book("2", "�㷨����", 36.6, "�����"));
		books.put("3", new Book("3", "Java���˼��", 78.9, "Bruce Eckel"));
		books.put("4", new Book("4", "���μ�", 18.8, "��ж�"));
	}

	// �õ�������
	public static Map<String, Book> findAllBooks()
	{
		return books;
	}

	/**
	 * ����ID����ָ������
	 */
	public static Book findBookById(String id)
	{
		return books.get(id);
	}
}
