package com.vison.many2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.vison.domain.Role;
import com.vison.domain.User;
import com.vison.utils.HibernateUtil;

//注意:各种实体类及其配置文件，应放在同一package中，不然会有其他问题出现，我试过在另外一个package中放User和Role及配置文件，然后，数据库执行语句的时候会有误，有些语句不能执行到

//多对多操作
public class Demo
{
	@Test
	// 保存员工以及角色
	public void fun1()
	{

		// 获得session
		Session session = HibernateUtil.openSession();
		// 开启事务
		Transaction beginTransaction = session.beginTransaction();
		// 操作
		// 1、创建两个User
		User u1 = new User();
		u1.setUser_name("刘亦菲");

		User u2 = new User();
		u2.setUser_name("刘诗诗");
		// 2、创建两个Role
		Role r1 = new Role();
		r1.setRole_name("演员");

		Role r2 = new Role();
		r2.setRole_name("人妻");
		// 3、用户(User)表达关系
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);

		u2.getRoles().add(r1);
		u2.getRoles().add(r2);

		// 4、角色(Role)表达关系
		r1.getUsers().add(u1);
		r1.getUsers().add(u2);

		r2.getUsers().add(u1);
		r2.getUsers().add(u2);
		// 5、调用save方法一次保存
		session.save(u1);
		session.save(u2);
		session.save(r1);
		session.save(r2);
		// 提交事务
		beginTransaction.commit();
		// 关闭资源
		session.close();

	}

	@Test
	// 为刘诗诗新增一个角色
	public void fun2()
	{

		// 获得session
		Session session = HibernateUtil.openSession();
		// 开启事务
		Transaction beginTransaction = session.beginTransaction();
		// 操作
		// 1、获得刘诗诗用户
		User user = session.get(User.class, 2L);
		// 2、创建经纪人角色
		Role r = new Role();
		r.setRole_name("女经纪人");

		// 3、将角色添加到用户中
		user.getRoles().add(r);
		// 4、将角色转换为持久化
		// session.save(r);//在User.hbm.xml文件中增加级联操作，此句就可以省略
		// 提交事务
		beginTransaction.commit();
		// 关闭资源
		session.close();
	}

	@Test
	// 为刘亦菲解除一个角色
	public void fun3()
	{

		// 获得session
		Session session = HibernateUtil.openSession();
		// 开启事务
		Transaction beginTransaction = session.beginTransaction();
		// 操作
		// 1、获得刘亦菲用户
		User user = session.get(User.class, 1L);
		// 2、获取人妻角色
		Role r = session.get(Role.class, 2L);

		// 3、将角色从用户的角色集合中移除
		user.getRoles().remove(r);
		// 4、将角色转换为持久化
		// session.save(r);// 在User.hbm.xml文件中增加级联操作，此句就可以省略
		// 提交事务
		beginTransaction.commit();
		// 关闭资源
		session.close();

	}
}
