package com.vison.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class jdbcdemo
{

	public static void main(String[] args)
	{
		// 注册驱动 （导致驱动被注册两次，强烈依赖数据库的驱动，不推荐使用）
		/* DriverManager.registerDriver(new com.mysql.jdbc.Driver()); */
		// 加载驱动（推荐使用）反射的应用
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			// 获取连接Connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vison", "root", "root");
			// 得到执行sql语句的对象Statement
			stmt = conn.createStatement();
			// 执行sql语句，并返回结果
			rs = stmt.executeQuery("select * from student ");
			// 处理结果
			while (rs.next())
			{
				System.out.println(rs.getObject(1));
				System.out.println(rs.getObject(2));
				System.out.println(rs.getObject(3));
				// System.out.println(rs.getObject(4));
				// System.out.println(rs.getObject(5));
				System.out.println("-------------");
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			// 关闭资源
			if (rs != null)
			{
				try
				{
					rs.close();
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs = null;
			}
			if (stmt != null)
			{
				try
				{
					stmt.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
				stmt = null;
			}

			if (conn != null)
			{
				try
				{
					conn.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
				conn = null;
			}

		}

	}

	// 此处为利用JUit进行单元测试，测试方法中不能有返回值，且不能有传递参数，否则会报错
	@Test
	public void testjdbc()
	{
		// 注册驱动 （导致驱动被注册两次，强烈依赖数据库的驱动，不推荐使用）
		/* DriverManager.registerDriver(new com.mysql.jdbc.Driver()); */
		// 加载驱动（推荐使用）反射的应用
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			// 获取连接Connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vison", "root", "root");
			// 得到执行sql语句的对象Statement
			stmt = conn.createStatement();
			// 执行sql语句，并返回结果
			rs = stmt.executeQuery("select * from student ");
			// 处理结果
			while (rs.next())
			{
				System.out.println(rs.getObject(1));
				System.out.println(rs.getObject(2));
				System.out.println(rs.getObject(3));
				System.out.println(rs.getObject(4));
				System.out.println(rs.getObject(5));
				System.out.println("-------------");
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			// 关闭资源
			if (rs != null)
			{
				try
				{
					rs.close();
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs = null;
			}
			if (stmt != null)
			{
				try
				{
					stmt.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
				stmt = null;
			}

			if (conn != null)
			{
				try
				{
					conn.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
				conn = null;
			}

		}
	}

}
