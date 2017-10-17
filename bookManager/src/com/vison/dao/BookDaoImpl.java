package com.vison.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.vison.domain.Book;
import com.vison.util.C3P0Util;

public class BookDaoImpl
{
	/**
	 * ��������ͼ��
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Book> findAllBooks() throws SQLException
	{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select *from book", new BeanListHandler<Book>(Book.class));
	}

	/**
	 * ����ͼ����Ϣ
	 * 
	 * @param book
	 * @throws SQLException
	 */
	public void addBook(Book book) throws SQLException
	{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("insert into book values(?,?,?,?,?,?)", book.getId(), book.getName(), book.getPrice(), book.getPnum(),
				book.getCategory(), book.getDescription());
	}

	/**
	 * ����id����ͼ����Ϣ
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Book findBookById(String id) throws SQLException
	{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from book where id=?", new BeanHandler<Book>(Book.class), id);
	}

	/**
	 * �޸�ͼ����Ϣ
	 * 
	 * @param book
	 * @throws SQLException
	 */
	public void update(Book book) throws SQLException
	{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update book set name=?,price=?,pnum=?,category=?,description=? where id=?", book.getName(),
				book.getPrice(), book.getPnum(), book.getCategory(), book.getDescription(), book.getId());
	}

	/**
	 * ����idɾ��ͼ��
	 * 
	 * @param id
	 * @throws SQLException
	 */
	public void deleteBook(String id) throws SQLException
	{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("delete from book where id=?", id);
	}

	/**
	 * ����ɾ��
	 * 
	 * @param ids
	 * @throws SQLException
	 */
	public void deleteAllBooks(String[] ids) throws SQLException
	{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		Object[][] params = new Object[ids.length][];
		for (int i = 0; i < params.length; i++)
			params[i] = new Object[]
			{ ids[i] };// ѭ����ÿ��һά�����е�Ԫ�ظ�ֵ��ֵ��id
		qr.batch("delete from book where id=?", params);
	}

	/**
	 * ��������ѯͼ��
	 * 
	 * @param id
	 * @param category
	 * @param name
	 * @param minprice
	 * @param maxprice
	 * @return
	 * @throws SQLException
	 */
	public List<Book> searchBooks(String id, String category, String name, String minprice, String maxprice)
			throws SQLException
	{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from book where 1=1";
		List list = new ArrayList();
		if (!"".equals(id.trim()))
		{
			sql += " and id like ?";// ����������д%
			list.add("%" + id.trim() + "%");
		}
		if (!"".equals(category.trim()))
		{
			sql += " and category=?";
			list.add(category);
		}
		if (!"".equals(name.trim()))
		{
			sql += " and name like ?";
			list.add("%" + name + "%");
		}
		if (!"".equals(minprice.trim()))
		{
			sql += " and price >?";
			list.add(minprice.trim());
		}
		if (!"".equals(maxprice))
		{
			sql += " and price <?";
			list.add(maxprice);
		}
		return qr.query(sql, new BeanListHandler<Book>(Book.class), list.toArray());

	}

	/**
	 * �õ��ܼ�¼��
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int count() throws SQLException
	{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		long l = qr.query("select count(*) from book", new ScalarHandler(1));
		return (int) l;
	}

	/**
	 * ���ҷ�ҳ����
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws SQLException
	 * 
	 */
	public List<Book> findBooks(int currentPage, int pageSize) throws SQLException
	{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from book limit ?,?", new BeanListHandler<Book>(Book.class),
				(currentPage - 1) * pageSize, pageSize);

	}
}