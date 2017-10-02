package com.itheima.demo;

import org.junit.Assert;
import org.junit.Test;
//注：测试方法要求：不能有返回值，不能有参数
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
