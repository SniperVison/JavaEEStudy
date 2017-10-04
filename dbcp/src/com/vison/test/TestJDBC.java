package com.vison.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.vison.utils.DBCPUtil;

public class TestJDBC
{
	@Test
	public void test1()
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		try
		{
			conn = DBCPUtil.getConnection();
			psmt = conn.prepareStatement("......");
			/// ........
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBCPUtil.release(conn, psmt, null);
		}

	}

}
