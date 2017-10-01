package com.vison.service;

import com.vison.domain.User;

public interface UserService
{
	/**
	 * 注册用户信息
	 * 
	 * @param user
	 * @throws Exception
	 */
	public void register(User user) throws Exception;
}
