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
			// ����д��ʱ������ֱ��д��userDao.findUser(user);������û�л�ȡ��u���󣬵����޷���ѯ�����ݣ�Ҫע��
			u = userDao.findUser(user);
			if (u == null)
			{
				throw new UsersException("�˻����������");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return u;
	}

}
