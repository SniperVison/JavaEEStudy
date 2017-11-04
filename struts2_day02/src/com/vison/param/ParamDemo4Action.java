package com.vison.param;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

//struts2如何获得参数
//方式4:封装集合类型参数
@SuppressWarnings("serial")
public class ParamDemo4Action extends ActionSupport
{
	// list集合获取
	private List<String> list;

	// Map集合获取
	private Map<String, String> map;

	public String execute() throws Exception
	{
		System.out.println("list: " + list);
		System.out.println("map: " + map);
		return SUCCESS;
	}

	public List<String> getList()
	{
		return list;
	}

	public void setList(List<String> list)
	{
		this.list = list;
	}

	public Map<String, String> getMap()
	{
		return map;
	}

	public void setMap(Map<String, String> map)
	{
		this.map = map;
	}

}
