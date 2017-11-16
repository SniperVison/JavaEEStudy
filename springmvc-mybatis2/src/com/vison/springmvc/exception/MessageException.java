package com.vison.springmvc.exception;

/**
 * �쳣������֮�Զ����쳣
 * 
 * @author Vison
 *
 */
public class MessageException extends Exception
{

	private String message;

	public MessageException(String message)
	{
		super();
		this.message = message;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

}
