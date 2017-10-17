package com.vison.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.vison.domain.User;
import com.vison.util.C3P0Util;

public class UserDao
{

	public User findUser(String username, String password) throws SQLException
	{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

		return qr.query("select * from user where username=? and password=?", new BeanHandler<User>(User.class),
				username, password);
	}

}
