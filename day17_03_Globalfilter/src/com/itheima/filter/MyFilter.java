package com.itheima.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		// ���post��ʽ
		// req.setCharacterEncoding("UTF-8");
		req = new MyRequest(req);

		chain.doFilter(req, response);
	}

	public void destroy() {
	}
}

// ʵ���뱻��װ������ͬ�Ľӿ�
// ����һ���뱻��װ������������
// ����һ�����췽�����ѱ���װ���󴫹���
// ���ڲ���Ҫ��д������ֱ�ӵ���
// ��������Ҫ��д������д�Լ��ķ�����
class MyRequest extends HttpServletRequestWrapper {
	HttpServletRequest request;

	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	/*
	 * @Override public String getParameter(String name) { name =
	 * request.getParameter(name);//���� try { return new
	 * String(name.getBytes("iso-8859-1"),"UTF-8"); } catch
	 * (UnsupportedEncodingException e) { e.printStackTrace(); } return null; }
	 */

	@Override
	public String getParameter(String name) {
		Map<String, String[]> map = getParameterMap();
		return map.get(name)[0];
	}

	@Override
	public String[] getParameterValues(String name) {
		Map<String, String[]> map = getParameterMap();
		return map.get(name);
	}

	private boolean flag = true;

	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> map = request.getParameterMap();// ����
		if (flag) {
			for (Map.Entry<String, String[]> m : map.entrySet()) {
				String[] values = m.getValue();
				for (int i = 0; i < values.length; i++) {
					try {
						values[i] = new String(
								values[i].getBytes("iso-8859-1"), "UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}

			}
			flag = false;
		}
		return map;

	}

}
