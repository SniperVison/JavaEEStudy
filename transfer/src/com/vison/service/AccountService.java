package com.vison.service;

public interface AccountService
{
	/**
	 * ת��
	 * 
	 * @param fromName
	 *            ת���û�
	 * @param toName
	 *            ת���û�
	 * @param money
	 *            ת�˽��
	 */
	public void transfer(String fromName, String toName, double money);

}
