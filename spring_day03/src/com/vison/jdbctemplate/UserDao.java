package com.vison.jdbctemplate;

import java.util.List;

import com.vison.bean.User;

public interface UserDao
{
	// ��
	void save(User u);

	// ��
	void update(User u);

	// ɾ
	void delete(Integer id);

	// ��
	User getById(Integer id);

	// ��
	int getTotalCount();

	// ��
	List<User> getAll();
}
