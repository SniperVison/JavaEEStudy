package com.vison.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.vison.domain.Customer;
import com.vison.utils.HibernateUtil;

//ѧϰ����Criteria
public class DetachedCriteriaDemo
{
	// ������ѯ
	@Test
	public void fun1()
	{
		// Service/web��
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		dc.add(Restrictions.idEq(6L));// Ԥװ������ȫ������ͨCriteriaһ�£�

		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		Criteria executableCriteria = dc.getExecutableCriteria(session);
		List list = executableCriteria.list();
		System.out.println(list);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

}
