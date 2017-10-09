package com.vison.service;

import java.sql.SQLException;
import java.util.List;

import com.vison.dao.BookDaoImpl;
import com.vison.domain.Book;
import com.vison.domain.PageBean;

public class BookServiceImpl
{
	// ����һ��Dao����
	BookDaoImpl bookDao = new BookDaoImpl();

	public List<Book> findAllBooks()
	{
		try
		{
			return bookDao.findAllBooks();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;

	}

	// ���ͼ����Ϣ
	public void addBook(Book book)
	{
		try
		{
			bookDao.addBook(book);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public Book findBookById(String id)
	{
		try
		{
			return bookDao.findBookById(id);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void updateBook(Book book)
	{
		try
		{
			bookDao.update(book);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void deleteBook(String id)
	{
		try
		{
			bookDao.deleteBook(id);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void deleteAllBooks(String[] ids)
	{
		try
		{
			bookDao.deleteAllBooks(ids);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public List<Book> searchBooks(String id, String category, String name, String minprice, String maxprice)
	{
		try
		{
			return bookDao.searchBooks(id, category, name, minprice, maxprice);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public PageBean findBooksPage(int currentPage, int pageSize)
	{
		try
		{
			int count = bookDao.count();// �õ��ܼ�¼��
			int totalPage = (int) Math.ceil(count * 1.0 / pageSize);// �����ҳ��
			List<Book> books = bookDao.findBooks(currentPage, pageSize);

			// ��5��������װ��PageBean�����У���Ϊ����ֵ
			PageBean pb = new PageBean();
			pb.setBooks(books);
			pb.setCount(count);
			pb.setCurrentPage(currentPage);
			pb.setPageSize(pageSize);
			pb.setTotalPage(totalPage);
			return pb;
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;
	}
}
