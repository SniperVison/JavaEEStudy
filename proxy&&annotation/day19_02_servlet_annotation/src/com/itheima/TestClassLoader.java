package com.itheima;

import com.sun.crypto.provider.AESCipher;

public class TestClassLoader {
	public static void main(String[] args) {
		/*ClassLoader cl = KeyName.class.getClassLoader();
		System.out.println(cl);*/
		/* ClassLoader cl = AESCipher.class.getClassLoader();
		 System.out.println(cl);*/
		ClassLoader cl = Student.class.getClassLoader();
		System.out.println(cl);
	}
}
