package com.vison.springmvc.pojo;

//这就是包装POJO类
public class QueryVo
{
	// 商品
	public Items items;

	Integer[] ids;// 使用包装类进行参数绑定之数组的实现

	public Items getItems()
	{
		return items;
	}

	public void setItems(Items items)
	{
		this.items = items;
	}

}
