package com.vison.dao;

import com.vison.domain.User;

public interface UserDao
{
	// ���ݵ�¼���Ʒ���User
	User getByUserCode(String user_code);

}
