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
 * �ͻ�����
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
	// ע���� ��Ա������
	@Value("${fromType.code}")
	private String fromTypeCode;
	@Value("${industryType.code}")
	private String industryTypeCode;
	@Value("${levelType.code}")
	private String levelTypeCode;

	// ���
	@RequestMapping(value = "/customer/list.action")
	public String list(QueryVo vo, Model model)
	{
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode(levelTypeCode);
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode(industryTypeCode);
		// ��������
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);

		// ͨ���ĸ���������ѯ��ҳ����
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		// ������ͼ·��
		return "customer";
	}

	// �����޸�ҳ�棨ajax����Ӧʹ�÷���ֵΪvoid�ķ���
	@RequestMapping(value = "/customer/edit.action")
	public @ResponseBody Customer edit(Integer id)
	{
		return customerService.selectCustomerById(id);
	}
}
