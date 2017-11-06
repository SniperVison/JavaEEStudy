package com.vison.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vison.dao.UserDao;
import com.vison.domain.User;
import com.vison.utils.HibernateUtils;

public class UserDaoImpl implements UserDao
{

	@Override
	public User getByUserCode(String user_code)
	{
		// HQL查询
		// 1--获得session
		Session session = HibernateUtils.getCurrentSession();
		// 2--书写HQL
		String hql = "from User where user_code=?";
		// 3--创建查询对象
		Query query = session.createQuery(hql);
		// 4--设置参数
		query.setParameter(0, user_code);
		// 5--执行查询
		User u = (User) query.uniqueResult();

		return u;
	}

}
