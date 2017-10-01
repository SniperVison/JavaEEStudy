package com.vison.entity;

import java.io.Serializable;
//Book类没有实现序列化之前，关闭服务器之后是不能保存原来的信息的，但是实现序列化之后是可以保存的
//这个关闭，重启服务器的过程，叫钝化-活化（或者搁置-激活），这种过程可以发生在内存溢出和服务器重启两种情况
//持久化：存盘,内存中的一个全景图,IO实现serializable,即变成一串二进制数字存进内存中

public class Book implements Serializable
{
	private String id;
	private String name;
	private double price;
	private String author;

	public Book(String id, String name, double price, String author)
	{
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.author = author;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	@Override
	public String toString()
	{
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", author=" + author + "]";
	}
}
