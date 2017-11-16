package com.vison.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.vison.springmvc.exception.MessageException;
import com.vison.springmvc.pojo.Items;
import com.vison.springmvc.service.ItemService;

@Controller
public class ItemController
{
	// @RequestMapping(value="/item")//在类名上面添加这个注解可以窄化路径即，提取下面action的前缀出来，并在使用的时候自动加上这个路径
	// @RequestMapping(value="xxx.action",method=HttpMethod.POST)//限定提交方法
	// @RequestMapping(value="xxx.action",method={HttpMethod.POST,HttpMethod.POST})//限定多种提交方法
	// @RequestMapping(value={"itemList.action","itemKKK.action"})这种是多请求方式，即这两个action都能使用
	@Autowired
	private ItemService itemService;

	/*Controller层方法返回值详解*/
	// 1、ModeAndView 无敌的 带着数据 返回视图路径 ，不推荐使用
	// 2、String 返回视图路径 ,model带数据 官方推荐此种方式，符合解耦思想（数据，视图，分离，MVC）
	/* 3、void(ajax请求时，非常合适【异步请求】)
	 :model带数据,request带视图路径,因为ajax只需要返回数据，不需要视图。需要用到Json格式数据*/

	/*Controller方法返回值*/
	// 重定向 return "redirect:/itemString.action";
	// 内部转发 return "forward://itemString.action";

	// 入门程序一:跳转到页面(url:http://localhost:8080/springmvc_day01/itemList.action)
	// 方法一:使用ModelAndView
	@RequestMapping(value = "/itemList.action")
	public ModelAndView itemList() throws MessageException
	{

		try
		{
			// int i = 1 / 0;用于测试异常处理器之自定义异常
			// 从mysql中查询
			List<Items> list = itemService.selectItemList();
			ModelAndView mav = new ModelAndView();
			// 数据
			mav.addObject("itemList", list);
			// 在springmvc配置了视图解析器及其前后缀
			mav.setViewName("itemList");
			return mav;
		} catch (Exception e)
		{
			String msg = e.getMessage();
			throw new MessageException(msg);
		}
	}

	// 方法二:使用String+Model
	/*@RequestMapping(value =
	{ "/itemList.action", "/itemString.action" })
	public String itemList(Model model)
	{
		// 从mysql中查询
		List<Items> list = itemService.selectItemList();
		// Servlet时代
		// request.setAttribute("itemList", list);
		model.addAttribute("itemList", list);// 效果同上，用于返回数据
	
		return "itemList";// 用于返回视图路径
	
	
	}*/

	// 方法三:使用void（model+request）
	/*@RequestMapping(value =
	{ "/itemList.action", "/itemString.action", "/itemVoid.action" })
	public void itemList(Model model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception
	{
		// 从mysql中查询
		List<Items> list = itemService.selectItemList();
		model.addAttribute("itemList", list);// 用于返回数据
		request.getRequestDispatcher("itemList").forward(request, response);// 用于返回视图路径
	}*/

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
	public ModelAndView updateitem(Items items, MultipartFile pictureFile) throws IllegalStateException, IOException// 这里pictureFile这个参数名字一定要对应jsp文件中name的属性值，否则使用@RequestParam注解配置
	{

		// 保存图片到F:\文件上传\pic
		String name = UUID.randomUUID().toString().replace("-", "");
		// 通过引入文件上传的两个jar包（io&upload）获取扩展名
		String extension = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
		File file = new File("F:\\文件上传\\pic\\" + name + "." + extension);
		pictureFile.transferTo(file);

		items.setPic(name + "." + extension);

		// 修改
		itemService.updateItemsByid(items);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:itemList.action?id= " + items.getId());
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

	// 删除多个选项
	@RequestMapping("/deletes.action")
	public ModelAndView deletes(Integer[] ids)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;

	}

	// 使用json数据交互
	@RequestMapping(value = "/json.action")
	// 使用@ResponseBody和@RequestBody就可以既能发送也能接受
	public @ResponseBody Items json(@RequestBody Items items)
	{
		System.out.println(items);
		return items;
	}

	// RestFul风格开发,修改页面
	@RequestMapping(value = "itemEdit/{id}.action")
	public ModelAndView toEditByRestFul(@PathVariable Integer id, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, Model model)
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

	// 转去登录的页面
	@RequestMapping(value = "/login.action", method = RequestMethod.GET)
	public String login(String username)
	{
		return "login";
	}

	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public String login(String username, HttpSession httpSession)
	{
		httpSession.setAttribute("USER_SESSION", username);
		return "redirect:/itemList.action";
	}

}
