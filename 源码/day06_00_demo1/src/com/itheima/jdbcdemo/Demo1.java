package com.itheima.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//ʹ��JDBC����ʵ�ֲ�ѯ���ݿ����ݣ�����ʾ�ڿ���̨��
public class Demo1 {

	public static void main(String[] args) throws Exception {
		
	
			//ע������
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			//��ȡ����Connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "abc");
			//�õ�ִ��sequel���Ķ���Statement
			Statement stmt = conn.createStatement();
			//ִ��sql��䣬�����ؽ��
			ResultSet rs = stmt.executeQuery("select password,email,birthday,id,name from users");
			
			//������ 
			while(rs.next()){ 
				System.out.println(rs.getObject("password"));
				System.out.println(rs.getObject("id"));
				System.out.println(rs.getObject("name"));
				System.out.println(rs.getObject("birthday"));
				System.out.println(rs.getObject("email"));
				System.out.println("-----------------");
			}
		
			//�ر���Դ
			rs.close();
			stmt.close();
			conn.close();
			
		
	}

}
