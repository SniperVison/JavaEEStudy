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

//ʹ���������ʱ��Ҫ��User.xml��namespace����ֵ�Ļء�test��
public class MybatisTest
{
	// ����ID��ѯ�û�
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
		// ִ��Sql���
		User user = sqlSession.selectOne("test.findUserById", 6);
		System.out.println(user);
	}

	// �����û�����ģ����ѯ�û��б�
	@Test
	public void fun2() throws IOException
	{
		// ���غ��������ļ�
		String resource = "mybatis-config.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// ����SQLSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// ����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ========================================================================================
		// ִ��Sql���
		List<User> user = sqlSession.selectList("test.findUserByUsername", "��");
		for (User user2 : user)
		{
			System.out.println(user2);
		}

	}

	// ����û�
	@Test
	public void fun3() throws IOException
	{
		// ���غ��������ļ�
		String resource = "mybatis-config.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// ����SQLSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// ����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ========================================================================================
		// ִ��Sql���
		User user = new User();
		user.setUsername("����");
		user.setBirthday(new Date());
		user.setAddress("����");
		user.setSex("��");
		int insert = sqlSession.insert("test.insertUser", user);
		// System.out.println(insert);
		// �ⲽ��Ҫ����Ҫ�ύ���񣬲��ܽ������ݿ�д�����
		sqlSession.commit();
		System.out.println(user.getId());
	}

	// �����û�
	@Test
	public void fun4() throws IOException
	{
		// ���غ��������ļ�
		String resource = "mybatis-config.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// ����SQLSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// ����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ========================================================================================
		// ִ��Sql���
		User user = new User();
		user.setId(29);
		user.setUsername("������");
		user.setBirthday(new Date());
		user.setAddress("����");
		user.setSex("Ů");
		int update = sqlSession.update("test.updateUserById", user);
		System.out.println(update);
		// �ⲽ��Ҫ����Ҫ�ύ���񣬲��ܽ������ݿ�д�����
		sqlSession.commit();
	}

	// ����IDɾ���û�
	@Test
	public void fun5() throws IOException
	{
		// ���غ��������ļ�
		String resource = "mybatis-config.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// ����SQLSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// ����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ========================================================================================
		// ִ��Sql���

		int delete = sqlSession.delete("test.deleteUserById", 5);
		System.out.println(delete);
		// �ⲽ��Ҫ����Ҫ�ύ���񣬲��ܽ������ݿ�д�����
		sqlSession.commit();
	}

}
