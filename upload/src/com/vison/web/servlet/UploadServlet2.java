package com.vison.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class UploadServlet2 extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 解决中文乱码，但应用率不高
		// request.setCharacterEncoding("UTF-8");
		// 要执行文件上传的操作
		// 判断表单是否支持文件上传，即enctype="multipart/form-data"
		boolean isMultipartContentt = ServletFileUpload.isMultipartContent(request);
		if (!isMultipartContentt)
		{
			throw new RuntimeException("your form is not multipart/form-data");
		}
		// 创建一个DiskFileItemFactory工厂类
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 创建临时文件的存盘目录，用于自身没有限制上传文件的大小的时候用的
		factory.setRepository(new File("F:\\"));
		// 创建一个ServletFileUpload核心对象
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// ####解决上传表单中文乱码的问题，推荐使用
		sfu.setHeaderEncoding("UTF-8");
		/*####临时文件的问题
		DiskFileItemFactory:
		作用：产生FileItem对象		
		     在自己没有设置限制上传文件的大小的时候，内部有一个缓存，缓存大小默认是10Kb。如果上传的文件超过10Kb，用磁盘作为缓存。
		存放缓存文件的目录在哪里？默认是系统的临时目录。
		
		如果自己用IO流实现的文件上传，要在流关闭后，清理临时文件。
		FileItem.delete();
		*/
		// 解析request对象，并得到一个表单想的集合
		try
		{
			// 限制单个上传文件的大小
			// sfu.setFileSizeMax(1024 * 1024 * 3);// 表示3M大小
			// 限制全部上传文件的总容量
			// sfu.setSizeMax(1024 * 1024 * 6);// 表示6M大小
			// 使用解析器来解析request对象
			List<FileItem> fileItems = sfu.parseRequest(request);
			// 遍历表单项数据
			for (FileItem fileItem : fileItems)
			{
				if (fileItem.isFormField())
				{// 普通表数据
					processFormField(fileItem);

				} else
				{
					// 上传表单项
					processUploadField(fileItem);
				}

			}
		} catch (FileUploadBase.FileSizeLimitExceededException e)
		{
			System.out.println("单个文件的大小不能超过3M");
		} catch (FileUploadBase.SizeLimitExceededException e)
		{
			System.out.println("上传文件的总大小不能超过6M");
		} catch (FileUploadException e)
		{
			e.printStackTrace();
		}
	}

	// 方法一：
	private void processUploadField(FileItem fileItem)
	{
		try
		{
			InputStream is = fileItem.getInputStream();
			// 创建一个不能被访问的文件存盘目录（即把保存上传文件的目录放在用户直接访问不到的地方）
			String directoryRealPath = this.getServletContext().getRealPath("/WEB-INF/upload");

			File storeDirectory = new File(directoryRealPath);// 既代表文件又代表目录
			if (!storeDirectory.exists())
			{
				storeDirectory.mkdirs();// 创建一个指定的目录
			}
			// 得到上传的名字
			String filename = fileItem.getName();// 文件项中的值 ,即例如:a.txt
			if (filename != null)
			{
				filename = FilenameUtils.getName(filename);
			}
			// 解决文件同名的问题
			filename = UUID.randomUUID() + "_" + filename;
			// 目录打散
			String childDirectory = makeChildDirectory(storeDirectory, filename);
			// 上传文件，自动删除临时文件，即xxx.tmp之类的
			fileItem.write(new File(storeDirectory, childDirectory + File.separator + filename));
			is.close();
			fileItem.delete();// 直接用这一句是不行的，要关掉IO流，再执行才能奏效的
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// 方法二：
	// 上传表单项
	private void processUploadFieldDemo1(FileItem fileItem)
	{
		// 得到上传的名字
		String filename = fileItem.getName();// 文件项中的值 ,即例如:a.txt
		// 得到文件输入流
		try
		{
			InputStream is = fileItem.getInputStream();
			// 创建一个不能被访问的文件存盘目录（即把保存上传文件的目录放在用户直接访问不到的地方）
			String directoryRealPath = this.getServletContext().getRealPath("/WEB-INF/upload");

			File storeDirectory = new File(directoryRealPath);// 既代表文件又代表目录
			if (!storeDirectory.exists())
			{
				storeDirectory.mkdirs();// 创建一个指定的目录
			}
			// 处理文件名
			// 方法一:不推荐
			// filename=filename.substring(filename.lastIndexOf(File.separator)+1);
			// 方法二:使用io包中的FilenameUtils包
			if (filename != null)
			{
				filename = FilenameUtils.getName(filename);
			}
			// 解决文件同名的问题
			filename = UUID.randomUUID() + "_" + filename;
			// 目录打散
			String childDirectory = makeChildDirectory(storeDirectory, filename);
			// 在storeDirectory下，创建完整目录下的文件
			File file = new File(storeDirectory, childDirectory + File.separator + filename);// 绝对目录/日期目录/文件名
			// 通过文件输出流将上传的文件保存到磁盘中
			FileOutputStream fos = new FileOutputStream(file);
			int len = 0;
			byte[] b = new byte[1024];
			while ((len = is.read(b)) != -1)
			{
				fos.write(b, 0, len);
			}
			fos.close();
			is.close();
			// 清除上传文件的临时文件
			fileItem.delete();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	// 按日期打散
	public String makeChildDirectory(File storeDirectory, String filename)
	{
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateDirectory = sdf.format(new Date());
		// 只管创建目录
		File file = new File(storeDirectory, dateDirectory);
		if (!file.exists())
		{
			file.mkdirs();
		}		
		return dateDirectory;*/

		int hashCode = filename.hashCode();// 返回字符转换的32位的hashcode码
		System.out.println(hashCode);
		String code = Integer.toHexString(hashCode);// 把hashCode转换为16进制的字符
		System.out.println(code);
		String childDirectory = code.charAt(0) + File.separator + code.charAt(1);// a/b，两级目录（避免同一个文件夹文件更多的问题）

		// 创建指定目录
		File file = new File(storeDirectory, childDirectory);
		if (!file.exists())
		{
			file.mkdirs();
		}
		return childDirectory;
	}

	// 普通表单项
	private void processFormField(FileItem fileItem) throws UnsupportedEncodingException
	{
		String fieldname = fileItem.getFieldName();// 字段名
		String fieldvalue = fileItem.getString();// 字段值
		// get方法解决中文乱码的方式：运用这个方法解决中文乱码new
		// String(fieldvalue.getBytes("iso-8859-1"), "UTF-8")
		System.out.println(fieldname + "=" + new String(fieldvalue.getBytes("iso-8859-1"), "UTF-8"));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);

	}

}
