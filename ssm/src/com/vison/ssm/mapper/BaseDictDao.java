package com.vison.ssm.mapper;

import java.util.List;

import com.vison.ssm.pojo.BaseDict;

public interface BaseDictDao
{
	// ��ѯ
	List<BaseDict> selectBaseDictListByCode(String code);
}
