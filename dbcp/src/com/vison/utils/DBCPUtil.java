package com.vison.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DBCPUtil
{
	private static DataSource ds = null;
	static
	{
		Properties prop = new Properties();
		try
		{
			prop.load(DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));// ͨ����ǰ�ࣨDBCPUtil��classes���ľ���·�����������ļ���
			// ���Ƿ�װ�õ�װ��ģʽ
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e)
		{
			throw new ExceptionInInitializerError("��ʼ���������������ļ�");
		}
	}

	public static Connection getConnection()
	{
		try
		{
			return ds.getConnection();
		} catch (SQLException e)
		{
			throw new RuntimeException("��������æ��");
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
