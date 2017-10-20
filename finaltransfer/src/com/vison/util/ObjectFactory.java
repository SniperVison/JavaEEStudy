package com.vison.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.vison.service.AccountService;
import com.vison.service.impl.AccountServiceImpl;

//动态代理实现AOP(面向切面编程)
public class ObjectFactory
{
	// 方法返回一个代理对象
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
							ManagerThreadLocal.startTransaction();// 即begin,开始事务
							// 执行的是真实对象的转账方法
							invoke = method.invoke(as, args);
							ManagerThreadLocal.commit();// 提交事务
						} catch (Exception e)
						{
							try
							{
								ManagerThreadLocal.rollback();// 回滚事务
							} catch (Exception e1)
							{
								e1.printStackTrace();
							}
							e.printStackTrace();
						} finally
						{
							try
							{
								ManagerThreadLocal.close();// 释放连接
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
