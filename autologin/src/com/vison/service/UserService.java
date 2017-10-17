package com.vison.service;

import java.sql.SQLException;

import com.vison.dao.UserDao;
import com.vison.domain.User;

public class UserService
{
	UserDao ud = new UserDao();

	public User findUser(String username, String password)
	{
		try
		{
			return ud.findUser(username, password);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
