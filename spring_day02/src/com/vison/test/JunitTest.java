package com.vison.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vison.bean.User;

//�����Ǵ�������
@RunWith(SpringJUnit4ClassRunner.class)
// ָ����������ʱʹ���ĸ������ļ�
@ContextConfiguration("classpath:applicationContext.xml")
public class JunitTest
{
	// ����Ϊuser�Ķ���ע�뵽u������
	@Resource(name = "user")
	private User u;

	@Test
	public void fun()
	{
		System.out.println(u);

	}
}
