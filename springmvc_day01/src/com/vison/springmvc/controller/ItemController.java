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

	// 入门程序一:跳转到页面(url:http://localhost:8080/springmvc_day01//item/itemList.action)
	@RequestMapping(value = "/item/itemList.action")
	public ModelAndView itemList()
	{
		// 创建页面需要显示的商品数据
		List<Items> list = new ArrayList<Items>();
		list.add(new Items(1, "1华为 荣耀8", 2399f, new Date(), "质量好！1"));
		list.add(new Items(2, "2华为 荣耀8", 2399f, new Date(), "质量好！2"));
		list.add(new Items(3, "3华为 荣耀8", 2399f, new Date(), "质量好！3"));
		list.add(new Items(4, "4华为 荣耀8", 2399f, new Date(), "质量好！4"));
		list.add(new Items(5, "5华为 荣耀8", 2399f, new Date(), "质量好！5"));
		list.add(new Items(6, "6华为 荣耀8", 2399f, new Date(), "质量好！6"));
		ModelAndView mav = new ModelAndView();
		// 数据
		mav.addObject("itemList", list);
		/*		mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		*/

		// 在springmvc配置了视图解析器及其前后缀
		mav.setViewName("/itemList");
		return mav;

	}
}
