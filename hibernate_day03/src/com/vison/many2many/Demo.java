package com.vison.many2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.vison.domain.Role;
import com.vison.domain.User;
import com.vison.utils.HibernateUtil;

//ע��:����ʵ���༰�������ļ���Ӧ����ͬһpackage�У���Ȼ��������������֣����Թ�������һ��package�з�User��Role�������ļ���Ȼ�����ݿ�ִ������ʱ���������Щ��䲻��ִ�е�

//��Զ����
public class Demo
{
	@Test
	// ����Ա���Լ���ɫ
	public void fun1()
	{

		// ���session
		Session session = HibernateUtil.openSession();
		// ��������
		Transaction beginTransaction = session.beginTransaction();
		// ����
		// 1����������User
		User u1 = new User();
		u1.setUser_name("�����");

		User u2 = new User();
		u2.setUser_name("��ʫʫ");
		// 2����������Role
		Role r1 = new Role();
		r1.setRole_name("��Ա");

		Role r2 = new Role();
		r2.setRole_name("����");
		// 3���û�(User)����ϵ
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);

		u2.getRoles().add(r1);
		u2.getRoles().add(r2);

		// 4����ɫ(Role)����ϵ
		r1.getUsers().add(u1);
		r1.getUsers().add(u2);

		r2.getUsers().add(u1);
		r2.getUsers().add(u2);
		// 5������save����һ�α���
		session.save(u1);
		session.save(u2);
		session.save(r1);
		session.save(r2);
		// �ύ����
		beginTransaction.commit();
		// �ر���Դ
		session.close();

	}

	@Test
	// Ϊ��ʫʫ����һ����ɫ
	public void fun2()
	{

		// ���session
		Session session = HibernateUtil.openSession();
		// ��������
		Transaction beginTransaction = session.beginTransaction();
		// ����
		// 1�������ʫʫ�û�
		User user = session.get(User.class, 2L);
		// 2�����������˽�ɫ
		Role r = new Role();
		r.setRole_name("Ů������");

		// 3������ɫ��ӵ��û���
		user.getRoles().add(r);
		// 4������ɫת��Ϊ�־û�
		// session.save(r);//��User.hbm.xml�ļ������Ӽ����������˾�Ϳ���ʡ��
		// �ύ����
		beginTransaction.commit();
		// �ر���Դ
		session.close();
	}

	@Test
	// Ϊ����ƽ��һ����ɫ
	public void fun3()
	{

		// ���session
		Session session = HibernateUtil.openSession();
		// ��������
		Transaction beginTransaction = session.beginTransaction();
		// ����
		// 1�����������û�
		User user = session.get(User.class, 1L);
		// 2����ȡ���޽�ɫ
		Role r = session.get(Role.class, 2L);

		// 3������ɫ���û��Ľ�ɫ�������Ƴ�
		user.getRoles().remove(r);
		// 4������ɫת��Ϊ�־û�
		// session.save(r);// ��User.hbm.xml�ļ������Ӽ����������˾�Ϳ���ʡ��
		// �ύ����
		beginTransaction.commit();
		// �ر���Դ
		session.close();

	}
}
