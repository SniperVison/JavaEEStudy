package com.itheima.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class XMQ {
	
	public static void main(String[] args) {
		final KindWomen kw = new PJL();
//		 final YPX y = new YPX();
		
		//KindWomen wp = new WP(y);
//		Proxy.newProxyInstance():�����������ʵ�������ܴ���ʵ������һ���ӿڵ���
//		ClassLoader������������̶�д�����ͱ�������ʹ����ͬ������������ɡ�
//		Class[] interface��������Ҫʵ�ֵĽӿڡ��̶�д�����ͱ�������ʹ����ͬ�Ľӿڼ��ɡ�
//		InvocationHandler�����ԣ����������ģʽ��Ӧ�á���δ���
		KindWomen proxy = (KindWomen) Proxy.newProxyInstance(kw.getClass().getClassLoader(), kw.getClass().getInterfaces(), new InvocationHandler() {
			
//			InvocationHandler�е�invoke���������ô�������κη������˷�������ִ��	
//			  Object proxy:�������������á�һ���ò��š�
//			  Method method:��ǰ���õķ�����
//			  Object[] args:��ǰ�����õ��Ĳ���
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				System.out.println("����Ǯ");
				Object o =  method.invoke(kw, new Object[]{(Double)args[0]/2});
				System.out.println("������顣����");
				
				return o;
			}
		});
		
//		proxy.throwEye(5);
		proxy.doSomething(10);
	}
}
