package com.vison.service;

public interface AccountService
{
	/**
	 * 转账
	 * 
	 * @param fromName
	 *            转出用户
	 * @param toName
	 *            转入用户
	 * @param money
	 *            转账金额
	 */
	public void transfer(String fromName, String toName, double money);

}
