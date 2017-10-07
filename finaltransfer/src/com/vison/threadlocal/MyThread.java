package com.vison.threadlocal;

public class MyThread extends Thread
{

	private ThreadLocal threadLocal;

	public MyThread(ThreadLocal threadLocal)
	{
		this.threadLocal = threadLocal;
	}

	@Override
	public void run()
	{
		System.out.println(threadLocal.get() + "3333333");
	}

}
