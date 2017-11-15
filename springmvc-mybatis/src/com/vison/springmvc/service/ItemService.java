package com.vison.springmvc.service;

import java.util.List;

import com.vison.springmvc.pojo.Items;

public interface ItemService
{
	// 查询商品列表
	List<Items> selectItemList();

	Items selectItemsById(Integer id);

	// 修改
	void updateItemsByid(Items items);
}
