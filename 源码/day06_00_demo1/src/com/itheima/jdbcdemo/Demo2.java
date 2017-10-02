package com.itheima.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

//ʹ��JDBC����ʵ�ֲ�ѯ���ݿ����ݣ�����ʾ�ڿ���̨��
public class Demo2 {
	@Test
	public void test1() throws Exception  {
		
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		//��ȡ����Connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "abc");
		//�õ�ִ��sql���Ķ���Statement
		Statement stmt = conn.createStatement();
		//ִ��sql��䣬�����ؽ��
		ResultSet rs = stmt.executeQuery("select id,name,password,email,birthday from users");
		//������ 
		while(rs.next()){ 
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
			System.out.println("-----------------");
		}
		//�ر���Դ
		rs.close();
		stmt.close();
		conn.close();
	}

	@Test
	public void test2() throws Exception{
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		//��ȡ����Connection
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "abc");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", info);
		//�õ�ִ��sql���Ķ���Statement
		Statement stmt = conn.createStatement();
		//ִ��sql��䣬�����ؽ��
		ResultSet rs = stmt.executeQuery("select id,name,password,email,birthday from users");
		//������ 
		while(rs.next()){ 
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
			System.out.println("-----------------");
		}
		//�ر���Դ
		rs.close();
		stmt.close();
		conn.close();
	}
	
	@Test
	public void test3() throws Exception{
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		//��ȡ����Connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06?user=root&password=abc");
		//�õ�ִ��sql���Ķ���Statement
		Statement stmt = conn.createStatement();
		//ִ��sql��䣬�����ؽ��
		ResultSet rs = stmt.executeQuery("select id,name,password,email,birthday from users");
		//������ 
		while(rs.next()){ 
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(rs.getObject(4));
			System.out.println(rs.getObject(5));
			System.out.println("-----------------");
		}
		//�ر���Դ
		rs.close();
		stmt.close();
		conn.close();
	}
	
	@Test
	public void test4() throws Exception{
		//��ȡ����Connection
		Connection conn = null;
		//�õ�ִ��sql���Ķ���Statement
		Statement stmt = null;
		//ִ��sql��䣬�����ؽ��
		ResultSet rs = null;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06?user=root&password=abc");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select id,name,password,email,birthday form users");
			//������ 
			while(rs.next()){ 
				System.out.println(rs.getObject(1));
				System.out.println(rs.getObject(2));
				System.out.println(rs.getObject(3));
				System.out.println(rs.getObject(4));
				System.out.println(rs.getObject(5));
				System.out.println("-----------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر���Դ
			if(rs!=null){
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if(stmt!=null){
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				conn = null;
			}
			
		}
	}
}
