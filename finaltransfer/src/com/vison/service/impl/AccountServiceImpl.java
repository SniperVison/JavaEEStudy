package com.vison.service.impl;

import com.vison.dao.AccountDao;
import com.vison.dao.impl.AccountDaoImpl;
import com.vison.domain.Account;
import com.vison.service.AccountService;

public class AccountServiceImpl implements AccountService
{

	@Override
	public void transfer(String fromName, String toName, double money) throws Exception
	{
		/*动态代理它可以直接给某一目标对象生成一个一个代理对象，而不需要代理类存在
		 * 动态代理和代理模式原理是一样的，只是它没有具体的代理类，直接通过反射生成了一个代理对象
		 * ##动态代理生成技术：
		 * 1、jdk提供一个Proxy类可以直接给实现接口类的对象直接生成代理对象
		 * 2、cglib(spring学习)		  
		  */
		/*
		  1、问题：业务方法日后会很多，会有很多重复的代码
		 2、问题：已经存在很多的方法，并没有考虑到事务的问题，现在要求加上。 */

		// 方法三:使用动态代理实现AOP(面向切面编程),利用反射和动态代理实现转账操作，作用在于不改变原有方法的情况下，增加功能
		AccountDao ad = new AccountDaoImpl();
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

	}
	// 方法二：使用ThreadLocal(线程局部变量)解决多线程问题，较为安全，但也不适合
	/*@Override
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
	}*/

}
