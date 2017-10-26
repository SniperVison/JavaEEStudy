package com.itheima.demo3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {


	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {
		//�鿴�������еķ������� ����@MyTest��ִ���ĸ�����
		//test1();
		Class clazz = SomeDaoImpl.class;
		Method[] methods = clazz.getMethods();
		for (Method m : methods) {
			//�õ���ǰ�����ϵ�ע�����
			MyTest myTest = m.getAnnotation(MyTest.class);
			if(myTest!=null){//�����ǰ��������@MyTestע��
				long timeout = myTest.timeout();
				if(timeout<0){//��ʾ����Ҫ����
					m.invoke(clazz.newInstance(), null);
				}else{//��Ҫ����
					long l1 = System.nanoTime();//�õ�����
					m.invoke(clazz.newInstance(), null);
					long l2 = System.nanoTime();//�õ�����
					if((l2-l1)>timeout){
						System.out.println(m.getName()+"������ʱ��");
					}
				}
			}
			
			/*if(myTest==null){//���û��ע��,������ִ��ʱ��
				System.out.println("aaaaaaaaaaa");
				m.invoke(clazz.newInstance(), null);
			}else{
				long timeout = myTest.timeout();//�õ�ע�������ֵ
				long l1 = System.nanoTime();//�õ�����
				m.invoke(clazz.newInstance(), null);
				long l2 = System.nanoTime();//�õ�����
				if((l2-l1)>timeout){
					System.out.println(m.getName()+"������ʱ��");
				}
			}*/
		}
		
	}

	private static void test1() throws IllegalAccessException,
			InvocationTargetException, InstantiationException {
		//�õ�Ҫִ�е����Class����
		Class clazz = SomeDaoImpl.class;
		//�õ����еķ���,���������к͸����е����й����ķ���
		Method[] methods = clazz.getMethods();
		//�������з���
		for (Method m : methods) {
			//�жϵ�ǰ�������Ƿ���@MyTestע��
			boolean isExistsAnno = m.isAnnotationPresent(MyTest.class);
//			System.out.println(m.getName()+"��ǰ�����Ƿ���ע�⣺"+isExistsAnno);
			if(m.isAnnotationPresent(MyTest.class)){
				
				m.invoke(clazz.newInstance(), null);
				
			}
			
		}
	}

}
