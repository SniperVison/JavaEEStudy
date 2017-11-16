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
	// @RequestMapping(value="/item")//����������������ע�����խ��·��������ȡ����action��ǰ׺����������ʹ�õ�ʱ���Զ��������·��
	// @RequestMapping(value="xxx.action",method=HttpMethod.POST)//�޶��ύ����
	// @RequestMapping(value="xxx.action",method={HttpMethod.POST,HttpMethod.POST})//�޶������ύ����
	// @RequestMapping(value={"itemList.action","itemKKK.action"})�����Ƕ�����ʽ����������action����ʹ��
	@Autowired
	private ItemService itemService;

	/*Controller�㷽������ֵ���*/
	// 1��ModeAndView �޵е� �������� ������ͼ·�� �����Ƽ�ʹ��
	// 2��String ������ͼ·�� ,model������ �ٷ��Ƽ����ַ�ʽ�����Ͻ���˼�루���ݣ���ͼ�����룬MVC��
	/* 3��void(ajax����ʱ���ǳ����ʡ��첽����)
	 :model������,request����ͼ·��,��Ϊajaxֻ��Ҫ�������ݣ�����Ҫ��ͼ����Ҫ�õ�Json��ʽ����*/

	/*Controller��������ֵ*/
	// �ض��� return "redirect:/itemString.action";
	// �ڲ�ת�� return "forward://itemString.action";

	// ���ų���һ:��ת��ҳ��(url:http://localhost:8080/springmvc_day01/itemList.action)
	// ����һ:ʹ��ModelAndView
	@RequestMapping(value = "/itemList.action")
	public ModelAndView itemList() throws MessageException
	{

		try
		{
			// int i = 1 / 0;���ڲ����쳣������֮�Զ����쳣
			// ��mysql�в�ѯ
			List<Items> list = itemService.selectItemList();
			ModelAndView mav = new ModelAndView();
			// ����
			mav.addObject("itemList", list);
			// ��springmvc��������ͼ����������ǰ��׺
			mav.setViewName("itemList");
			return mav;
		} catch (Exception e)
		{
			String msg = e.getMessage();
			throw new MessageException(msg);
		}
	}

	// ������:ʹ��String+Model
	/*@RequestMapping(value =
	{ "/itemList.action", "/itemString.action" })
	public String itemList(Model model)
	{
		// ��mysql�в�ѯ
		List<Items> list = itemService.selectItemList();
		// Servletʱ��
		// request.setAttribute("itemList", list);
		model.addAttribute("itemList", list);// Ч��ͬ�ϣ����ڷ�������
	
		return "itemList";// ���ڷ�����ͼ·��
	
	
	}*/

	// ������:ʹ��void��model+request��
	/*@RequestMapping(value =
	{ "/itemList.action", "/itemString.action", "/itemVoid.action" })
	public void itemList(Model model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception
	{
		// ��mysql�в�ѯ
		List<Items> list = itemService.selectItemList();
		model.addAttribute("itemList", list);// ���ڷ�������
		request.getRequestDispatcher("itemList").forward(request, response);// ���ڷ�����ͼ·��
	}*/

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
	public ModelAndView updateitem(Items items, MultipartFile pictureFile) throws IllegalStateException, IOException// ����pictureFile�����������һ��Ҫ��Ӧjsp�ļ���name������ֵ������ʹ��@RequestParamע������
	{

		// ����ͼƬ��F:\�ļ��ϴ�\pic
		String name = UUID.randomUUID().toString().replace("-", "");
		// ͨ�������ļ��ϴ�������jar����io&upload����ȡ��չ��
		String extension = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
		File file = new File("F:\\�ļ��ϴ�\\pic\\" + name + "." + extension);
		pictureFile.transferTo(file);

		items.setPic(name + "." + extension);

		// �޸�
		itemService.updateItemsByid(items);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:itemList.action?id= " + items.getId());
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

	// ɾ�����ѡ��
	@RequestMapping("/deletes.action")
	public ModelAndView deletes(Integer[] ids)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;

	}

	// ʹ��json���ݽ���
	@RequestMapping(value = "/json.action")
	// ʹ��@ResponseBody��@RequestBody�Ϳ��Լ��ܷ���Ҳ�ܽ���
	public @ResponseBody Items json(@RequestBody Items items)
	{
		System.out.println(items);
		return items;
	}

	// RestFul��񿪷�,�޸�ҳ��
	@RequestMapping(value = "itemEdit/{id}.action")
	public ModelAndView toEditByRestFul(@PathVariable Integer id, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, Model model)
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

	// תȥ��¼��ҳ��
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
