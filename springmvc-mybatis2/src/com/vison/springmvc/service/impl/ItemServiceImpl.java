package com.vison.springmvc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vison.springmvc.dao.ItemsMapper;
import com.vison.springmvc.pojo.Items;
import com.vison.springmvc.service.ItemService;

/**
 * 查询商品信息
 * 
 * @author Vison
 *
 */
@Service
public class ItemServiceImpl implements ItemService
{
	// 查询商品列表
	@Autowired
	private ItemsMapper itemsMapper;

	public List<Items> selectItemList()
	{
		return itemsMapper.selectByExampleWithBLOBs(null);
	}

	public Items selectItemsById(Integer id)
	{
		return itemsMapper.selectByPrimaryKey(id);
	}

	// 修改(参数绑定之pojo)
	public void updateItemsByid(Items items)
	{
		items.setCreatetime(new Date());
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
}
