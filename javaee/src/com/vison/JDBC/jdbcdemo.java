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
		// ע������ ������������ע�����Σ�ǿ���������ݿ�����������Ƽ�ʹ�ã�
		/* DriverManager.registerDriver(new com.mysql.jdbc.Driver()); */
		// �����������Ƽ�ʹ�ã������Ӧ��
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
			// ��ȡ����Connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vison", "root", "root");
			// �õ�ִ��sql���Ķ���Statement
			stmt = conn.createStatement();
			// ִ��sql��䣬�����ؽ��
			rs = stmt.executeQuery("select * from student ");
			// ������
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
			// �ر���Դ
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

	// �˴�Ϊ����JUit���е�Ԫ���ԣ����Է����в����з���ֵ���Ҳ����д��ݲ���������ᱨ��
	@Test
	public void testjdbc()
	{
		// ע������ ������������ע�����Σ�ǿ���������ݿ�����������Ƽ�ʹ�ã�
		/* DriverManager.registerDriver(new com.mysql.jdbc.Driver()); */
		// �����������Ƽ�ʹ�ã������Ӧ��
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
			// ��ȡ����Connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vison", "root", "root");
			// �õ�ִ��sql���Ķ���Statement
			stmt = conn.createStatement();
			// ִ��sql��䣬�����ؽ��
			rs = stmt.executeQuery("select * from student ");
			// ������
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
			// �ر���Դ
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
