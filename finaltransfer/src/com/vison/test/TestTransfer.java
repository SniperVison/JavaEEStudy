package com.vison.test;

import com.vison.service.AccountService;
import com.vison.service.impl.AccountServiceImpl;

public class TestTransfer
{

	public static void main(String[] args) throws Exception
	{
		AccountService as = new AccountServiceImpl();
		as.transfer("aaa", "bbb", 100);

	}
}
