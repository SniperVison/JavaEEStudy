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
		// ����������룬��Ӧ���ʲ���
		// request.setCharacterEncoding("UTF-8");
		// Ҫִ���ļ��ϴ��Ĳ���
		// �жϱ��Ƿ�֧���ļ��ϴ�����enctype="multipart/form-data"
		boolean isMultipartContentt = ServletFileUpload.isMultipartContent(request);
		if (!isMultipartContentt)
		{
			throw new RuntimeException("your form is not multipart/form-data");
		}
		// ����һ��DiskFileItemFactory������
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ������ʱ�ļ��Ĵ���Ŀ¼����������û�������ϴ��ļ��Ĵ�С��ʱ���õ�
		factory.setRepository(new File("F:\\"));
		// ����һ��ServletFileUpload���Ķ���
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// ####����ϴ���������������⣬�Ƽ�ʹ��
		sfu.setHeaderEncoding("UTF-8");
		/*####��ʱ�ļ�������
		DiskFileItemFactory:
		���ã�����FileItem����		
		     ���Լ�û�����������ϴ��ļ��Ĵ�С��ʱ���ڲ���һ�����棬�����СĬ����10Kb������ϴ����ļ�����10Kb���ô�����Ϊ���档
		��Ż����ļ���Ŀ¼�����Ĭ����ϵͳ����ʱĿ¼��
		
		����Լ���IO��ʵ�ֵ��ļ��ϴ���Ҫ�����رպ�������ʱ�ļ���
		FileItem.delete();
		*/
		// ����request���󣬲��õ�һ������ļ���
		try
		{
			// ���Ƶ����ϴ��ļ��Ĵ�С
			// sfu.setFileSizeMax(1024 * 1024 * 3);// ��ʾ3M��С
			// ����ȫ���ϴ��ļ���������
			// sfu.setSizeMax(1024 * 1024 * 6);// ��ʾ6M��С
			// ʹ�ý�����������request����
			List<FileItem> fileItems = sfu.parseRequest(request);
			// ������������
			for (FileItem fileItem : fileItems)
			{
				if (fileItem.isFormField())
				{// ��ͨ������
					processFormField(fileItem);

				} else
				{
					// �ϴ�����
					processUploadField(fileItem);
				}

			}
		} catch (FileUploadBase.FileSizeLimitExceededException e)
		{
			System.out.println("�����ļ��Ĵ�С���ܳ���3M");
		} catch (FileUploadBase.SizeLimitExceededException e)
		{
			System.out.println("�ϴ��ļ����ܴ�С���ܳ���6M");
		} catch (FileUploadException e)
		{
			e.printStackTrace();
		}
	}

	// ����һ��
	private void processUploadField(FileItem fileItem)
	{
		try
		{
			InputStream is = fileItem.getInputStream();
			// ����һ�����ܱ����ʵ��ļ�����Ŀ¼�����ѱ����ϴ��ļ���Ŀ¼�����û�ֱ�ӷ��ʲ����ĵط���
			String directoryRealPath = this.getServletContext().getRealPath("/WEB-INF/upload");

			File storeDirectory = new File(directoryRealPath);// �ȴ����ļ��ִ���Ŀ¼
			if (!storeDirectory.exists())
			{
				storeDirectory.mkdirs();// ����һ��ָ����Ŀ¼
			}
			// �õ��ϴ�������
			String filename = fileItem.getName();// �ļ����е�ֵ ,������:a.txt
			if (filename != null)
			{
				filename = FilenameUtils.getName(filename);
			}
			// ����ļ�ͬ��������
			filename = UUID.randomUUID() + "_" + filename;
			// Ŀ¼��ɢ
			String childDirectory = makeChildDirectory(storeDirectory, filename);
			// �ϴ��ļ����Զ�ɾ����ʱ�ļ�����xxx.tmp֮���
			fileItem.write(new File(storeDirectory, childDirectory + File.separator + filename));
			is.close();
			fileItem.delete();// ֱ������һ���ǲ��еģ�Ҫ�ص�IO������ִ�в�����Ч��
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// ��������
	// �ϴ�����
	private void processUploadFieldDemo1(FileItem fileItem)
	{
		// �õ��ϴ�������
		String filename = fileItem.getName();// �ļ����е�ֵ ,������:a.txt
		// �õ��ļ�������
		try
		{
			InputStream is = fileItem.getInputStream();
			// ����һ�����ܱ����ʵ��ļ�����Ŀ¼�����ѱ����ϴ��ļ���Ŀ¼�����û�ֱ�ӷ��ʲ����ĵط���
			String directoryRealPath = this.getServletContext().getRealPath("/WEB-INF/upload");

			File storeDirectory = new File(directoryRealPath);// �ȴ����ļ��ִ���Ŀ¼
			if (!storeDirectory.exists())
			{
				storeDirectory.mkdirs();// ����һ��ָ����Ŀ¼
			}
			// �����ļ���
			// ����һ:���Ƽ�
			// filename=filename.substring(filename.lastIndexOf(File.separator)+1);
			// ������:ʹ��io���е�FilenameUtils��
			if (filename != null)
			{
				filename = FilenameUtils.getName(filename);
			}
			// ����ļ�ͬ��������
			filename = UUID.randomUUID() + "_" + filename;
			// Ŀ¼��ɢ
			String childDirectory = makeChildDirectory(storeDirectory, filename);
			// ��storeDirectory�£���������Ŀ¼�µ��ļ�
			File file = new File(storeDirectory, childDirectory + File.separator + filename);// ����Ŀ¼/����Ŀ¼/�ļ���
			// ͨ���ļ���������ϴ����ļ����浽������
			FileOutputStream fos = new FileOutputStream(file);
			int len = 0;
			byte[] b = new byte[1024];
			while ((len = is.read(b)) != -1)
			{
				fos.write(b, 0, len);
			}
			fos.close();
			is.close();
			// ����ϴ��ļ�����ʱ�ļ�
			fileItem.delete();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	// �����ڴ�ɢ
	public String makeChildDirectory(File storeDirectory, String filename)
	{
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateDirectory = sdf.format(new Date());
		// ֻ�ܴ���Ŀ¼
		File file = new File(storeDirectory, dateDirectory);
		if (!file.exists())
		{
			file.mkdirs();
		}		
		return dateDirectory;*/

		int hashCode = filename.hashCode();// �����ַ�ת����32λ��hashcode��
		System.out.println(hashCode);
		String code = Integer.toHexString(hashCode);// ��hashCodeת��Ϊ16���Ƶ��ַ�
		System.out.println(code);
		String childDirectory = code.charAt(0) + File.separator + code.charAt(1);// a/b������Ŀ¼������ͬһ���ļ����ļ���������⣩

		// ����ָ��Ŀ¼
		File file = new File(storeDirectory, childDirectory);
		if (!file.exists())
		{
			file.mkdirs();
		}
		return childDirectory;
	}

	// ��ͨ����
	private void processFormField(FileItem fileItem) throws UnsupportedEncodingException
	{
		String fieldname = fileItem.getFieldName();// �ֶ���
		String fieldvalue = fileItem.getString();// �ֶ�ֵ
		// get���������������ķ�ʽ������������������������new
		// String(fieldvalue.getBytes("iso-8859-1"), "UTF-8")
		System.out.println(fieldname + "=" + new String(fieldvalue.getBytes("iso-8859-1"), "UTF-8"));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);

	}

}
