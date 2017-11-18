package com.vison.ssm.mapper;

import java.util.List;

import com.vison.ssm.pojo.BaseDict;

public interface BaseDictDao
{
	// ≤È—Ø
	List<BaseDict> selectBaseDictListByCode(String code);
}
