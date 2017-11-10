package com.vison.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import com.vison.dao.AccountDao;

//这个注解代表这个类中的方法都适用于这个注解，但是下面的方法也可以重写这个注解（即自己另外加一个注解）
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
public class AccountServiceImpl implements AccountService
{

	private AccountDao ad;
	private TransactionTemplate tt;

	// 这里的Setter方法一定要写，不然无法匹配到applicationContext.xml文件中的ad,两者的名字也要一样
	public void setTt(TransactionTemplate tt)
	{
		this.tt = tt;
	}

	public void setAd(AccountDao ad)
	{
		this.ad = ad;
	}

	// 方法三:测试注解配置AOP事务（重点）
	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
	public void transfer(final Integer from, final Integer to, final Double money)
	{
		// 加钱
		ad.addMoney(to, money);

		// int i = 1 / 0;// 测试事务发生异常是否回滚
		// 扣钱
		ad.decreaseMoney(from, money);
	}

	// ****************************************************************************************

	// 方法二:测试XML配置aop事务（重点）
	/*@Override
	public void transfer(final Integer from, final Integer to, final Double money)
	{
		// 加钱
		ad.addMoney(to, money);
	
		// int i = 1 / 0;// 测试事务发生异常是否回滚
		// 扣钱
		ad.decreaseMoney(from, money);
	}*/

	// ****************************************************************************************
	/*方法一:使用事务模板实现，但是太过繁杂，不实际
	 * 
	 * // 转账方法
	@Override
	public void transfer(final Integer from, final Integer to, final Double money)
	{
		// 这里已经封装好了，只需要将进行事务操作的代码，放进去就可以开启事务了
		tt.execute(new TransactionCallbackWithoutResult()
		{
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0)
			{
				// 加钱
				ad.addMoney(to, money);
	
				// int i = 1 / 0;//测试事务发生异常是否回滚
				// 扣钱
				ad.decreaseMoney(from, money);
			}
		});
	
		// execute方法(自动捕捉异常，异常自动回滚)其实执行了以下步骤：
		// 1、打开事务
		// 2、调用doInTransactionWithoutResult方法
		// 3、提交事务
	}*/

}
