package com.vison.mybatis.dao;

import java.util.List;

import com.vison.mybatis.pojo.User;

public interface UserDao
{

	// ͨ���û�ID��ѯһ���û�
	User selectUserById(Integer id);

	// ͨ���û�����ģ����ѯ
	List<User> selectUserByUsername(Integer id);
}
