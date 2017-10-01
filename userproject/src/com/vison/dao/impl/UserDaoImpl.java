package com.vison.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import com.vison.dao.UserDao;
import com.vison.domain.User;
import com.vison.utils.DBUtils;

public class UserDaoImpl implements UserDao
{

	@Override
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
			throw new RuntimeException("ÃÌº” ß∞‹!");
		} finally
		{
			DBUtils.closeAll(null, psmt, conn);
		}
	}

}
