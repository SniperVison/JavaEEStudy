package com.vison.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vison.user.User;
import com.vison.util.DBUtils;

public class DoLogin
{
	/**
	 * 根据用户名和密码查询用户对象信息
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 */
	public User findUser(String name, String pwd)
	{
		Connection conn = null;
		// Statement stmt = null;
		PreparedStatement ppst = null;
		ResultSet rs = null;
		User u = null;
		try
		{
			conn = DBUtils.getConnection();

			// 此处会发生sql注入问题，是由于字符串的拼接
			/*
			 * stmt = conn.createStatement(); rs =
			 * stmt.executeQuery("select * from user where name='" + name
			 * +"'and password='" + pwd + "'");
			 */

			// 此处使用PreparedStatement处理注入问题，且性能高
			String sql = "select * from user where name=? and password= ?";
			ppst = conn.prepareStatement(sql);
			// 然后给?赋值
			ppst.setString(1, name);// 第一个参数表示参数的位置，即第一个问号的位置，如此类推
			ppst.setString(2, pwd);
			rs = ppst.executeQuery();

			if (rs.next())
			{
				u = new User();
				u.setPassword(rs.getString(1));
				u.setID(rs.getInt(2));
				u.setName(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setBirthday(rs.getDate(5));

			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtils.closeAll(rs, ppst, conn);
		}
		return u;

	}
}
