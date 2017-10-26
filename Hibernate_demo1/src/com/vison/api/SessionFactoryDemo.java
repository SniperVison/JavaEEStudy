package com.vison.api;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

//SessionFactory����:���ڴ����������ݿ���Ķ���session����Ĺ�����������һ��session����
/*ע�⣺1��SessionFactory���𱣴��ʹ������������Ϣ�������ڴ���Դ�ǳ���
       2��SessionFactory�����̰߳�ȫ�Ķ������
      ##���ۣ���֤��web��Ŀ�У�ֻ����һ��SessionFactory    */
public class SessionFactoryDemo
{
	@Test
	public void fun2()
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
		// 5�����session
		// ��һ���µ�session����
		sessionFactory.openSession();
		// ���һ�����̰߳󶨵�session����
		sessionFactory.getCurrentSession();
	}

}
