package com.vison.mybatis.mapper;

import java.util.List;

import com.vison.mybatis.pojo.Orders;
import com.vison.mybatis.pojo.User;

public interface OrderMapper
{
	// ��ѯ������order����������

	List<Orders> selectOrdersList();

	// һ��һ���� ��ѯ �Զ���Ϊ���� �����û�
	List<Orders> selectOrders();

	// һ�Զ����
	List<User> selectUserList();
}
