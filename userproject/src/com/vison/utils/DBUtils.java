package com.vison.utils;

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
	public static String username;
	public static String password;

	static
	{
		// �˶������ڼ���properties�ļ�����
		ResourceBundle rb = ResourceBundle.getBundle("dbinfo");
		driverClass = rb.getString("diverClass");
		url = rb.getString("url");
		username = rb.getString("username");
		password = rb.getString("password");
		try
		{
			Class.forName(driverClass);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

	}

	// �õ����ӵķ���
	public static Connection getConnection() throws Exception
	{
		return DriverManager.getConnection(url, username, password);
	}

	// �ر���Դ�ķ���
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
