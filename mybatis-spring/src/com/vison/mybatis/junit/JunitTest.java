package com.vison.mybatis.junit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vison.mybatis.mapper.UserMapper;
import com.vison.mybatis.pojo.User;

//@RunWith(SpringJUnit4ClassRunner.class)
//��applicationContext.xmlʹ����MapperScannerConfigurer�Զ�ɨ��mapper�󣬲���ʹ��@RunWith(SpringJUnit4ClassRunner.class)���в��ԣ�ֻ�ܵ���ʹ��@Testע����в��ԣ���֪Ϊ��
public class JunitTest
{

	// ������applicationContext.xml��ʹ��MapperFactoryBean���õ����
	@Test
	public void testMapperFactoryBean() throws Exception
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// UserMapper userMapper = ac.getBean(UserMapper.class);
		UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
		User u = userMapper.findUserById(31);
		System.out.println(u);

	}

	// ������applicationContext.xml��ʹ��MapperScannerConfigurer���õ����
	@Test
	public void testMapperScannerConfigurer() throws Exception
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// ֱ��ָ��ʵ����Ϳ�����
		UserMapper userMapper = ac.getBean(UserMapper.class);
		User u = userMapper.findUserById(29);
		System.out.println(u);

	}
}
