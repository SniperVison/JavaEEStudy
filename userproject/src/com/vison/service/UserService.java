package com.vison.service;

import com.vison.domain.User;
import com.vison.exception.UsersException;

public interface UserService
{
	/**
	 * 添加用户信息
	 * 
	 * @param user
	 * @throws Exception
	 * 
	 */
	public void register(User user) throws Exception;

	/**
	 * 根据用户名和密码查找用户信息
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(User user) throws UsersException;
}
