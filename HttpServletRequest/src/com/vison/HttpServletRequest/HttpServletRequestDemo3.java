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

//注意：使用这个类的时候记得，把register.html文件action的值改为demo3，否则不能运行
public class HttpServletRequestDemo3 extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 告诉服务器需要使用什么编码，注：浏览器使用的是什么编码传递过来的就是什么编码
		request.setCharacterEncoding("UTF-8");
		// 获取表单数据的方法一，比较繁杂
		// getData(request);
		// 获取表单数据的方法二
		// getData2(request);
		// 获取表单数据的方法三，框架做法，非常实用
		// getData3(request);
		/*获取表单数据的方法四，利用jar包：commons-beanutils-1.9.3.jar
		 &&commons-logging-1.2.jar     非常实用*/
		// 其实四种方法都是得到一样的结果的，只是从复杂到简洁而已，即1->4逐渐代码简洁化，趋向框架做法
		try
		{
			User u = new User();
			System.out.println("封装数据前： " + u);
			BeanUtils.populate(u, request.getParameterMap());
			System.out.println("封装数据后： " + u);
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
			System.out.println("封装数据前： " + u);
			Map<String, String[]> map = request.getParameterMap();
			for (Map.Entry<String, String[]> m : map.entrySet())
			{
				String name = m.getKey();
				String[] value = m.getValue();
				// 创建一个属性描述器，利用反射功能，获取User类里面的getter&setter方法
				PropertyDescriptor pd = new PropertyDescriptor(name, User.class/*反射User整个类*/);
				// 得到setter属性,反射功能
				Method setter = pd.getWriteMethod();
				if (value.length == 1)
				{
					setter.invoke(u, value[0]);// 给一个值的变量赋值
				} else
				{
					setter.invoke(u, (Object) value);// 想关于给复选框赋值
				}
				System.out.println("封装数据后： " + u);
			}
		} catch (Exception e)
		{
			e.printStackTrace();

		}
	}

	public void getData2(HttpServletRequest request)
	{
		// 方法二：获取所有的表单name的名字
		Enumeration names = request.getParameterNames();
		while (names.hasMoreElements())
		{
			String name = (String) names.nextElement();// 得到每一个name名
			String[] value = request.getParameterValues(name);// 根据name名，得到所有value值
			for (int i = 0; value != null & i < value.length; i++)
			{
				System.out.println(name + "	" + value[i]);
			}
		}
	}

	public void getData(HttpServletRequest request)
	{
		// 根据表单中name属性的名，获取value属性的值的方法
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
