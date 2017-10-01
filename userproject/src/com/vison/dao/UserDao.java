package com.vison.dao;

import com.vison.domain.User;

public interface UserDao
{
	/**
	 * 添加用户信息
	 * 
	 * @param user
	 * @throws Exception
	 */
	public void addUser(User user) throws Exception;
}
