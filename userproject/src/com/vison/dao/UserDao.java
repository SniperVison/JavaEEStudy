package com.vison.dao;

import com.vison.domain.User;

public interface UserDao
{
	/**
	 * ����û���Ϣ
	 * 
	 * @param user
	 * @throws Exception
	 */
	public void addUser(User user) throws Exception;
}
