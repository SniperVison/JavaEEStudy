package com.vison.ognl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.vison.bean.User;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

//显示OGNL(对象视图导航语言,例如:${user.add.name})语法
public class OGNLDemo1
{
	// 基本演示
	// 1--取出root中的属性值
	@Test
	public void fun1() throws OgnlException
	{
		// 准备OGNLContext
		// 准备Root
		User rootUser = new User("jingjing", 21);
		// 准备Context
		Map<String, User> context = new HashMap<>();
		context.put("user1", new User("vison", 22));
		context.put("user2", new User("wenwen", 21));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		// 书写OGNL

		// 取出root中user对象的name属性(在第一个值中，直接填属性的名称即可)
		String name = (String) Ognl.getValue("name", oc, oc.getRoot());

		// 取出root中user对象的age属性
		Integer age = (Integer) Ognl.getValue("age", oc, oc.getRoot());
		System.out.println(name);
		System.out.println(age);
	}
	// -----------------------------------------------------------------------------------------------------------------

	// 2--取出context中的属性值
	@Test
	public void fun2() throws OgnlException
	{
		// 准备OGNLContext
		// 准备Root
		User rootUser = new User("jingjing", 21);
		// 准备Context
		Map<String, User> context = new HashMap<>();
		context.put("user1", new User("vison", 22));
		context.put("user2", new User("wenwen", 21));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		// 书写OGNL

		// 取出context中user1对象的name属性(加上"#"表示去context中的值)
		String name1 = (String) Ognl.getValue("#user1.name", oc, oc.getRoot());

		// 取出context中user1对象的age属性
		Integer age1 = (Integer) Ognl.getValue("#user1.age", oc, oc.getRoot());
		System.out.println(name1);
		System.out.println(age1);

		// 取出context中user2对象的name属性(加上"#"表示去context中的值)
		String name2 = (String) Ognl.getValue("#user2.name", oc, oc.getRoot());

		// 取出context中user2对象的age属性
		Integer age2 = (Integer) Ognl.getValue("#user2.age", oc, oc.getRoot());
		System.out.println(name2);
		System.out.println(age2);
	}
	// -----------------------------------------------------------------------------------------------------------------

	// 3--为属性赋值
	@Test
	public void fun3() throws OgnlException
	{
		// 准备OGNLContext
		// 准备Root
		User rootUser = new User("jingjing", 21);
		// 准备Context
		Map<String, User> context = new HashMap<>();
		context.put("user1", new User("vison", 22));
		context.put("user2", new User("wenwen", 21));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		// 书写OGNL

		// 为root中rootUser对象的name属性赋值
		Ognl.getValue("name='shenshen'", oc, oc.getRoot());
		String rootUserName = (String) Ognl.getValue("name", oc, oc.getRoot());
		System.out.println(rootUserName);

		// 为context中user1对象的name属性赋值
		// 方式一：
		Ognl.getValue("#user1.name='liushishi'", oc, oc.getRoot());
		String user1Name = (String) Ognl.getValue("#user1.name", oc, oc.getRoot());
		System.out.println(user1Name);
		// 方式二：使用串联的方式赋值，取值
		String user1Name2 = (String) Ognl.getValue("#user1.name='liushishi',#user1.name", oc, oc.getRoot());
		System.out.println(user1Name);
	}

	// -----------------------------------------------------------------------------------------------------------------

	// 4--调用方法取出/设置对象的属性
	@Test
	public void fun4() throws OgnlException
	{
		// 准备OGNLContext
		// 准备Root
		User rootUser = new User("jingjing", 21);
		// 准备Context
		Map<String, User> context = new HashMap<>();
		context.put("user1", new User("vison", 22));
		context.put("user2", new User("wenwen", 21));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);

		// 书写OGNL
		// -----------------------------------------------------------------------------------------------------------------
		// “通过调用方法的方式”【取出】root中rootUser对象的name属性
		String rootUserName = (String) Ognl.getValue("getName()", oc, oc.getRoot());
		System.out.println(rootUserName);

		// 方式一:“通过调用方法的方式”【设置】root中rootUser对象的name属性
		Ognl.getValue("setName('yingying')", oc, oc.getRoot());
		String rootUserName2 = (String) Ognl.getValue("getName()", oc, oc.getRoot());
		System.out.println(rootUserName2);

		// 方式二:(通过串联的方式)“通过调用方法的方式”【设置】root中rootUser对象的name属性
		String rootUserName3 = (String) Ognl.getValue("setName('yingying'),getName()", oc, oc.getRoot());
		System.out.println(rootUserName3);

		// -----------------------------------------------------------------------------------------------
		// “通过调用方法的方式”【取出】context中user1对象的name属性
		String user1Name = (String) Ognl.getValue("#user1.getName()", oc, oc.getRoot());
		System.out.println(user1Name);

		// 方式一: “通过调用方法的方式”【设置】context中user1对象的name属性
		Ognl.getValue("#user1.setName('yali')", oc, oc.getRoot());
		String user1Name2 = (String) Ognl.getValue("#user1.getName()", oc, oc.getRoot());
		System.out.println(user1Name2);

		// 方式二(通过串联的方式): “通过调用方法的方式”【设置】context中user1对象的name属性
		String user1Name3 = (String) Ognl.getValue("#user1.setName('yali'),#user1.getName()", oc, oc.getRoot());
		System.out.println(user1Name3);
	}
	// -----------------------------------------------------------------------------------------------------------------

	// 5--调用静态方法取出/设置对象的属性
	@Test
	public void fun5() throws OgnlException
	{
		// 准备OGNLContext
		// 准备Root
		User rootUser = new User("jingjing", 21);
		// 准备Context
		Map<String, User> context = new HashMap<>();
		context.put("user1", new User("vison", 22));
		context.put("user2", new User("wenwen", 21));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);

		// 书写OGNL
		// -----------------------------------------------------------------------------------------------------------------
		// 调用静态方法
		String name = (String) Ognl.getValue("@com.vison.ognl.StaticUtils@echo('hello,vison!')", oc, oc.getRoot());
		Double PI = (Double) Ognl.getValue("@java.lang.Math@PI", oc, oc.getRoot());
		System.out.println(PI);
		System.out.println(name);
	}

	// ognl创建对象--list|map
	@Test
	public void fun6() throws OgnlException
	{
		// 准备OGNLContext
		// 准备Root
		User rootUser = new User("jingjing", 21);
		// 准备Context
		Map<String, User> context = new HashMap<>();
		context.put("user1", new User("vison", 22));
		context.put("user2", new User("wenwen", 21));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);

		// 书写OGNL
		// 创建list对象
		Integer size = (Integer) Ognl.getValue("{'jerry','tom','vison','rose'}.size()", oc, oc.getRoot());
		System.out.println(size);
		String name = (String) Ognl.getValue("{'jerry','tom','vison','rose'}[1]", oc, oc.getRoot());
		System.out.println(name);
		String name2 = (String) Ognl.getValue("{'jerry','tom','vison','rose'}.get(1)", oc, oc.getRoot());
		System.out.println(name2);

		// -----------------------------------------------------------------------------------------------------------------
		// 创建map(这里的“#”跟上面的取context的属性用途不一样的，这里是代表Map)
		Integer mapSize = (Integer) Ognl.getValue("#{'name':'jerry','age':18}.size()", oc, oc.getRoot());
		System.out.println(mapSize);
		String mapName = (String) Ognl.getValue("#{'name':'jerry','age':18}['name']", oc, oc.getRoot());
		System.out.println(mapName);
		String mapName2 = (String) Ognl.getValue("#{'name':'jerry','age':18}.get('name')", oc, oc.getRoot());
		System.out.println(mapName2);
		Integer mapAge = (Integer) Ognl.getValue("#{'name':'jerry','age':18}.get('age')", oc, oc.getRoot());
		System.out.println(mapAge);
		Integer mapAge2 = (Integer) Ognl.getValue("#{'name':'jerry','age':18}['age']", oc, oc.getRoot());
		System.out.println(mapAge2);

	}

	// -----------------------------------------------------------------------------------------------------------------
}
