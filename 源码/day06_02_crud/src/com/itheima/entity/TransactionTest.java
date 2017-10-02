package com.itheima.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.itheima.util.DBUtils;

public class TransactionTest
{

	// mysql�������
	/*��������start transaction;  or begin:;
	�ع�����: rollback;
	�ύ����:commit;*/

	// JDBC����������
	/*	��������:setAutoCommit(false);
		�ع�����:rollback();
		�ύ����:commit();*/
	/*
	��������ԣ������⣩
	һ��ԭ���ԣ�ָ������һ�����ɷָ�Ĺ�����λ�������еĲ���Ҫô��������Ҫô��������
	����һ���ԣ��������ʹ���ݿ��һ��һ����״̬����������һ��һ����״̬���磺ת��ǰ��ת�˺���ܽ���
	���������ԣ�����ĸ������Ƕ���û������������ݿ�ʱ�����ݿ�Ϊÿһ���û����������񣬲��ܱ���������Ĳ������������ţ������������֮��Ҫ�໥���롣
	�ġ��־��ԣ�ָһ������һ�����ύ���������ݿ������ݵĸı������õģ���������ʹ���ݿⷢ������Ҳ��Ӧ�ö������κ�Ӱ��*/
	@Test
	public void test1()
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		try
		{
			conn = DBUtils.getConnection();
			conn.setAutoCommit(false);// �൱��begin������������
			psmt = conn.prepareStatement("update account set money=money-100 where name='aaa'");
			psmt.executeUpdate();
			// int i = 10 / 0;
			psmt = conn.prepareStatement("update account set money=money+100 where name='bbb'");
			psmt.executeUpdate();
			conn.commit();// �ύ����
		} catch (Exception e)
		{
			try
			{
				conn.rollback();// �ع�����
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
