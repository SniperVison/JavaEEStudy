package com.vison.threadlocal;

//�ֲ߳̾�����
public class TestThreadLoacal
{
	public static void main(String[] args)
	{
		ThreadLocal threadLocal = new ThreadLocal();
		threadLocal.set("p");
		MyThread myThread = new MyThread(threadLocal);
		myThread.start();
		System.out.println(threadLocal.get());
	}
}
