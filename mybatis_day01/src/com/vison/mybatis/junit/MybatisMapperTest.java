package com.vison.mybatis.junit;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.vison.mybatis.mapper.UserMapper;
import com.vison.mybatis.pojo.User;

//这里是测试动态代理开发的
public class MybatisMapperTest
{
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

		// SqlSession帮我自动生成一个实现类（给接口）
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 直接使用userMapper调用方法
		User user = userMapper.findUserById(6);
		System.out.println(user);

		/*
				List<User> list = userMapper.findUserByUsername("五");
				for (User user : list)
				{
					System.out.println(user);
				}
		*/

		/*User u = new User();
		u.setUsername("奶茶妹");
		u.setAddress("北京");
		u.setSex("女");
		u.setBirthday(new Date());
		userMapper.insertUser(u);
		sqlSession.commit();*/

		/*User u = new User();
		u.setId(4);
		u.setAddress("成都");
		u.setBirthday(new Date());
		u.setUsername("刘强东");
		u.setSex("男");
		userMapper.updateUserById(u);
		sqlSession.commit();*/

		/*userMapper.deleteUserById(8);
		sqlSession.commit();*/

	}
}
