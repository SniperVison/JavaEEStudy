package com.vison.mybatis.junit;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.vison.mybatis.pojo.User;

//使用这里测试时，要把User.xml的namespace属性值改回“test”
public class MybatisTest
{
	// 根据ID查询用户
	@Test
	public void fun() throws IOException
	{
		// 加载核心配置文件
		String resource = "mybatis-config.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// 创建SQLSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 执行Sql语句
		User user = sqlSession.selectOne("test.findUserById", 6);
		System.out.println(user);
	}

	// 根据用户名称模糊查询用户列表
	@Test
	public void fun2() throws IOException
	{
		// 加载核心配置文件
		String resource = "mybatis-config.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// 创建SQLSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ========================================================================================
		// 执行Sql语句
		List<User> user = sqlSession.selectList("test.findUserByUsername", "五");
		for (User user2 : user)
		{
			System.out.println(user2);
		}

	}

	// 添加用户
	@Test
	public void fun3() throws IOException
	{
		// 加载核心配置文件
		String resource = "mybatis-config.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// 创建SQLSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ========================================================================================
		// 执行Sql语句
		User user = new User();
		user.setUsername("马云");
		user.setBirthday(new Date());
		user.setAddress("杭州");
		user.setSex("男");
		int insert = sqlSession.insert("test.insertUser", user);
		// System.out.println(insert);
		// 这步重要，需要提交事务，才能进行数据库写入操作
		sqlSession.commit();
		System.out.println(user.getId());
	}

	// 更新用户
	@Test
	public void fun4() throws IOException
	{
		// 加载核心配置文件
		String resource = "mybatis-config.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// 创建SQLSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ========================================================================================
		// 执行Sql语句
		User user = new User();
		user.setId(29);
		user.setUsername("董明珠");
		user.setBirthday(new Date());
		user.setAddress("厦门");
		user.setSex("女");
		int update = sqlSession.update("test.updateUserById", user);
		System.out.println(update);
		// 这步重要，需要提交事务，才能进行数据库写入操作
		sqlSession.commit();
	}

	// 根据ID删除用户
	@Test
	public void fun5() throws IOException
	{
		// 加载核心配置文件
		String resource = "mybatis-config.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// 创建SQLSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ========================================================================================
		// 执行Sql语句

		int delete = sqlSession.delete("test.deleteUserById", 5);
		System.out.println(delete);
		// 这步重要，需要提交事务，才能进行数据库写入操作
		sqlSession.commit();
	}

}
