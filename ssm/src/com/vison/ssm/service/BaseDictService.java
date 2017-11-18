package com.vison.ssm.service;

import java.util.List;

import com.vison.ssm.pojo.BaseDict;

public interface BaseDictService
{
	// ≤È—Ø
	List<BaseDict> selectBaseDictListByCode(String code);

}
