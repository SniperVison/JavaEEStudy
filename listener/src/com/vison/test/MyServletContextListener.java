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

//com.vison.test���package�Ƕ�ʱ���ٹ���session�İ���
public class MyServletContextListener implements ServletContextListener
{

	@Override
	public void contextInitialized(ServletContextEvent arg0)
	{ // ͨ���¼�Դ����õ��¼�Դ��ServletContext��
		ServletContext application = arg0.getServletContext();
		// ����һ��List���ϴ洢����session����,ͬʱҪע���̰߳�ȫ����Ҫͬ������Ȼ������̲߳����޸��쳣
		final List<HttpSession> list = Collections.synchronizedList(new ArrayList<HttpSession>());
		// �����Ϸŵ�application����
		application.setAttribute("sessions", list);
		// ����һ����ʱ������
		Timer t = new Timer();
		t.schedule(new TimerTask()
		{
			@Override
			public void run()
			{
				System.out.println("*****��ʼɨ��*****");
				for (Iterator iterator = list.iterator(); iterator.hasNext();)
				{
					HttpSession session = (HttpSession) iterator.next();
					long time = System.currentTimeMillis() - session.getLastAccessedTime();
					if (time > 5000)// ���ʱ�����5000����
					{
						System.out.println(session.getId() + "���Ƴ���");
						session.invalidate();// ����session
						// list.remove(session);// �Ƴ������е�session����
						iterator.remove();// ʹ�õ�������ɾ���ſ��ԣ�ֱ��ʹ��list��remove�������ǻ�����̲߳����޸��쳣��
					}
				}
				/*	for (HttpSession session : list)
					{
						long time = System.currentTimeMillis() - session.getLastAccessedTime();
						if (time > 5000)// ���ʱ�����5000����
						{
							session.invalidate();// ����session
							list.remove(session);// �Ƴ������е�session����
						}
				
					}*/
			}
		}, 2000, 5000);// 2sɨ��һ�Σ�ÿ��5s���һ���Ƿ����
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{

	}

}
