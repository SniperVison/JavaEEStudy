package com.vison.lazy;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.vison.domain.Customer;
import com.vison.utils.HibernateUtil;

//����������������������������ѧϰ�༶����ز��ԡ�����������������������������������������������
//������|�ӳټ��أ�Ϊ�����Ч�ʣ��Ƽ�ʹ���ӳټ��أ������أ���

//ע�⣺ʹ��������ʱ��Ҫȷ���������Լ�������ʱ��session���Ǵ򿪵ģ�����ᱨ�����س�ʼ���쳣�����ܳ�ʼ���������û��session ��org.hibernate.LazyInitializationException: could not initialize proxy - no Session��

public class LazyDemo
{
	// get����:�������أ�ִ�з���ʱ��������sql����ѯ���
	@Test
	public void fun1()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		Customer c = session.get(Customer.class, 2L);
		System.out.println(c);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	@Test
	// load������Ĭ�ϲ�����true��������ִ��ʱ���������κ�sql��䣬����һ������ʹ�øö���ʱ����ִ�в�ѯ
	// ������������ӳټ��أ�������õ�û��ʹ�ã���ʹ��ʱ�Ž��в�ѯ
	// �Ƿ��������ӳټ��أ�����ͨ�������Ӧ��xxx.hbm.xml�ļ��е�classԪ��������lazy����������
	// lazy:true
	// ����ʱ������ѯ������ʹ������ʱ�����ݹ�����session��ѯ���ݿ⣬��������,ʵ����ʹ�õ��Ǵ����������������öϵ�Debug��Variables�鿴����$$�ľ��Ǵ������
	// lazy:false ����ʱ������ѯ ��ʵ����ʹ�õ���ֱ�Ӷ���load������get����û������
	public void fun2()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		Customer c = session.load(Customer.class, 2L);
		// ---------------------------------------------
		System.out.println(c);
		beginTransaction.commit();
		session.close();
		// System.out.println(c);//�˲���Ҫʹ�����ԣ�������session�ر�ǰʹ�ã���Ȼ�ᱨ�쳣

	}
}
