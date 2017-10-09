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
	 * 查找所有图书
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
	 * 添加图书信息
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
	 * 根据id查找图书信息
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
	 * 修改图书信息
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
	 * 根据id删除图书
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
	 * 批量删除
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
			{ ids[i] };// 循环给每个一维数组中的元素赋值，值是id
		qr.batch("delete from book where id=?", params);
	}

	/**
	 * 多条件查询图书
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
			sql += " and id like ?";// 不能在这里写%
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
	 * 得到总记录数
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
	 * 查找分页数据
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
