package com.vison.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vison.service.AccountService;

//这里是测试注解配置aop事务的例子
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class AnnotationConfigAopTransactionDemo
{
	@Resource(name = "accountService")
	private AccountService as;

	@Test
	public void fun()
	{
		as.transfer(2, 1, 600d);
	}
}
