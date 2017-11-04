package com.vison.param;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

//struts2��λ�ò���
//��ʽ4:��װ�������Ͳ���
@SuppressWarnings("serial")
public class ParamDemo4Action extends ActionSupport
{
	// list���ϻ�ȡ
	private List<String> list;

	// Map���ϻ�ȡ
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
