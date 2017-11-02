package com.vison.lazy_fetch;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.vison.domain.Customer;
import com.vison.domain.LinkMan;
import com.vison.utils.HibernateUtil;

//�������� �ӳټ���|ץȡ����

//�������Բ��Խ��ۣ�Ϊ�����Ч�ʣ�fetch��ѡ����Ӧѡ��select��lazy��ȡֵӦѡ��true����ȫ��ʹ��Ĭ��ֵ

//no-session����Ľ������������session�����÷�Χ��ʹ��filter��session������Ĺرշ���filter�ķ��в���֮��ִ�У�
public class Demo2
{
	@Test
	// ���ϼ���Ĺ���
	// fetch��select �����ѯ
	// lazy��proxy��Ĭ��ֵ��-------Customer��true ������
	public void fun1()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		LinkMan lm = session.get(LinkMan.class, 1L);
		Customer customer = lm.getCustomer();
		System.out.println(customer);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	@Test
	// ���ϼ���Ĺ���
	// fetch��select �����ѯ
	// lazy��proxy��Ĭ��ֵ��-------Customer��false ��������
	public void fun2()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		LinkMan lm = session.get(LinkMan.class, 1L);
		Customer customer = lm.getCustomer();
		System.out.println(customer);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

	@Test
	// ���ϼ���Ĺ���
	// fetch��join ����ѯ
	// lazy��ȫ��ʧЧ
	public void fun3()
	{
		Session session = HibernateUtil.openSession();
		Transaction beginTransaction = session.beginTransaction();
		// ---------------------------------------------
		LinkMan lm = session.get(LinkMan.class, 1L);
		Customer customer = lm.getCustomer();
		System.out.println(customer);
		// ---------------------------------------------

		beginTransaction.commit();
		session.close();

	}

}
