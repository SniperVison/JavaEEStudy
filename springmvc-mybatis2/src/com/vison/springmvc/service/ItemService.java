package com.vison.springmvc.service;

import java.util.List;

import com.vison.springmvc.pojo.Items;

public interface ItemService
{
	// ��ѯ��Ʒ�б�
	List<Items> selectItemList();

	Items selectItemsById(Integer id);

	// �޸�
	void updateItemsByid(Items items);
}
