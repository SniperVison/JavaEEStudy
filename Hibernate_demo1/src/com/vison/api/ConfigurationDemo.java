package com.vison.api;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

//Configuration����:���ü����࣬���ڼ��������ã�ormԪ���ݼ���
public class ConfigurationDemo
{
	@Test
	public void fun1()
	{
		// 1�����������ÿղι���
		Configuration conf = new Configuration();
		// 2����ȡָ���������ļ�->�ղμ��ط���������src�µ�hibernate.cfg.xml�ļ�
		conf.configure();
		// 3����ȡָ��ormԪ���ݣ���չ����������������Ѿ�����ӳ�����ã�����Ҫ�ֶ�����
		// conf.addResource(resourceName);
		// conf.addClass(persistentClass);
		// 4������������Ϣ������SessionFactory����
		SessionFactory sessionFactory = conf.buildSessionFactory();
	}

}
