package com.vison.mybatis.junit;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.vison.mybatis.mapper.OrderMapper;
import com.vison.mybatis.pojo.Orders;
import com.vison.mybatis.pojo.User;

public class MybatisMapperTest
{
	@Test
	public void OrderList() throws IOException
	{// 加载核心配置文件
		String resource = "mybatis-config.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// 创建SQLSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Orders> selectOrders = orderMapper.selectOrders();
		for (Orders orders : selectOrders)
		{
			System.out.println(orders);
		}

	}

	@Test
	public void UserList() throws IOException
	{
		// 加载核心配置文件
		String resource = "mybatis-config.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// 创建SQLSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<User> userList = orderMapper.selectUserList();
		for (User user : userList)
		{
			System.out.println(user);
		}

	}

}
