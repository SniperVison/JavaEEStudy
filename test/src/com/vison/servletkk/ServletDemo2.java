package com.vison.servletkk;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo2 extends GenericServlet
{

	public ServletDemo2()
	{
		System.out.println("**********ServletDemo2÷¥––¡À£°£°£°£°£°£°£°£°£°£°£°£°");
	}

	@Override
	public void destroy()
	{
		System.out.println("servletDemo2 destroy!!!!!!!!!!!!!!!!!!!!");
	}

	@Override
	public void init() throws ServletException
	{
		System.out.println("servletDemo2 init!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException
	{
		System.out.println("****************ServletDemo2 service !!!!!!!!!!!!!!!!!!!!!");
	}

}
