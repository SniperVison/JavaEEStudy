package com.vison.service.impl;

import com.vison.dao.UserDao;
import com.vison.dao.impl.UserDaoImpl;
import com.vison.domain.User;
import com.vison.service.UserService;
import com.vison.utils.HibernateUtils;

public class UserServiceImpl implements UserService
{

	private UserDao ud = new UserDaoImpl();

	public User login(User user)
	{
		// ������
		HibernateUtils.getCurrentSession().beginTransaction();

		// 1--����Dao���ݵ�¼���Ʋ�ѯUser����
		User existUser = ud.getByUserCode(user.getUser_code());
		// �ύ����
		HibernateUtils.getCurrentSession().getTransaction().commit();
		;

		// ��ȡ����->�׳��쳣��ʾ�û���������
		if (existUser == null)
			throw new RuntimeException("�û���������!");
		// 2--�Ա������Ƿ�һ��
		if (!existUser.getUser_password().equals(user.getUser_password()))
			// ��һ��->�׳��쳣�ᳫ��ʾ�������
			throw new RuntimeException("�������");
		// 3--�����ݿ��ѯ��User����
		return existUser;
	}

}
