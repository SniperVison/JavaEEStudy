package com.itheima.demo;

import org.junit.Assert;
import org.junit.Test;
//ע�����Է���Ҫ�󣺲����з���ֵ�������в���
public class TestCalc {
	@Test
	public void test1(){
		Calc c = new Calc();
		Assert.assertEquals(9, c.add(3, 5));
	}
	
	@Test
	public void test2(){
		Calc c = new Calc();
		Assert.assertEquals(3, c.div(10, 3),0.3);
	}
}
