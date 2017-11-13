package com.vison.mybatis.mapper;

import java.util.List;

import com.vison.mybatis.pojo.QueryVo;
import com.vison.mybatis.pojo.User;

public interface UserMapper
{
	// ��ѭ�ĸ�ԭ��
	// �ӿڷ�����==Mapper.xml(��User.xml)�е�id��
	// ����ֵ������Mapper.xml�ļ��з���ֵ����(resultType)Ҫһ��
	// ���������������Mapper.xml���������(parameterType)һ��
	// �����ռ�Ҫ�󶨴˽ӿ�(��Mapper.xml�ļ��е�namespace��mapper�ӿڵ���·��Ҫ��ͬ)
	// ===============================================================================================================
	/*��ʹ��pojo��װ��QueryVo*/
	User findUserById(Integer id);

	List<User> findUserByUsername(String username);

	void insertUser(User u);

	void updateUserById(User u);

	void deleteUserById(Integer id);

	// ===============================================================================================================

	/*ʹ��pojo��װ��QueryVo*/

	List<User> findUserByQueryVo(QueryVo vo);

	// ��ѯ��������
	Integer countUser();

	// �����Ա�����ֲ�ѯ�û�
	List<User> selectUserBySexAndUsername(User user);

	// ���ݶ��id��ѯ�û���Ϣ
	// public List<User> selectUserByIds(Integer[] ids);array

	List<User> selectUserByIds(List<Integer> ids);

	// public List<User> selectUserByIds(QueryVo vo);

}
