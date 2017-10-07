package com.vison.dao;

import com.vison.domain.Account;

public interface AccountDao
{
	/**
	 * 转账
	 * 
	 * @param fromName,转出用户
	 * @param toName,转入用户
	 * @param money,转账金额
	 */
	@Deprecated // 这是方法一，这个注解表示过时，同时这种在Dao层进行转账是不合适的
	public void updateAccount(String fromName, String toName, double money) throws Exception;

	/**
	 * 根据账户信息修改金额
	 * 
	 * @param account
	 */
	public void updateAccount(Account account) throws Exception;

	/**
	 * 根据用户名查找账户信息
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public Account findAccountByName(String name) throws Exception;
}
