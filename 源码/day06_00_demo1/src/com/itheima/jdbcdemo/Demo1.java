package com.itheima.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//使用JDBC技术实现查询数据库数据，并显示在控制台中
public class Demo1 {

	public static void main(String[] args) throws Exception {
		
	
			//注册驱动
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			//获取连接Connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "abc");
			//得到执行sequel语句的对象Statement
			Statement stmt = conn.createStatement();
			//执行sql语句，并返回结果
			ResultSet rs = stmt.executeQuery("select password,email,birthday,id,name from users");
			
			//处理结果 
			while(rs.next()){ 
				System.out.println(rs.getObject("password"));
				System.out.println(rs.getObject("id"));
				System.out.println(rs.getObject("name"));
				System.out.println(rs.getObject("birthday"));
				System.out.println(rs.getObject("email"));
				System.out.println("-----------------");
			}
		
			//关闭资源
			rs.close();
			stmt.close();
			conn.close();
			
		
	}

}
