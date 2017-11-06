package com.vison.dao;

import com.vison.domain.User;

public interface UserDao
{
	// 根据登录名称返回User
	User getByUserCode(String user_code);

}
