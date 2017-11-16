package com.vison.springmvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * �쳣���������Զ����ʵ����
 * 
 * @author Vison
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver
{

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception e)
	{
		// �����쳣�ĵط� Service�� ���� ����+����+���������βΣ��ַ���
		/* ��־: 1������tomcat war Eclipse
		 2������tomcat ��������linux log4j��ӡ��־*/
		ModelAndView mav = new ModelAndView();
		// �ж��쳣����
		// Ԥ���쳣
		if (e instanceof MessageException)
			mav.addObject("error", ((MessageException) e).getMessage());
		else
		{
			mav.addObject("error", "δ֪�쳣");
		}
		mav.setViewName("error");
		return mav;
	}

}
