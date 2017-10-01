package com.vison.service.impl;

import com.vison.dao.UserDao;
import com.vison.dao.impl.UserDaoImpl;
import com.vison.domain.User;
import com.vison.service.UserService;

public class UserServiceImpl implements UserService
{

	UserDao userDao = new UserDaoImpl();

	public void register(User user) throws Exception
	{
		userDao.addUser(user);

	}

}
