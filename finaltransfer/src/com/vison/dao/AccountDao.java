package com.vison.dao;

import com.vison.domain.Account;

public interface AccountDao
{
	/**
	 * ת��
	 * 
	 * @param fromName,ת���û�
	 * @param toName,ת���û�
	 * @param money,ת�˽��
	 */
	@Deprecated // ���Ƿ���һ�����ע���ʾ��ʱ��ͬʱ������Dao�����ת���ǲ����ʵ�
	public void updateAccount(String fromName, String toName, double money) throws Exception;

	/**
	 * �����˻���Ϣ�޸Ľ��
	 * 
	 * @param account
	 */
	public void updateAccount(Account account) throws Exception;

	/**
	 * �����û��������˻���Ϣ
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public Account findAccountByName(String name) throws Exception;
}
