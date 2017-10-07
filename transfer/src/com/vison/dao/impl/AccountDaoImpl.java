package com.vison.dao.impl;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.vison.dao.AccountDao;
import com.vison.domain.Account;
import com.vison.util.C3P0Util;

public class AccountDaoImpl implements AccountDao
{

	private Connection conn;

	public AccountDaoImpl(Connection conn)
	{
		this.conn = conn;
	}

	@Override
	public void updateAccount(String fromName, String toName, double money) throws Exception
	{
		// 创建一个QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update account set money=money-? where name=?", money, fromName);
		qr.update("select account set money=money+? where name=?", money, toName);
	}

	public void updateAccount(Account account) throws Exception
	{
		QueryRunner qr = new QueryRunner();
		qr.update(conn, "update account set money=? where name=?", account.getMoney(), account.getName());

	}

	@Override
	public Account findAccountByName(String name) throws Exception
	{
		QueryRunner qr = new QueryRunner();
		return qr.query(conn, "select * from account where name=?", new BeanHandler<Account>(Account.class), name);

	}

}
