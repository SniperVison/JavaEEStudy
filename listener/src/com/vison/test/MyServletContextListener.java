package com.vison.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

//com.vison.test这个package是定时销毁过期session的案例
public class MyServletContextListener implements ServletContextListener
{

	@Override
	public void contextInitialized(ServletContextEvent arg0)
	{ // 通过事件源对象得到事件源（ServletContext）
		ServletContext application = arg0.getServletContext();
		// 创建一个List集合存储所有session对象,同时要注意线程安全，即要同步，不然会出现线程并发修改异常
		final List<HttpSession> list = Collections.synchronizedList(new ArrayList<HttpSession>());
		// 将集合放到application域中
		application.setAttribute("sessions", list);
		// 创建一个计时器对象
		Timer t = new Timer();
		t.schedule(new TimerTask()
		{
			@Override
			public void run()
			{
				System.out.println("*****开始扫描*****");
				for (Iterator iterator = list.iterator(); iterator.hasNext();)
				{
					HttpSession session = (HttpSession) iterator.next();
					long time = System.currentTimeMillis() - session.getLastAccessedTime();
					if (time > 5000)// 如果时间大于5000毫秒
					{
						System.out.println(session.getId() + "被移除了");
						session.invalidate();// 销毁session
						// list.remove(session);// 移除集合中的session对象
						iterator.remove();// 使用迭代器的删除才可以，直接使用list的remove方法还是会出现线程并发修改异常的
					}
				}
				/*	for (HttpSession session : list)
					{
						long time = System.currentTimeMillis() - session.getLastAccessedTime();
						if (time > 5000)// 如果时间大于5000毫秒
						{
							session.invalidate();// 销毁session
							list.remove(session);// 移除集合中的session对象
						}
				
					}*/
			}
		}, 2000, 5000);// 2s扫描一次，每隔5s检查一遍是否过期
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{

	}

}
