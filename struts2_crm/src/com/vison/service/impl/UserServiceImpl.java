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
		// 打开事务
		HibernateUtils.getCurrentSession().beginTransaction();

		// 1--调用Dao根据登录名称查询User对象
		User existUser = ud.getByUserCode(user.getUser_code());
		// 提交事务
		HibernateUtils.getCurrentSession().getTransaction().commit();
		;

		// 获取不到->抛出异常提示用户名不存在
		if (existUser == null)
			throw new RuntimeException("用户名不存在!");
		// 2--对比密码是否一致
		if (!existUser.getUser_password().equals(user.getUser_password()))
			// 不一致->抛出异常提倡提示密码错误
			throw new RuntimeException("密码错误");
		// 3--将数据库查询的User返回
		return existUser;
	}

}
