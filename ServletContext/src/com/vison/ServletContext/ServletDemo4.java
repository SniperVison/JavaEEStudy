package com.vison.ServletContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo4 extends HttpServlet
{
	// 注意：Tomcat服务器中用到的文件全是跟在
	// Myeclipse中的WEB-INF中的文件是一样的，所以要看准路径写才行，可以使用navigator视图模式,路径问题得十分注意，不然会报java.io.FileNotFoundException异常，提示找不到文件的

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 获取资源路径,WEB-INF下的文件
		String path_1 = this.getServletContext().getRealPath("/WEB-INF/a.properties");// 参数一定要“/”开头
		// 创建一个Properties对象，获取文件里面的值
		Properties pro_1 = new Properties();
		pro_1.load(new FileInputStream(path_1));
		System.out.println(pro_1.getProperty("key"));
		// 打印出资源路径
		System.out.println(path_1);

		String path_2 = this.getServletContext().getRealPath("/WEB-INF/classes/b.properties");// 路径src是不对的，实际路径是/WEB-INF/classes
		Properties pro_2 = new Properties();
		pro_2.load(new FileInputStream(path_2));
		System.out.println(pro_2.getProperty("key"));
		System.out.println(path_2);

		String path_3 = this.getServletContext().getRealPath("WEB-INF/classes/com/vison/ServletContext/c.properties");// 同上，实际路径/WEB-INF/classes/com/vison/ServletContext/c.properties
		Properties pro_3 = new Properties();
		pro_3.load(new FileInputStream(path_3));
		System.out.println(pro_3.getProperty("key"));
		System.out.println(path_3);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
