package com.vison.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

public class TestCRUD
{
	@Test
	public void testInsert()
	{
		Connection conn = null;
		PreparedStatement psmt = null;

		try
		{
			conn = C3P0Util.getConnection();
			psmt = conn.prepareStatement("insert into account(id,name,money)values(8,'ppp',2000)");
			psmt.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			C3P0Util.release(conn, psmt, null);
		}
		System.out.println(conn.getClass().getName());
	}

	public void testDelete()
	{
		Connection conn = null;
		PreparedStatement psmt = null;

		try
		{
			conn = C3P0Util.getConnection();
			// psmt = conn.prepareStatement("delete from account where
			// name='ddd'");
			// psmt = (PreparedStatement) conn.createStatement();
			int i = psmt.executeUpdate("delete from account where id=4");

			if (i > 0)
				System.out.println("success");
			// psmt.execute();
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			C3P0Util.release(conn, psmt, null);
		}
	}
}
