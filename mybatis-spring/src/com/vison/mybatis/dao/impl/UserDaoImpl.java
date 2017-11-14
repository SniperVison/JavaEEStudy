package com.vison.mybatis.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.vison.mybatis.dao.UserDao;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao
{
	public void insertUser()
	{
		this.getSqlSession().insert("xxxxxxxxx", 1);
	}
}
