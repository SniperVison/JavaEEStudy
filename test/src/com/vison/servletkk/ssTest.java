package com.vison.servletkk;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ssTest implements Servlet
{

	public ssTest()
	{
		System.out.println("***********************hello ssTest");

	}

	@Override
	public void init(ServletConfig arg0) throws ServletException
	{
		System.out.println("**********************servlet init£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException
	{
		System.out.println("**********************servlet service£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡");
	}

	@Override
	public void destroy()
	{
		System.out.println("***********************servlet destroy£¡£¡£¡£¡£¡£¡£¡£¡£¡");
	}

	@Override
	public ServletConfig getServletConfig()
	{
		return null;
	}

	@Override
	public String getServletInfo()
	{
		return null;
	}
}
