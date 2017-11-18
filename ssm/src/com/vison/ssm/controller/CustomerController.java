package com.vison.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vison.common.utils.Page;
import com.vison.ssm.pojo.BaseDict;
import com.vison.ssm.pojo.Customer;
import com.vison.ssm.pojo.QueryVo;
import com.vison.ssm.service.BaseDictService;
import com.vison.ssm.service.CustomerService;

/**
 * 客户管理
 * 
 * @author Vison
 *
 */
@Controller
public class CustomerController
{
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	// 注解在 成员变量上
	@Value("${fromType.code}")
	private String fromTypeCode;
	@Value("${industryType.code}")
	private String industryTypeCode;
	@Value("${levelType.code}")
	private String levelTypeCode;

	// 入口
	@RequestMapping(value = "/customer/list.action")
	public String list(QueryVo vo, Model model)
	{
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode(levelTypeCode);
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode(industryTypeCode);
		// 返回数据
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);

		// 通过四个条件，查询分页对象
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		// 返回视图路径
		return "customer";
	}

	// 进入修改页面（ajax），应使用返回值为void的方法
	@RequestMapping(value = "/customer/edit.action")
	public @ResponseBody Customer edit(Integer id)
	{
		return customerService.selectCustomerById(id);
	}
}
