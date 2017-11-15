package com.vison.springmvc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vison.springmvc.dao.ItemsMapper;
import com.vison.springmvc.pojo.Items;
import com.vison.springmvc.service.ItemService;

/**
 * ��ѯ��Ʒ��Ϣ
 * 
 * @author Vison
 *
 */
@Service
public class ItemServiceImpl implements ItemService
{
	// ��ѯ��Ʒ�б�
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

	// �޸�(������֮pojo)
	public void updateItemsByid(Items items)
	{
		items.setCreatetime(new Date());
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
}
