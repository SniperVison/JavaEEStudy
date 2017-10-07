package com.vison.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.vison.dao.AccountDao;
import com.vison.dao.impl.AccountDaoImpl;
import com.vison.domain.Account;
import com.vison.service.AccountService;
import com.vison.util.C3P0Util;

public class AccountServiceImpl implements AccountService
{
	// AccountDao ad = new AccountDaoImpl();

	@Override
	public void transfer(String fromName, String toName, double money)
	{
		Connection conn = C3P0Util.getConnection();
		AccountDao ad = new AccountDaoImpl(conn);
		// 方法一：不适合,要抛异常
		// ad.updateAccount(fromName, toName, money);

		// 方法二：也不适合
		try
		{
			conn.setAutoCommit(false);// 即begin,开始事务
			// 分别得到转出和转入账户对象
			Account fromAccount = ad.findAccountByName(fromName);
			Account toAccount = ad.findAccountByName(toName);
			// 修改账户各自的金额
			fromAccount.setMoney(fromAccount.getMoney() - money);
			toAccount.setMoney(toAccount.getMoney() + money);
			// 完成转账操作
			ad.updateAccount(fromAccount);
			// int i = 10 / 0;//用于测试事务的
			ad.updateAccount(toAccount);
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
			try
			{
				conn.close();// 释放连接
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

}
