package com.vison.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.vison.dao.UserDao;
import com.vison.domain.User;
import com.vison.utils.DBUtils;

public class UserDaoImpl implements UserDao
{

	public void addUser(User user) throws Exception
	{
		Connection conn = null;
		PreparedStatement psmt = null;

		try
		{
			conn = DBUtils.getConnection();
			psmt = conn.prepareStatement("INSERT INTO users(username,PASSWORD,email,birthday) VALUES(?,?,?,?)");
			psmt.setString(1, user.getUsername());
			psmt.setString(2, user.getPassword());
			psmt.setString(3, user.getEmail());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(user.getBirthday());
			psmt.setString(4, date);

			int i = psmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException("添加失败！");
		} finally
		{
			DBUtils.closeAll(null, psmt, conn);
		}

	}

	public User findUser(User user) throws Exception
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		User u = null;
		try
		{
			conn = DBUtils.getConnection();
			psmt = conn.prepareStatement("select * from users where username=? and password=?");
			psmt.setString(1, user.getUsername());
			psmt.setString(2, user.getPassword());
			rs = psmt.executeQuery();
			if (rs.next())
			{
				u = new User();
				u.setId(rs.getInt(1));
				// 第一列是id，第二列才是用户名
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setBirthday(rs.getDate(5));
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtils.closeAll(rs, psmt, conn);
		}
		return u;
	}

	public boolean findUserByName(String name)
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try
		{
			conn = DBUtils.getConnection();
			psmt = conn.prepareStatement("select * from users where username=?");
			psmt.setString(1, name);

			rs = psmt.executeQuery();
			if (rs.next())
			{
				return true;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtils.closeAll(rs, psmt, conn);
		}
		return false;
	}

}
