package com.vison.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util
{
	static DataSource dataSource = new ComboPooledDataSource();

	public static DataSource getDataSource()
	{
		return dataSource;
	}

	public static Connection getConnection()
	{
		try
		{
			return dataSource.getConnection();
		} catch (SQLException e)
		{
			throw new RuntimeException("·þÎñÆ÷´íÎó£¡");
		}
	}

	public static void release(Connection conn, PreparedStatement psmt, ResultSet rs)
	{
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
		if (psmt != null)
		{
			try
			{
				psmt.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			psmt = null;
		}
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

	}

}
