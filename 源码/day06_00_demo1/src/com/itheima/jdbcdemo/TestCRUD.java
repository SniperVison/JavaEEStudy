package com.itheima.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.itheima.entity.User;


public class TestCRUD {
	
	@Test
	public void testSelect() throws Exception{
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		
		//��ȡ����Connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "abc");
		//�õ�ִ��sql���Ķ���Statement
		Statement stmt = conn.createStatement();
		//ִ��sql��䣬�����ؽ��
		ResultSet rs = stmt.executeQuery("select password,email,birthday,id,name from users");
		List<User> list = new ArrayList<User>();
		//������ 
		while(rs.next()){ 
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setEmail(rs.getString("email"));
			u.setBirthday(rs.getDate("birthday"));
			list.add(u);
		}
		//�ر���Դ
		rs.close();
		stmt.close();
		conn.close();
		
		
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	
	@Test
	public void testSelect1() throws Exception{
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		
		//��ȡ����Connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "abc");
		//�õ�ִ��sql���Ķ���Statement
		Statement stmt = conn.createStatement();
		//ִ��sql��䣬�����ؽ��
		ResultSet rs = stmt.executeQuery("select password,email,birthday,id,name from users");
		List<User> list = new ArrayList<User>();
		
		rs.afterLast();
		rs.previous();
		//������ 
		//while(rs.next()){ 
		User u = new User();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setEmail(rs.getString("email"));
			u.setBirthday(rs.getDate("birthday"));
			list.add(u);
		//}
		//�ر���Դ
		rs.close();
		stmt.close();
		conn.close();
		
		
		
		System.out.println(u);
		
	}
	@Test
	public void testInsert() throws Exception{
				//��������
				Class.forName("com.mysql.jdbc.Driver");
				//��ȡ����Connection
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06?user=root&password=abc");
				//�õ�ִ��sql���Ķ���Statement
				Statement stmt = conn.createStatement();
				//ִ��sql��䣬�����ؽ��
				int i = stmt.executeUpdate("INSERT INTO users VALUES(4,'tom','123','tom@163.com','2015-09-28')");
				if(i>0){
					System.out.println("success");
				}
				
				//�ر���Դ
				stmt.close();
				conn.close();
	}
	
	@Test
	public void testUpdate() throws Exception{
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		//��ȡ����Connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06?user=root&password=abc");
		//�õ�ִ��sql���Ķ���Statement
		Statement stmt = conn.createStatement();
		//ִ��sql��䣬�����ؽ��
		int i = stmt.executeUpdate("UPDATE users SET NAME='jerry',PASSWORD='333',email='jerry@163.com' WHERE id=3");
		if(i>0){
			System.out.println("success"+" �޸���"+i+"��");
		}else{
			System.out.println("�޸���"+i+"��");
		}
		
		//�ر���Դ
		stmt.close();
		conn.close();
		
	}
	
	
	@Test
	public void testDelete() throws Exception{
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		//��ȡ����Connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06?user=root&password=abc");
		//�õ�ִ��sql���Ķ���Statement
		Statement stmt = conn.createStatement();
		//ִ��sql��䣬�����ؽ��
		int i = stmt.executeUpdate("DELETE FROM users WHERE id=4");
		if(i>0){
			System.out.println("success");
		}
		
		//�ر���Դ
		stmt.close();
		conn.close();
		
	}
}
