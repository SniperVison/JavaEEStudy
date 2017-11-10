package com.vison.dao;

public interface AccountDao
{
	// ¼ÓÇ®
	void addMoney(Integer id, Double money);

	// ¿ÛÇ®
	void decreaseMoney(Integer id, Double money);
}
