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
		/*��̬����������ֱ�Ӹ�ĳһĿ���������һ��һ��������󣬶�����Ҫ���������
		 * ��̬����ʹ���ģʽԭ����һ���ģ�ֻ����û�о���Ĵ����ֱ࣬��ͨ������������һ���������
		 * ##��̬�������ɼ�����
		 * 1��jdk�ṩһ��Proxy�����ֱ�Ӹ�ʵ�ֽӿ���Ķ���ֱ�����ɴ������
		 * 2��cglib(springѧϰ)		  
		  */
		/*
		  1�����⣺ҵ�񷽷��պ��ܶ࣬���кܶ��ظ��Ĵ���
		 2�����⣺�Ѿ����ںܶ�ķ�������û�п��ǵ���������⣬����Ҫ����ϡ� */

		// ������:ʹ�ö�̬����ʵ��AOP(����������),���÷���Ͷ�̬����ʵ��ת�˲������������ڲ��ı�ԭ�з���������£����ӹ���
		AccountDao ad = new AccountDaoImpl();
		// �ֱ�õ�ת����ת���˻�����
		Account fromAccount = ad.findAccountByName(fromName);
		Account toAccount = ad.findAccountByName(toName);
		// �޸��˻����ԵĽ��
		fromAccount.setMoney(fromAccount.getMoney() - money);
		toAccount.setMoney(toAccount.getMoney() + money);
		// ���ת�˲���
		ad.updateAccount(fromAccount);
		// int i = 10 / 0;// ���ڲ��������
		ad.updateAccount(toAccount);

	}
	// ��������ʹ��ThreadLocal(�ֲ߳̾�����)������߳����⣬��Ϊ��ȫ����Ҳ���ʺ�
	/*@Override
	public void transfer(String fromName, String toName, double money)
	{
	
		AccountDao ad = new AccountDaoImpl();
	
		// ��������Ҳ���ʺ�
		try
		{
			ManagerThreadLocal.startTransaction();// ��begin,��ʼ����
			// �ֱ�õ�ת����ת���˻�����
			Account fromAccount = ad.findAccountByName(fromName);
			Account toAccount = ad.findAccountByName(toName);
			// �޸��˻����ԵĽ��
			fromAccount.setMoney(fromAccount.getMoney() - money);
			toAccount.setMoney(toAccount.getMoney() + money);
			// ���ת�˲���
			ad.updateAccount(fromAccount);
			// int i = 10 / 0;// ���ڲ��������
			ad.updateAccount(toAccount);
			ManagerThreadLocal.commit();// �ύ����
		} catch (Exception e)
		{
			try
			{
				ManagerThreadLocal.rollback();// �ع�����
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally
		{
			try
			{
				ManagerThreadLocal.close();// �ͷ�����
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}*/

}
