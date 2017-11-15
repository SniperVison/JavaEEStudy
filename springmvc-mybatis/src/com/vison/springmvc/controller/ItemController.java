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

	// ���ų���һ:��ת��ҳ��(url:http://localhost:8080/springmvc_day01/itemList.action)
	@RequestMapping(value = "/itemList.action")
	public ModelAndView itemList()
	{
		// ��mysql�в�ѯ
		List<Items> list = itemService.selectItemList();
		ModelAndView mav = new ModelAndView();
		// ����
		mav.addObject("itemList", list);
		/*		mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		*/

		// ��springmvc��������ͼ����������ǰ��׺
		mav.setViewName("itemList");
		return mav;

	}

	// ȥ�޸�ҳ������id
	@RequestMapping(value = "/itemEdit.action")
	/*	public ModelAndView toEdit(@RequestParam(value = "id", required = false, defaultValue = "1") Integer iddemo,
				HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model)
		*/
	public ModelAndView toEdit(Integer id, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, Model model)
	{
		// Servletʱ������
		// String id = request.getParameter("id");
		// ��ѯһ����Ʒ
		// Items items = itemService.selectItemsById(Integer.parseInt(id));

		// ��ѯһ����Ʒ(����Integer id �����滻������Servlet�÷�)
		Items items = itemService.selectItemsById(id);
		/*		 Items items = itemService.selectItemsById(iddemo);���Բ�����֮�����ͣ�@RequestParam��
		*/
		ModelAndView mav = new ModelAndView();
		// ����
		mav.addObject("item", items);
		// ��springmvc��������ͼ����������ǰ��׺
		mav.setViewName("editItem");
		return mav;

	}

	// �ύ�޸�ҳ�����ΪItems����(������֮pojo)
	@RequestMapping(value = "/updateitem.action")
	public ModelAndView updateitem(Items items)
	{
		// �޸�
		itemService.updateItemsByid(items);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}

	// �ύ�޸�ҳ�����ΪItems����(������֮pojo��װ��)
	/*	@RequestMapping(value = "/updateitem.action")
		public ModelAndView updateitem(QueryVo vo)
		{
			// �޸�(Ҫ��editItem.jsp�а�item������������"items.",��id->items.id)
			itemService.updateItemsByid(vo.getItems());
			ModelAndView mav = new ModelAndView();
			mav.setViewName("success");
			return mav;
		}*/

	// �ͻ�����ת
	@RequestMapping("/jump.action")
	public ModelAndView jump()
	{
		ModelAndView mav = new ModelAndView("redirect:/itemList.action");
		return mav;
	}
}
