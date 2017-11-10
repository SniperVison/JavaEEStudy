package com.vison.jdbctemplate;

import java.util.List;

import com.vison.bean.User;

public interface UserDao
{
	// 增
	void save(User u);

	// 改
	void update(User u);

	// 删
	void delete(Integer id);

	// 查
	User getById(Integer id);

	// 查
	int getTotalCount();

	// 查
	List<User> getAll();
}
