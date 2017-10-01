package com.vison.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vison.user.User;
import com.vison.util.DBUtils;

public class DoLogin
{
	/**
	 * �����û����������ѯ�û�������Ϣ
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 */
	public User findUser(String name, String pwd)
	{
		Connection conn = null;
		// Statement stmt = null;
		PreparedStatement ppst = null;
		ResultSet rs = null;
		User u = null;
		try
		{
			conn = DBUtils.getConnection();

			// �˴��ᷢ��sqlע�����⣬�������ַ�����ƴ��
			/*
			 * stmt = conn.createStatement(); rs =
			 * stmt.executeQuery("select * from user where name='" + name
			 * +"'and password='" + pwd + "'");
			 */

			// �˴�ʹ��PreparedStatement����ע�����⣬�����ܸ�
			String sql = "select * from user where name=? and password= ?";
			ppst = conn.prepareStatement(sql);
			// Ȼ���?��ֵ
			ppst.setString(1, name);// ��һ��������ʾ������λ�ã�����һ���ʺŵ�λ�ã��������
			ppst.setString(2, pwd);
			rs = ppst.executeQuery();

			if (rs.next())
			{
				u = new User();
				u.setPassword(rs.getString(1));
				u.setID(rs.getInt(2));
				u.setName(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setBirthday(rs.getDate(5));

			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtils.closeAll(rs, ppst, conn);
		}
		return u;

	}
}
