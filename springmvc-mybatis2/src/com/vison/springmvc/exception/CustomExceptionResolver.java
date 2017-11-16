package com.vison.springmvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理器的自定义的实现类
 * 
 * @author Vison
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver
{

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception e)
	{
		// 发生异常的地方 Service层 方法 包名+类名+方法名（形参）字符串
		/* 日志: 1、发布tomcat war Eclipse
		 2、发布tomcat 服务器上linux log4j打印日志*/
		ModelAndView mav = new ModelAndView();
		// 判断异常类型
		// 预期异常
		if (e instanceof MessageException)
			mav.addObject("error", ((MessageException) e).getMessage());
		else
		{
			mav.addObject("error", "未知异常");
		}
		mav.setViewName("error");
		return mav;
	}

}
