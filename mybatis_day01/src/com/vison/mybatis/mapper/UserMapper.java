package com.vison.mybatis.mapper;

import java.util.List;

import com.vison.mybatis.pojo.User;

public interface UserMapper
{
	// ��ѭ�ĸ�ԭ��
	// �ӿڷ�����==Mapper.xml(��User.xml)�е�id��
	// ����ֵ������Mapper.xml�ļ��з���ֵ����(resultType)Ҫһ��
	// ���������������Mapper.xml���������(parameterType)һ��
	// �����ռ�Ҫ�󶨴˽ӿ�(��Mapper.xml�ļ��е�namespace��mapper�ӿڵ���·��Ҫ��ͬ)
	User findUserById(Integer id);

	List<User> findUserByUsername(String username);

	void insertUser(User u);

	void updateUserById(User u);

	void deleteUserById(Integer id);

}
