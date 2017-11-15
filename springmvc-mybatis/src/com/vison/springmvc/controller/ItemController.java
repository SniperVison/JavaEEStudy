package com.vison.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vison.springmvc.pojo.Items;
import com.vison.springmvc.service.ItemService;

@Controller
public class ItemController
{

	@Autowired
	private ItemService itemService;

	// 入门程序一:跳转到页面(url:http://localhost:8080/springmvc_day01/itemList.action)
	@RequestMapping(value = "/itemList.action")
	public ModelAndView itemList()
	{
		// 从mysql中查询
		List<Items> list = itemService.selectItemList();
		ModelAndView mav = new ModelAndView();
		// 数据
		mav.addObject("itemList", list);
		/*		mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		*/

		// 在springmvc配置了视图解析器及其前后缀
		mav.setViewName("itemList");
		return mav;

	}

	// 去修改页面的入参id
	@RequestMapping(value = "/itemEdit.action")
	/*	public ModelAndView toEdit(@RequestParam(value = "id", required = false, defaultValue = "1") Integer iddemo,
				HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model)
		*/
	public ModelAndView toEdit(Integer id, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, Model model)
	{
		// Servlet时代开发
		// String id = request.getParameter("id");
		// 查询一个商品
		// Items items = itemService.selectItemsById(Integer.parseInt(id));

		// 查询一个商品(传入Integer id 可以替换掉上面Servlet用法)
		Items items = itemService.selectItemsById(id);
		/*		 Items items = itemService.selectItemsById(iddemo);测试参数绑定之简单类型（@RequestParam）
		*/
		ModelAndView mav = new ModelAndView();
		// 数据
		mav.addObject("item", items);
		// 在springmvc配置了视图解析器及其前后缀
		mav.setViewName("editItem");
		return mav;

	}

	// 提交修改页面入参为Items对象(参数绑定之pojo)
	@RequestMapping(value = "/updateitem.action")
	public ModelAndView updateitem(Items items)
	{
		// 修改
		itemService.updateItemsByid(items);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}

	// 提交修改页面入参为Items对象(参数绑定之pojo包装类)
	/*	@RequestMapping(value = "/updateitem.action")
		public ModelAndView updateitem(QueryVo vo)
		{
			// 修改(要在editItem.jsp中把item的属性名加上"items.",如id->items.id)
			itemService.updateItemsByid(vo.getItems());
			ModelAndView mav = new ModelAndView();
			mav.setViewName("success");
			return mav;
		}*/

	// 客户端跳转
	@RequestMapping("/jump.action")
	public ModelAndView jump()
	{
		ModelAndView mav = new ModelAndView("redirect:/itemList.action");
		return mav;
	}
}
