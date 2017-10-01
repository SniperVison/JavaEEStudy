package com.vison.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/**
 * Dom4J的代码编写教程网址为：https://dom4j.github.io/ ，里面有详细的书写步骤
 * 
 * @author xiehe
 *
 */
public class TestDom4J
{
	@Test
	public void test01() throws DocumentException
	{
		SAXReader reader = new SAXReader(); // 创建一个XML解析对象
		Document document = reader.read("src/Book.xml");// 把XML文档加载到document对象中（即加载到内存中）
		Element root = document.getRootElement();
		/*
		 * Element bookNode = root.element("书");
		 * System.out.println(bookNode.getName());
		 */

		List list = root.elements();// 得到当前节点的所有子节点
		Element secondBook = (Element) list.get(0);// 向上转型，得到第一本的对象
		String name = secondBook.element("书名").getText();// 得到当前节点的文本内容
		System.out.println(name);
	}

	// 递归
	@Test
	public void test02() throws DocumentException
	{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/Book.xml");
		treeWalk(document.getRootElement());

	}

	public void treeWalk(Element element) // 递归的实现过程
	{
		System.out.println(element.getName());// 输出当前节点的名字
		for (int i = 0; i < element.nodeCount(); i++)// element.nodeCount()是获取当前节点的所有子节点的数量
		{
			Node node = element.node(i);// 取出下标为i的子节点
			if (node instanceof Element) // 判断当前节点是否为标签
			{
				treeWalk((Element) node);// 把node强转（向上转型）为标签
			} else
			{
				continue;
				// System.out.println("error");
			}
		}
	}

}
