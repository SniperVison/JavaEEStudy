package com.vison.service.impl;

import com.vison.dao.AccountDao;
import com.vison.dao.impl.AccountDaoImpl;
import com.vison.domain.Account;
import com.vison.service.AccountService;
import com.vison.util.ManagerThreadLocal;

public class AccountServiceImpl implements AccountService
{

	@Override
	public void transfer(String fromName, String toName, double money)
	{

		AccountDao ad = new AccountDaoImpl();

		// 方法二：也不适合
		try
		{
			ManagerThreadLocal.startTransaction();// 即begin,开始事务
			// 分别得到转出和转入账户对象
			Account fromAccount = ad.findAccountByName(fromName);
			Account toAccount = ad.findAccountByName(toName);
			// 修改账户各自的金额
			fromAccount.setMoney(fromAccount.getMoney() - money);
			toAccount.setMoney(toAccount.getMoney() + money);
			// 完成转账操作
			ad.updateAccount(fromAccount);
			// int i = 10 / 0;// 用于测试事务的
			ad.updateAccount(toAccount);
			ManagerThreadLocal.commit();// 提交事务
		} catch (Exception e)
		{
			try
			{
				ManagerThreadLocal.rollback();// 回滚事务
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally
		{
			try
			{
				ManagerThreadLocal.close();// 释放连接
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
