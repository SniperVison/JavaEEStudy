package com.vison.one2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.vison.domain.Customer;
import com.vison.domain.LinkMan;
import com.vison.utils.HibernateUtil;

//###ע��:�����������������ڼ򻯲��������ٴ����������Ҫ�õĻ���ֻ����save-update����Ϊdelete̫Σ���ˣ���ѱ�����ȫɾ���ģ�all����Ϊ��save-update+delete��������Ҳ����ʹ��
//��Customer.hbm.xml����LinkMan.hbm.xml�ļ������cascade���ԣ��Ϳ��Խ��м���������
public class One2ManyCascadeDemo
{

	// һ�Զ�|���һ��ϵ����
	// cascade=save-update
	@Test
	public void fun()
	{
		// 1�����session
		Session session = HibernateUtil.openSession();
		// 2����������
		Transaction beginTransaction = session.beginTransaction();
		// 3������
		Customer c = new Customer();
		c.setCust_name("�ٶ�");

		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("�����");

		LinkMan lm2 = new LinkMan();
		lm2.setLkm_name("�Ⲯ��");

		// ���һ�Զ࣬�ͻ����ж����ϵ��
		c.getLinkMans().add(lm1);
		c.getLinkMans().add(lm2);

		// �����һ����ϵ�������ĸ��ͻ�
		lm1.setCustomer(c);
		lm2.setCustomer(c);

		session.save(c);
		/*��Customer.hbm.xml�ļ������cascade�����������Ϳ����Զ����������
		session.save(lm1);
		session.save(lm2);
		*/
		// 4���ύ����
		beginTransaction.commit();
		// 5���ر���Դ
		session.close();

	}

	// Ϊ�ͻ�������ϵ��
	@Test
	public void fun2()
	{
		// 1�����session
		Session session = HibernateUtil.openSession();
		// 2����������
		Transaction beginTransaction = session.beginTransaction();
		// 3������
		// 3.1���Ҫ�����Ŀͻ�����
		Customer c = session.get(Customer.class, 1L);

		// 3.2������ϵ��
		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("�׾�");

		// 3.3����ϵ����ӵ��ͻ������ͻ����õ���ϵ����
		c.getLinkMans().add(lm1);
		lm1.setCustomer(c);

		// 3.4ִ�б���
		session.save(lm1);

		// 4���ύ����
		beginTransaction.commit();
		// 5���ر���Դ
		session.close();

	}

	// ����ɾ���ͻ�ʱ������ɾ���ͻ��µ���ϵ��
	// cascade=delete
	@Test
	public void fun3()
	{
		// 1�����session
		Session session = HibernateUtil.openSession();
		// 2����������
		Transaction beginTransaction = session.beginTransaction();
		// 3������
		// 3.1���Ҫ�����Ŀͻ�����
		Customer c = session.get(Customer.class, 1L);

		// 3.2����deleteɾ���ͻ�
		session.delete(c);

		// 4���ύ����
		beginTransaction.commit();
		// 5���ر���Դ
		session.close();

	}

	// ������ϵ���Լ���ϵ�˶�Ӧ�Ŀͻ�
	// ��LinkMan.hbm.xml�ļ��м��� cascade=save-update
	@Test
	public void fun4()
	{
		// 1�����session
		Session session = HibernateUtil.openSession();
		// 2����������
		Transaction beginTransaction = session.beginTransaction();
		// 3������
		Customer c = new Customer();
		c.setCust_name("����");

		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("����");
		// ���һ�Զ࣬�ͻ����ж����ϵ��
		c.getLinkMans().add(lm1);

		// �����һ����ϵ�������ĸ��ͻ�
		lm1.setCustomer(c);

		session.save(lm1);

		// 4���ύ����
		beginTransaction.commit();
		// 5���ر���Դ
		session.close();

	}
}
