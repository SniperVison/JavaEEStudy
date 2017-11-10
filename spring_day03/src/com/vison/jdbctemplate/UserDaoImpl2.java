package com.vison.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.vison.bean.User;

//�ڶ��ַ�����ֱ�Ӽ̳�JdbcDaoSupport��Ȼ������б��� jt��Ϊsuper.getJdbcTemplate(),Ȼ��Ҳ����Ҫ���ɱ���jt��Setter������

//JdbcDaoSupport�������ӳش���JDBCģ�壬��Ҫ�ֶ�׼��JDBCģ�壬�Ӹ��෽���л�ü��ɣ�����super.getJdbcTemplate()����

//ʹ��JDBCģ��ʵ����ɾ�Ĳ�(spring-jdbc�����󷽷�)
public class UserDaoImpl2 extends JdbcDaoSupport implements UserDao
{

	// private JdbcTemplate jt;//��䲻��д������ jt��Ϊsuper.getJdbcTemplate()
	// ��
	@Override
	public void save(User u)
	{
		String sql = "insert into t_user values(null,?)";
		super.getJdbcTemplate().update(sql, u.getName());
	}

	// ��
	@Override
	public void update(User u)
	{
		String sql = "update t_user set name=? where id=?";
		super.getJdbcTemplate().update(sql, u.getName(), u.getId());
	}

	// ɾ
	@Override
	public void delete(Integer id)
	{
		String sql = "delete from t_user where id=?";
		super.getJdbcTemplate().update(sql, id);
	}

	// ��
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

	// ��
	@Override
	public int getTotalCount()
	{
		String sql = "select count(*) from t_user";
		Integer count = super.getJdbcTemplate().queryForObject(sql, Integer.class);
		return count;
	}

	// ��
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
