package com.vison.test;

import com.vison.service.AccountService;
import com.vison.util.ObjectFactory;

public class TestTransfer
{

	public static void main(String[] args) throws Exception
	{
		// ������������
		/*AccountService as = new AccountServiceImpl();
		as.transfer("aaa", "bbb", 100);*/

		// �����������հ취��ʹ�ö�̬����ʵ��AOP
		// �����as�Ǵ������
		AccountService as = ObjectFactory.getAccountService();
		// �����ǵ��ù����������invoke����������ʵ����
		as.transfer("aaa", "bbb", 100);

	}
}
