package com.vison.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils
{
	public static String url;
	public static String user;
	public static String password;
	public static String driverClass;

	static
	{
		// 此处要注意要加双引号
		ResourceBundle rb = ResourceBundle.getBundle("DBinfo");
		driverClass = rb.getString("driverClass");
		url = rb.getString("url");
		user = rb.getString("user");
		password = rb.getString("password");
		try
		{
			Class.forName(driverClass);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(url, user, password);
	}

	public static void closeAll(ResultSet rs, PreparedStatement ppst, Connection conn)
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
		if (ppst != null)
		{
			try
			{
				ppst.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			ppst = null;
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
