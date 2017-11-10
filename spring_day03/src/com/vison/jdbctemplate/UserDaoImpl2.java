package com.vison.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.vison.bean.User;

//第二种方法，直接继承JdbcDaoSupport，然后把所有变量 jt改为super.getJdbcTemplate(),然后也不需要生成变量jt的Setter方法了

//JdbcDaoSupport根据连接池创建JDBC模板，不要手动准备JDBC模板，从父类方法中获得即可（即“super.getJdbcTemplate()”）

//使用JDBC模板实现增删改查(spring-jdbc的六大方法)
public class UserDaoImpl2 extends JdbcDaoSupport implements UserDao
{

	// private JdbcTemplate jt;//这句不用写，变量 jt改为super.getJdbcTemplate()
	// 增
	@Override
	public void save(User u)
	{
		String sql = "insert into t_user values(null,?)";
		super.getJdbcTemplate().update(sql, u.getName());
	}

	// 改
	@Override
	public void update(User u)
	{
		String sql = "update t_user set name=? where id=?";
		super.getJdbcTemplate().update(sql, u.getName(), u.getId());
	}

	// 删
	@Override
	public void delete(Integer id)
	{
		String sql = "delete from t_user where id=?";
		super.getJdbcTemplate().update(sql, id);
	}

	// 查
	@Override
	public User getById(Integer id)
	{
		String sql = "select * from t_user where id=?";
		return super.getJdbcTemplate().queryForObject(sql, new RowMapper<User>()
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
		Integer count = super.getJdbcTemplate().queryForObject(sql, Integer.class);
		return count;
	}

	// 查
	@Override
	public List<User> getAll()
	{
		String sql = "select * from t_user";
		List<User> list = super.getJdbcTemplate().query(sql, new RowMapper<User>()
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
