package com.vison.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class UserForm
{/*�˻����������룬��3-8λ����ĸ���<br/>
	���룺�������룬3-8���������<br/>
	ȷ�����룺�������룬�Һ����뱣��һ��<br/>
	���䣺�������룬��Ҫ��������ĸ�ʽ<br/>
	���գ��������룬����yyyy-MM-dd�ĸ�ʽ<br/>*/

	private int id;
	private String username;
	private String password;
	private String repassword;
	private String email;
	private String birthday;
	Map<String, String> msg = new HashMap<String, String>();

	public boolean validate()
	{
		if ("".equals(username))
		{
			msg.put("username", "�˻�����Ϊ�գ�");
		} else if (!username.matches("\\w{3,8}"))
		{
			msg.put("username", "�˻���Ϊ3~8����ĸ���");
		}

		if ("".equals(password))
		{
			msg.put("password", "���벻��Ϊ�գ�");
		} else if (!password.matches("\\d{3,8}"))
		{
			msg.put("password", "����Ϊ3-8���������");
		}
		// ȷ�����뱣��һ��
		if (!repassword.equals(password))
		{
			msg.put("repassword", "�������벻һ��");
		}
		if ("".equals(email))
		{
			msg.put("email", "���䲻��Ϊ�գ�");
		} else if (!email.matches(
				"\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa|asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|cn|travel|xxx)$\\b"))

		{
			msg.put("email", "�����ʽ����ȷ");
		}
		if ("".equals(birthday))
		{
			msg.put("birthday", "���ղ���Ϊ�գ�");
		} else
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try
			{
				sdf.parse(birthday);
			} catch (ParseException e)
			{
				msg.put("birthday", "���ո�ʽ����ȷ��");
				// e.printStackTrace();
			}
		}
		return msg.isEmpty();// ��map������û������ʱ������true
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getRepassword()
	{
		return repassword;
	}

	public void setRepassword(String repassword)
	{
		this.repassword = repassword;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getBirthday()
	{
		return birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	public Map<String, String> getMsg()
	{
		return msg;
	}

	public void setMsg(Map<String, String> msg)
	{
		this.msg = msg;
	}

}
