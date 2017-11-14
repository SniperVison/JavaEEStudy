package com.vison.mybatis.junit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vison.mybatis.mapper.UserMapper;
import com.vison.mybatis.pojo.User;

//@RunWith(SpringJUnit4ClassRunner.class)
//在applicationContext.xml使用了MapperScannerConfigurer自动扫描mapper后，不能使用@RunWith(SpringJUnit4ClassRunner.class)进行测试，只能单独使用@Test注解进行测试，不知为何
public class JunitTest
{

	// 测试在applicationContext.xml中使用MapperFactoryBean配置的情况
	@Test
	public void testMapperFactoryBean() throws Exception
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// UserMapper userMapper = ac.getBean(UserMapper.class);
		UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
		User u = userMapper.findUserById(31);
		System.out.println(u);

	}

	// 测试在applicationContext.xml中使用MapperScannerConfigurer配置的情况
	@Test
	public void testMapperScannerConfigurer() throws Exception
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 直接指定实现类就可以了
		UserMapper userMapper = ac.getBean(UserMapper.class);
		User u = userMapper.findUserById(29);
		System.out.println(u);

	}
}
