package com.itheima.demo2;

import java.util.Date;

//����һ��ע����
public @interface MyAnnotation {
	
	int age() default 0;
	
	String name() default "";
	
	String sex() default "";
	
//	String value();
	String[] value();
	
//	MyAnno anno();
	
//	Color color();
}
