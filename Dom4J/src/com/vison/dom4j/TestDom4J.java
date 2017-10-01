package com.vison.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/**
 * Dom4J�Ĵ����д�̳���ַΪ��https://dom4j.github.io/ ����������ϸ����д����
 * 
 * @author xiehe
 *
 */
public class TestDom4J
{
	@Test
	public void test01() throws DocumentException
	{
		SAXReader reader = new SAXReader(); // ����һ��XML��������
		Document document = reader.read("src/Book.xml");// ��XML�ĵ����ص�document�����У������ص��ڴ��У�
		Element root = document.getRootElement();
		/*
		 * Element bookNode = root.element("��");
		 * System.out.println(bookNode.getName());
		 */

		List list = root.elements();// �õ���ǰ�ڵ�������ӽڵ�
		Element secondBook = (Element) list.get(0);// ����ת�ͣ��õ���һ���Ķ���
		String name = secondBook.element("����").getText();// �õ���ǰ�ڵ���ı�����
		System.out.println(name);
	}

	// �ݹ�
	@Test
	public void test02() throws DocumentException
	{
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/Book.xml");
		treeWalk(document.getRootElement());

	}

	public void treeWalk(Element element) // �ݹ��ʵ�ֹ���
	{
		System.out.println(element.getName());// �����ǰ�ڵ������
		for (int i = 0; i < element.nodeCount(); i++)// element.nodeCount()�ǻ�ȡ��ǰ�ڵ�������ӽڵ������
		{
			Node node = element.node(i);// ȡ���±�Ϊi���ӽڵ�
			if (node instanceof Element) // �жϵ�ǰ�ڵ��Ƿ�Ϊ��ǩ
			{
				treeWalk((Element) node);// ��nodeǿת������ת�ͣ�Ϊ��ǩ
			} else
			{
				continue;
				// System.out.println("error");
			}
		}
	}

}
