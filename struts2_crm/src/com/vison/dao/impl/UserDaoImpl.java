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
		// HQL��ѯ
		// 1--���session
		Session session = HibernateUtils.getCurrentSession();
		// 2--��дHQL
		String hql = "from User where user_code=?";
		// 3--������ѯ����
		Query query = session.createQuery(hql);
		// 4--���ò���
		query.setParameter(0, user_code);
		// 5--ִ�в�ѯ
		User u = (User) query.uniqueResult();

		return u;
	}

}
