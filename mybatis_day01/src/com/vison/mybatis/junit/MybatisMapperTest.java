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

//�����ǲ��Զ�̬��������
public class MybatisMapperTest
{
	@Test
	public void fun() throws IOException
	{
		// ���غ��������ļ�
		String resource = "mybatis-config.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// ����SQLSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// ����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// SqlSession�����Զ�����һ��ʵ���ࣨ���ӿڣ�
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// ֱ��ʹ��userMapper���÷���
		User user = userMapper.findUserById(6);
		System.out.println(user);

		/*
				List<User> list = userMapper.findUserByUsername("��");
				for (User user : list)
				{
					System.out.println(user);
				}
		*/

		/*User u = new User();
		u.setUsername("�̲���");
		u.setAddress("����");
		u.setSex("Ů");
		u.setBirthday(new Date());
		userMapper.insertUser(u);
		sqlSession.commit();*/

		/*User u = new User();
		u.setId(4);
		u.setAddress("�ɶ�");
		u.setBirthday(new Date());
		u.setUsername("��ǿ��");
		u.setSex("��");
		userMapper.updateUserById(u);
		sqlSession.commit();*/

		/*userMapper.deleteUserById(8);
		sqlSession.commit();*/

	}
}
