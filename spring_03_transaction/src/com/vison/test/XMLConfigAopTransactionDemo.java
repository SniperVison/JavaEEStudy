package com.vison.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vison.service.AccountService;

//这里是测试XML配置AOP事务的例子

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class XMLConfigAopTransactionDemo
{
	@Resource(name = "accountService")
	private AccountService as;

	@Test
	public void fun()
	{
		as.transfer(2, 1, 600d);
	}
}
