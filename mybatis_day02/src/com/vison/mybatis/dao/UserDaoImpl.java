package com.vison.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.vison.mybatis.pojo.User;

/**
 * Dao
 * 
 * @author vison
 *
 */
public class UserDaoImpl implements UserDao
{

	// ע��
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory)
	{
		this.sqlSessionFactory = sqlSessionFactory;
	}

	// ͨ���û�ID��ѯһ���û�
	public User selectUserById(Integer id)
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("test.findUserById", id);
	}

	// ͨ���û�����ģ����ѯ
	public List<User> selectUserByUsername(Integer id)
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectList("test.findUserById", id);
	}

}
