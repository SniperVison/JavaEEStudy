package com.vison.springmvc.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 转换日期类型的数据
 * 
 * @author Vison
 *
 */

public class DateConverter implements Converter<String, Date>
{

	@Override
	public Date convert(String source)
	{
		try
		{
			if (source != null)
			{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return sdf.parse(source);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
