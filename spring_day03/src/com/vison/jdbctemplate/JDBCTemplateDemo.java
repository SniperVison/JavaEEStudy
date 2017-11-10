package com.vison.jdbctemplate;

import java.beans.PropertyVetoException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.vison.bean.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/vison/jdbctemplate/applicationContext.xml")
// 演示JDBC模板
public class JDBCTemplateDemo
{
	// @Resource(name = "userDao") // 这是使用UserDaoImpl.java的配置
	@Resource(name = "userDao2") // 这是使用UserDaoImpl2.java的配置
	private UserDao ud;

	@Test
	public void fun() throws PropertyVetoException
	{

		// 0--准备连接池
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql:///springjdbctest");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		// 1--创建JDBC模板对象
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(dataSource);
		// 2--书写sql，并执行
		String sql = "insert into t_user values(null,'曾静')";

		jt.update(sql);
	}

	@Test
	public void fun2()
	{
		User u = new User();
		u.setName("wenying");
		ud.save(u);

	}

	@Test
	public void fun3()
	{
		User u = new User();
		u.setId(3);
		u.setName("yingying");
		ud.update(u);

	}

	@Test
	public void fun4()
	{
		ud.delete(4);
	}

	@Test
	public void fun5()
	{
		System.out.println(ud.getTotalCount());
	}

	@Test
	public void fun6()
	{
		List<User> list = ud.getAll();
		for (User user : list)
		{
			System.out.println(user);
		}

	}
}
