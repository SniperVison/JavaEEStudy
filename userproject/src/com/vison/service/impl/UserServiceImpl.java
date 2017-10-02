package com.vison.service.impl;

import com.vison.dao.UserDao;
import com.vison.dao.impl.UserDaoImpl;
import com.vison.domain.User;
import com.vison.exception.UsersException;
import com.vison.service.UserService;

public class UserServiceImpl implements UserService
{
	UserDao userDao = new UserDaoImpl();

	public void register(User user) throws Exception
	{
		userDao.addUser(user);
	}

	public User login(User user) throws UsersException
	{
		User u = null;
		try
		{
			// 当初写的时候，这里直接写了userDao.findUser(user);，所以没有获取到u对象，导致无法查询到数据，要注意
			u = userDao.findUser(user);
			if (u == null)
			{
				throw new UsersException("账户或密码错误！");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return u;
	}

}
