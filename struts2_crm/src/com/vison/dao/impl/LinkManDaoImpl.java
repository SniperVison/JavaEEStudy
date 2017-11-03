package com.vison.dao.impl;

import org.hibernate.Session;

import com.vison.dao.LinkManDao;
import com.vison.domain.LinkMan;
import com.vison.utils.HibernateUtils;

public class LinkManDaoImpl implements LinkManDao
{

	public void save(LinkMan lm)
	{
		// 1 »ñµÃsession
		Session session = HibernateUtils.getCurrentSession();
		session.save(lm);
	}

}
