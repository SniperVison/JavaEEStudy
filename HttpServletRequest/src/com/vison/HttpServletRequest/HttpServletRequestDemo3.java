package com.vison.HttpServletRequest;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.vison.entity.User;

//ע�⣺ʹ��������ʱ��ǵã���register.html�ļ�action��ֵ��Ϊdemo3������������
public class HttpServletRequestDemo3 extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// ���߷�������Ҫʹ��ʲô���룬ע�������ʹ�õ���ʲô���봫�ݹ����ľ���ʲô����
		request.setCharacterEncoding("UTF-8");
		// ��ȡ�����ݵķ���һ���ȽϷ���
		// getData(request);
		// ��ȡ�����ݵķ�����
		// getData2(request);
		// ��ȡ�����ݵķ�����������������ǳ�ʵ��
		// getData3(request);
		/*��ȡ�����ݵķ����ģ�����jar����commons-beanutils-1.9.3.jar
		 &&commons-logging-1.2.jar     �ǳ�ʵ��*/
		// ��ʵ���ַ������ǵõ�һ���Ľ���ģ�ֻ�ǴӸ��ӵ������ѣ���1->4�𽥴����໯������������
		try
		{
			User u = new User();
			System.out.println("��װ����ǰ�� " + u);
			BeanUtils.populate(u, request.getParameterMap());
			System.out.println("��װ���ݺ� " + u);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public void getData3(HttpServletRequest request)
	{
		try
		{
			User u = new User();
			System.out.println("��װ����ǰ�� " + u);
			Map<String, String[]> map = request.getParameterMap();
			for (Map.Entry<String, String[]> m : map.entrySet())
			{
				String name = m.getKey();
				String[] value = m.getValue();
				// ����һ�����������������÷��书�ܣ���ȡUser�������getter&setter����
				PropertyDescriptor pd = new PropertyDescriptor(name, User.class/*����User������*/);
				// �õ�setter����,���书��
				Method setter = pd.getWriteMethod();
				if (value.length == 1)
				{
					setter.invoke(u, value[0]);// ��һ��ֵ�ı�����ֵ
				} else
				{
					setter.invoke(u, (Object) value);// ����ڸ���ѡ��ֵ
				}
				System.out.println("��װ���ݺ� " + u);
			}
		} catch (Exception e)
		{
			e.printStackTrace();

		}
	}

	public void getData2(HttpServletRequest request)
	{
		// ����������ȡ���еı�name������
		Enumeration names = request.getParameterNames();
		while (names.hasMoreElements())
		{
			String name = (String) names.nextElement();// �õ�ÿһ��name��
			String[] value = request.getParameterValues(name);// ����name�����õ�����valueֵ
			for (int i = 0; value != null & i < value.length; i++)
			{
				System.out.println(name + "	" + value[i]);
			}
		}
	}

	public void getData(HttpServletRequest request)
	{
		// ���ݱ���name���Ե�������ȡvalue���Ե�ֵ�ķ���
		String username = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String[] hobby = request.getParameterValues("hobby");
		String city = request.getParameter("city");
		System.out.println(username);
		System.out.println(pwd);
		System.out.println(sex);
		for (int i = 0; hobby != null && i < hobby.length; i++)
			System.out.println(hobby[i]);
		System.out.println(city);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
