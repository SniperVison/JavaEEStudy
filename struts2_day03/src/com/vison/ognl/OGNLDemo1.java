package com.vison.ognl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.vison.bean.User;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

//��ʾOGNL(������ͼ��������,����:${user.add.name})�﷨
public class OGNLDemo1
{
	// ������ʾ
	// 1--ȡ��root�е�����ֵ
	@Test
	public void fun1() throws OgnlException
	{
		// ׼��OGNLContext
		// ׼��Root
		User rootUser = new User("jingjing", 21);
		// ׼��Context
		Map<String, User> context = new HashMap<>();
		context.put("user1", new User("vison", 22));
		context.put("user2", new User("wenwen", 21));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		// ��дOGNL

		// ȡ��root��user�����name����(�ڵ�һ��ֵ�У�ֱ�������Ե����Ƽ���)
		String name = (String) Ognl.getValue("name", oc, oc.getRoot());

		// ȡ��root��user�����age����
		Integer age = (Integer) Ognl.getValue("age", oc, oc.getRoot());
		System.out.println(name);
		System.out.println(age);
	}
	// -----------------------------------------------------------------------------------------------------------------

	// 2--ȡ��context�е�����ֵ
	@Test
	public void fun2() throws OgnlException
	{
		// ׼��OGNLContext
		// ׼��Root
		User rootUser = new User("jingjing", 21);
		// ׼��Context
		Map<String, User> context = new HashMap<>();
		context.put("user1", new User("vison", 22));
		context.put("user2", new User("wenwen", 21));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		// ��дOGNL

		// ȡ��context��user1�����name����(����"#"��ʾȥcontext�е�ֵ)
		String name1 = (String) Ognl.getValue("#user1.name", oc, oc.getRoot());

		// ȡ��context��user1�����age����
		Integer age1 = (Integer) Ognl.getValue("#user1.age", oc, oc.getRoot());
		System.out.println(name1);
		System.out.println(age1);

		// ȡ��context��user2�����name����(����"#"��ʾȥcontext�е�ֵ)
		String name2 = (String) Ognl.getValue("#user2.name", oc, oc.getRoot());

		// ȡ��context��user2�����age����
		Integer age2 = (Integer) Ognl.getValue("#user2.age", oc, oc.getRoot());
		System.out.println(name2);
		System.out.println(age2);
	}
	// -----------------------------------------------------------------------------------------------------------------

	// 3--Ϊ���Ը�ֵ
	@Test
	public void fun3() throws OgnlException
	{
		// ׼��OGNLContext
		// ׼��Root
		User rootUser = new User("jingjing", 21);
		// ׼��Context
		Map<String, User> context = new HashMap<>();
		context.put("user1", new User("vison", 22));
		context.put("user2", new User("wenwen", 21));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		// ��дOGNL

		// Ϊroot��rootUser�����name���Ը�ֵ
		Ognl.getValue("name='shenshen'", oc, oc.getRoot());
		String rootUserName = (String) Ognl.getValue("name", oc, oc.getRoot());
		System.out.println(rootUserName);

		// Ϊcontext��user1�����name���Ը�ֵ
		// ��ʽһ��
		Ognl.getValue("#user1.name='liushishi'", oc, oc.getRoot());
		String user1Name = (String) Ognl.getValue("#user1.name", oc, oc.getRoot());
		System.out.println(user1Name);
		// ��ʽ����ʹ�ô����ķ�ʽ��ֵ��ȡֵ
		String user1Name2 = (String) Ognl.getValue("#user1.name='liushishi',#user1.name", oc, oc.getRoot());
		System.out.println(user1Name);
	}

	// -----------------------------------------------------------------------------------------------------------------

	// 4--���÷���ȡ��/���ö��������
	@Test
	public void fun4() throws OgnlException
	{
		// ׼��OGNLContext
		// ׼��Root
		User rootUser = new User("jingjing", 21);
		// ׼��Context
		Map<String, User> context = new HashMap<>();
		context.put("user1", new User("vison", 22));
		context.put("user2", new User("wenwen", 21));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);

		// ��дOGNL
		// -----------------------------------------------------------------------------------------------------------------
		// ��ͨ�����÷����ķ�ʽ����ȡ����root��rootUser�����name����
		String rootUserName = (String) Ognl.getValue("getName()", oc, oc.getRoot());
		System.out.println(rootUserName);

		// ��ʽһ:��ͨ�����÷����ķ�ʽ�������á�root��rootUser�����name����
		Ognl.getValue("setName('yingying')", oc, oc.getRoot());
		String rootUserName2 = (String) Ognl.getValue("getName()", oc, oc.getRoot());
		System.out.println(rootUserName2);

		// ��ʽ��:(ͨ�������ķ�ʽ)��ͨ�����÷����ķ�ʽ�������á�root��rootUser�����name����
		String rootUserName3 = (String) Ognl.getValue("setName('yingying'),getName()", oc, oc.getRoot());
		System.out.println(rootUserName3);

		// -----------------------------------------------------------------------------------------------
		// ��ͨ�����÷����ķ�ʽ����ȡ����context��user1�����name����
		String user1Name = (String) Ognl.getValue("#user1.getName()", oc, oc.getRoot());
		System.out.println(user1Name);

		// ��ʽһ: ��ͨ�����÷����ķ�ʽ�������á�context��user1�����name����
		Ognl.getValue("#user1.setName('yali')", oc, oc.getRoot());
		String user1Name2 = (String) Ognl.getValue("#user1.getName()", oc, oc.getRoot());
		System.out.println(user1Name2);

		// ��ʽ��(ͨ�������ķ�ʽ): ��ͨ�����÷����ķ�ʽ�������á�context��user1�����name����
		String user1Name3 = (String) Ognl.getValue("#user1.setName('yali'),#user1.getName()", oc, oc.getRoot());
		System.out.println(user1Name3);
	}
	// -----------------------------------------------------------------------------------------------------------------

	// 5--���þ�̬����ȡ��/���ö��������
	@Test
	public void fun5() throws OgnlException
	{
		// ׼��OGNLContext
		// ׼��Root
		User rootUser = new User("jingjing", 21);
		// ׼��Context
		Map<String, User> context = new HashMap<>();
		context.put("user1", new User("vison", 22));
		context.put("user2", new User("wenwen", 21));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);

		// ��дOGNL
		// -----------------------------------------------------------------------------------------------------------------
		// ���þ�̬����
		String name = (String) Ognl.getValue("@com.vison.ognl.StaticUtils@echo('hello,vison!')", oc, oc.getRoot());
		Double PI = (Double) Ognl.getValue("@java.lang.Math@PI", oc, oc.getRoot());
		System.out.println(PI);
		System.out.println(name);
	}

	// ognl��������--list|map
	@Test
	public void fun6() throws OgnlException
	{
		// ׼��OGNLContext
		// ׼��Root
		User rootUser = new User("jingjing", 21);
		// ׼��Context
		Map<String, User> context = new HashMap<>();
		context.put("user1", new User("vison", 22));
		context.put("user2", new User("wenwen", 21));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);

		// ��дOGNL
		// ����list����
		Integer size = (Integer) Ognl.getValue("{'jerry','tom','vison','rose'}.size()", oc, oc.getRoot());
		System.out.println(size);
		String name = (String) Ognl.getValue("{'jerry','tom','vison','rose'}[1]", oc, oc.getRoot());
		System.out.println(name);
		String name2 = (String) Ognl.getValue("{'jerry','tom','vison','rose'}.get(1)", oc, oc.getRoot());
		System.out.println(name2);

		// -----------------------------------------------------------------------------------------------------------------
		// ����map(����ġ�#���������ȡcontext��������;��һ���ģ������Ǵ���Map)
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
