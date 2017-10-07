package com.vison.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util
{
	// �õ�һ������Դ
	private static DataSource dataSource = new ComboPooledDataSource();

	public static DataSource getDataSource()
	{
		return dataSource;
	}

	// ������Դ�еõ�һ�����Ӷ���
	public static Connection getConnection()
	{
		try
		{
			return dataSource.getConnection();
		} catch (SQLException e)
		{
			throw new RuntimeException("����������");
		}
	}

	public static void release(Connection conn, PreparedStatement psmt, ResultSet rs)
	{
		// �ر���Դ
		if (rs != null)
		{
			try
			{
				rs.close();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			rs = null;
		}
		if (psmt != null)
		{
			try
			{
				psmt.close();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			psmt = null;
		}
		if (conn != null)
		{
			try
			{
				conn.close();// �ر�
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			conn = null;
		}
	}

}
