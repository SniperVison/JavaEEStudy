package com.vison.attributelistener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/*HttpSession和ServletContext对象属性的监听与这个同理*/
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener
{

	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0)
	{
		System.out.println("ServletRequest添加属性了");
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0)
	{
		System.out.println("ServletRequest移除属性了");

	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0)// 参数代表事件源对象
	{
		System.out.println("ServletRequest替换属性了");
		// System.out.println(arg0.getName() + "\t" + arg0.getValue());
	}

}
