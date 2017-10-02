package com.itheima.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.itheima.util.DBUtils;

public class TransactionTest
{

	// mysql事务语句
	/*开启事务：start transaction;  or begin:;
	回滚事务: rollback;
	提交事务:commit;*/

	// JDBC事务控制语句
	/*	开启事务:setAutoCommit(false);
		回滚事务:rollback();
		提交事务:commit();*/
	/*
	事务的特性（面试题）
	一、原子性：指事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生
	二、一致性：事务必须使数据库从一个一致性状态交换到另外一个一致性状态，如：转账前和转账后的总金额不变
	三、隔离性：事务的隔离性是多个用户并发访问数据库时，数据库为每一个用户开启的事务，不能被其他事务的操作数据所干扰，多个并发事务之间要相互隔离。
	四、持久性：指一个事务一旦被提交，它对数据库中数据的改变是永久的，接下来即使数据库发生故障也不应该对其有任何影响*/
	@Test
	public void test1()
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		try
		{
			conn = DBUtils.getConnection();
			conn.setAutoCommit(false);// 相当于begin，即开启事务
			psmt = conn.prepareStatement("update account set money=money-100 where name='aaa'");
			psmt.executeUpdate();
			// int i = 10 / 0;
			psmt = conn.prepareStatement("update account set money=money+100 where name='bbb'");
			psmt.executeUpdate();
			conn.commit();// 提交事务
		} catch (Exception e)
		{
			try
			{
				conn.rollback();// 回滚事务
			} catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally
		{
			DBUtils.closeAll(null, psmt, conn);
		}

	}

}
