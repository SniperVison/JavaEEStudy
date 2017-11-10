package com.vison.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vison.service.AccountService;

//�����ǲ���ʹ��Transactionģ��ʵ�����������
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/vison/service/applicationContext.xml")
public class TransactionDemo
{
	@Resource(name = "accountService")
	private AccountService as;

	@Test
	public void fun()
	{
		as.transfer(2, 1, 600d);
	}
}
