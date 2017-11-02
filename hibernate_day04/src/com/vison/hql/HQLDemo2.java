package com.vison.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.vison.domain.Customer;
import com.vison.utils.HibernateUtil;

//HQL�﷨������ѯ�﷨,������
public class HQLDemo2
{
	/*-----ԭ��SQL---------------*/
	// ��������-�ѿ����������⣩
	/*select * from A,B*/
	// ������
	// ������1-��ʽ������
	/*select * from A,B where b.aid=a.id*/
	// ������2-��ʾ������
	/*select * from A inner join B on b.aid=a.id*/
	// ������
	// ������ 1-��������
	/*select * from A left [outer] join B on b.aid=a.id*/
	// ������2-��������
	/*select * from A right [outer] join B on b.aid=a.id*/
	// ---------------------------------------------------------------------------

	/*HQL�Ķ���ѯ*/
	// ������->�����ӵ����˶���ֱ𷵻أ��ŵ�������
	@Test
	public void fun1()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// --------------------------------------------------------------
		String hqlInner = "from Customer c inner join  c.linkMans ";
		Query query = session.createQuery(hqlInner);
		List<Object[]> list = query.list();
		for (Object[] objects : list)
		{
			System.out.println(Arrays.toString(objects));
		}

		// --------------------------------------------------------------
		beginTransaction.commit();
		session.close();
	}

	@Test
	// ����������==�����ǽ��з�װ������ֵ����һ������
	// Ҫ��Customer��toString�����޸ĳ��Լ�������Ҫ���ַ���
	public void fun2()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// --------------------------------------------------------------
		// ���в�ѯ��sql�����Ҫ����fetch
		String hqlInner = "from Customer c inner  join fetch  c.linkMans ";
		Query query = session.createQuery(hqlInner);
		List<Customer> list = query.list();

		System.out.println(list);

		// --------------------------------------------------------------
		beginTransaction.commit();
		session.close();
	}

	// ������2--��������->�����ӵ����˶���ֱ𷵻أ��ŵ�������
	@Test
	public void fun4()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// --------------------------------------------------------------
		String hqlInner = "from Customer c right join  c.linkMans ";
		Query query = session.createQuery(hqlInner);
		List<Object[]> list = query.list();
		for (Object[] objects : list)
		{
			System.out.println(Arrays.toString(objects));
		}

		// --------------------------------------------------------------
		beginTransaction.commit();
		session.close();
	}

	// ������
	// ������1--��������->�����ӵ����˶���ֱ𷵻أ��ŵ�������
	@Test
	public void fun3()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// --------------------------------------------------------------
		String hqlInner = "from Customer c left join  c.linkMans ";
		Query query = session.createQuery(hqlInner);
		List<Object[]> list = query.list();
		for (Object[] objects : list)
		{
			System.out.println(Arrays.toString(objects));
		}

		// --------------------------------------------------------------
		beginTransaction.commit();
		session.close();
	}

}
