package com.vison.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.vison.service.AccountService;
import com.vison.service.impl.AccountServiceImpl;

//��̬����ʵ��AOP(����������)
public class ObjectFactory
{
	// ��������һ���������
	public static AccountService getAccountService()
	{

		final AccountService as = new AccountServiceImpl();
		AccountService proxy = (AccountService) Proxy.newProxyInstance(as.getClass().getClassLoader(),
				as.getClass().getInterfaces(), new InvocationHandler()
				{

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
					{
						Object invoke = null;
						try
						{
							ManagerThreadLocal.startTransaction();// ��begin,��ʼ����
							// ִ�е�����ʵ�����ת�˷���
							invoke = method.invoke(as, args);
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
						return invoke;
					}

				});
		return proxy;

	}
}
