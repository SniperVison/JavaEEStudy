package com.vison.attributelistener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/*HttpSession��ServletContext�������Եļ��������ͬ��*/
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener
{

	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0)
	{
		System.out.println("ServletRequest���������");
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0)
	{
		System.out.println("ServletRequest�Ƴ�������");

	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0)// ���������¼�Դ����
	{
		System.out.println("ServletRequest�滻������");
		// System.out.println(arg0.getName() + "\t" + arg0.getValue());
	}

}
