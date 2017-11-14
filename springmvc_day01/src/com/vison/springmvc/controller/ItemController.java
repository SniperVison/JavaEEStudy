package com.vison.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vison.springmvc.pojo.Items;

@Controller
public class ItemController
{

	// ���ų���һ:��ת��ҳ��(url:http://localhost:8080/springmvc_day01//item/itemList.action)
	@RequestMapping(value = "/item/itemList.action")
	public ModelAndView itemList()
	{
		// ����ҳ����Ҫ��ʾ����Ʒ����
		List<Items> list = new ArrayList<Items>();
		list.add(new Items(1, "1��Ϊ ��ҫ8", 2399f, new Date(), "�����ã�1"));
		list.add(new Items(2, "2��Ϊ ��ҫ8", 2399f, new Date(), "�����ã�2"));
		list.add(new Items(3, "3��Ϊ ��ҫ8", 2399f, new Date(), "�����ã�3"));
		list.add(new Items(4, "4��Ϊ ��ҫ8", 2399f, new Date(), "�����ã�4"));
		list.add(new Items(5, "5��Ϊ ��ҫ8", 2399f, new Date(), "�����ã�5"));
		list.add(new Items(6, "6��Ϊ ��ҫ8", 2399f, new Date(), "�����ã�6"));
		ModelAndView mav = new ModelAndView();
		// ����
		mav.addObject("itemList", list);
		/*		mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		*/

		// ��springmvc��������ͼ����������ǰ��׺
		mav.setViewName("/itemList");
		return mav;

	}
}
