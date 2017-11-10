package com.vison.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import com.vison.dao.AccountDao;

//���ע�����������еķ��������������ע�⣬��������ķ���Ҳ������д���ע�⣨���Լ������һ��ע�⣩
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
public class AccountServiceImpl implements AccountService
{

	private AccountDao ad;
	private TransactionTemplate tt;

	// �����Setter����һ��Ҫд����Ȼ�޷�ƥ�䵽applicationContext.xml�ļ��е�ad,���ߵ�����ҲҪһ��
	public void setTt(TransactionTemplate tt)
	{
		this.tt = tt;
	}

	public void setAd(AccountDao ad)
	{
		this.ad = ad;
	}

	// ������:����ע������AOP�����ص㣩
	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
	public void transfer(final Integer from, final Integer to, final Double money)
	{
		// ��Ǯ
		ad.addMoney(to, money);

		// int i = 1 / 0;// �����������쳣�Ƿ�ع�
		// ��Ǯ
		ad.decreaseMoney(from, money);
	}

	// ****************************************************************************************

	// ������:����XML����aop�����ص㣩
	/*@Override
	public void transfer(final Integer from, final Integer to, final Double money)
	{
		// ��Ǯ
		ad.addMoney(to, money);
	
		// int i = 1 / 0;// �����������쳣�Ƿ�ع�
		// ��Ǯ
		ad.decreaseMoney(from, money);
	}*/

	// ****************************************************************************************
	/*����һ:ʹ������ģ��ʵ�֣�����̫�����ӣ���ʵ��
	 * 
	 * // ת�˷���
	@Override
	public void transfer(final Integer from, final Integer to, final Double money)
	{
		// �����Ѿ���װ���ˣ�ֻ��Ҫ��������������Ĵ��룬�Ž�ȥ�Ϳ��Կ���������
		tt.execute(new TransactionCallbackWithoutResult()
		{
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0)
			{
				// ��Ǯ
				ad.addMoney(to, money);
	
				// int i = 1 / 0;//�����������쳣�Ƿ�ع�
				// ��Ǯ
				ad.decreaseMoney(from, money);
			}
		});
	
		// execute����(�Զ���׽�쳣���쳣�Զ��ع�)��ʵִ�������²��裺
		// 1��������
		// 2������doInTransactionWithoutResult����
		// 3���ύ����
	}*/

}
