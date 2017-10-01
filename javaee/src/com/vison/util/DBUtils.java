package com.vison.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtils
{
	public static String driverClass;
	public static String url;
	public static String password;
	public static String username;

	static
	{
		// 此对象用于加载properties文件数据的
		ResourceBundle rb = ResourceBundle.getBundle("DBinfo");
		driverClass = rb.getString("driverClass");
		url = rb.getString("url");
		password = rb.getString("password");
		username = rb.getString("username");
		try
		{
			Class.forName("driverClass");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	// 得到连接的方法
	public static Connection getConnection() throws Exception
	{
		return DriverManager.getConnection(url, username, password);
	}

	// 关闭资源的方法
	public static void closeAll(ResultSet rs, Statement stmt, Connection conn)
	{
		if (rs != null)
		{
			try
			{
				rs.close();
			} catch (SQLException e)
			{
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
