package com.vison.mybatis.mapper;

import java.util.List;

import com.vison.mybatis.pojo.User;

public interface UserMapper
{
	// 遵循四个原则
	// 接口方法名==Mapper.xml(如User.xml)中的id名
	// 返回值类型与Mapper.xml文件中返回值类型(resultType)要一致
	// 方法的入参类型与Mapper.xml中入参类型(parameterType)一致
	// 命名空间要绑定此接口(即Mapper.xml文件中的namespace与mapper接口的类路径要相同)
	User findUserById(Integer id);

	List<User> findUserByUsername(String username);

	void insertUser(User u);

	void updateUserById(User u);

	void deleteUserById(Integer id);

}
