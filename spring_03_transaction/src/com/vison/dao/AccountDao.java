package com.vison.dao;

public interface AccountDao
{
	// ��Ǯ
	void addMoney(Integer id, Double money);

	// ��Ǯ
	void decreaseMoney(Integer id, Double money);
}
