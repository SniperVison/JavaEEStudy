package com.vison.mybatis.dao;

import java.util.List;

import com.vison.mybatis.pojo.User;

public interface UserDao
{

	// 通过用户ID查询一个用户
	User selectUserById(Integer id);

	// 通过用户名称模糊查询
	List<User> selectUserByUsername(Integer id);
}
