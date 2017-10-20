package com.vison.test;

import com.vison.service.AccountService;
import com.vison.util.ObjectFactory;

public class TestTransfer
{

	public static void main(String[] args) throws Exception
	{
		// 方法二的做法
		/*AccountService as = new AccountServiceImpl();
		as.transfer("aaa", "bbb", 100);*/

		// 方法三，最终办法，使用动态代理实现AOP
		// 这里的as是代理对象
		AccountService as = ObjectFactory.getAccountService();
		// 这里是调用工厂类里面的invoke方法操作真实对象
		as.transfer("aaa", "bbb", 100);

	}
}
