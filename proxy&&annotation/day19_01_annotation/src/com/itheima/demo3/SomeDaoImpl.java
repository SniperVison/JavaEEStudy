package com.itheima.demo3;

@MyTest
public class SomeDaoImpl {
	
	@MyTest(timeout=1000000)
	public void testAdd(){
		System.out.println("add����ִ����");
	}
	
	@MyTest
	public void testUpdate(){
		System.out.println("update����ִ����");
		
	}
	
	
}
