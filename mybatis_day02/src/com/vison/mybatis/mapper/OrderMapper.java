package com.vison.mybatis.mapper;

import java.util.List;

import com.vison.mybatis.pojo.Orders;
import com.vison.mybatis.pojo.User;

public interface OrderMapper
{
	// 查询订单表order的所有数据(单表查询)
	List<Orders> selectOrdersList();

	// 一对一关联 查询 以订单为中心 关联用户(多表查询)
	List<Orders> selectOrders();

	// 一对多关联(多表查询)
	List<User> selectUserList();
}
