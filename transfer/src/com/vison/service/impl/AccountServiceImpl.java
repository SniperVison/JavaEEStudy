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
		// ����һ�����ʺ�,Ҫ���쳣
		// ad.updateAccount(fromName, toName, money);

		// ��������Ҳ���ʺ�
		try
		{
			conn.setAutoCommit(false);// ��begin,��ʼ����
			// �ֱ�õ�ת����ת���˻�����
			Account fromAccount = ad.findAccountByName(fromName);
			Account toAccount = ad.findAccountByName(toName);
			// �޸��˻����ԵĽ��
			fromAccount.setMoney(fromAccount.getMoney() - money);
			toAccount.setMoney(toAccount.getMoney() + money);
			// ���ת�˲���
			ad.updateAccount(fromAccount);
			// int i = 10 / 0;//���ڲ��������
			ad.updateAccount(toAccount);
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
			try
			{
				conn.close();// �ͷ�����
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

}
