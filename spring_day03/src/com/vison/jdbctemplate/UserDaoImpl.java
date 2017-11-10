package com.vison.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.vison.bean.User;

//第一种方法，声明一个JdbcTemplate的变量jt，然后生成Setter方法

//使用JDBC模板实现增删改查(spring-jdbc的六大方法)
public class UserDaoImpl implements UserDao
{
	private JdbcTemplate jt;
	// -----------------------------------------------------------------------------------------------------------------

	// 注意：******这里jt的Setter方法一定要写，不要获取不到UserDao的ApplicationContext
	public void setJt(JdbcTemplate jt)
	{
		this.jt = jt;
	}

	// --------------------------------------------------------------------------------------------------------------------------
	// 增
	@Override
	public void save(User u)
	{
		String sql = "insert into t_user values(null,?)";
		jt.update(sql, u.getName());
	}

	// 改
	@Override
	public void update(User u)
	{
		String sql = "update t_user set name=? where id=?";
		jt.update(sql, u.getName(), u.getId());
	}

	// 删
	@Override
	public void delete(Integer id)
	{
		String sql = "delete from t_user where id=?";
		jt.update(sql, id);
	}

	// 查
	@Override
	public User getById(Integer id)
	{
		String sql = "select * from t_user where id=?";
		return jt.queryForObject(sql, new RowMapper<User>()
		{
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException
			{
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				return u;
			}
		}, id);
	}

	// 查
	@Override
	public int getTotalCount()
	{
		String sql = "select count(*) from t_user";
		Integer count = jt.queryForObject(sql, Integer.class);
		return count;
	}

	// 查
	@Override
	public List<User> getAll()
	{
		String sql = "select * from t_user";
		List<User> list = jt.query(sql, new RowMapper<User>()
		{
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException
			{
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				return u;
			}
		});
		return list;
	}
}
