package com.vison.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vison.ssm.mapper.BaseDictDao;
import com.vison.ssm.pojo.BaseDict;
import com.vison.ssm.service.BaseDictService;

@Service
// @Transactional
public class BaseDictServiceImpl implements BaseDictService
{
	@Autowired
	private BaseDictDao baseDictDao;

	@Override
	public List<BaseDict> selectBaseDictListByCode(String code)
	{
		return baseDictDao.selectBaseDictListByCode(code);
	}

}
