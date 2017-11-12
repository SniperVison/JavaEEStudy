package com.vison.mybatis.junit;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.vison.mybatis.dao.UserDao;
import com.vison.mybatis.dao.UserDaoImpl;
import com.vison.mybatis.pojo.User;

//���ǲ���ʹ��ԭʼDao����
public class MybatisDaoTest
{

	public SqlSessionFactory sqlSessionFactory;

	@Before
	public void before() throws Exception
	{
		// ���غ��������ļ�
		String resource = "mybatis-config.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// ����SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}

	@Test
	public void testDao() throws Exception
	{

		UserDao userDao = new UserDaoImpl(sqlSessionFactory);

		User user = userDao.selectUserById(10);
		System.out.println(user);
	}
}
