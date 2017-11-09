package com.vison.annotationaop;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vison.service.UserService;

//�����Ǵ�������
@RunWith(SpringJUnit4ClassRunner.class)
// ָ����������ʱʹ���ĸ������ļ�

@ContextConfiguration("classpath:com/vison/annotationaop/applicationContext.xml")
public class AnnotationAopDemo
{
	// ����Ϊuser�Ķ���ע�뵽u������
	@Resource(name = "userService")
	private UserService us;

	@Test
	public void fun()
	{
		us.save();

	}
}
