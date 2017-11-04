package com.vison;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Chatroom extends JFrame implements ActionListener, ListSelectionListener
{

	 static ArrayList<SingleChatroom> listcsf = new ArrayList<SingleChatroom>();
	Date serverDate = new Date();
	SimpleDateFormat serverSimpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	static Chatroom cs;

	JScrollPane jsp01, jso02, jsp03;
	JTextArea jta01, jta02;
	String userName;
	static String strName;
	static String senderLetter;
	static Socket sc;
	static String loginName;
	static LoginWindow loginWindow = null;
	JList<String> list;
	Vector<String> userList;
	static JList myList;
	boolean flag = true;

	// 构造方法
	Chatroom(String ss, String loginName)
	{
		this.loginName = loginName;
		this.setTitle(ss);
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container cc = this.getContentPane();
		this.setLayout(null);

		jsp01 = new JScrollPane();// 滚动面板
		jsp01.setBorder(BorderFactory.createTitledBorder("聊天消息"));
		jsp01.setBounds(10, 10, 280, 200);
		cc.add(jsp01);
		jta01 = new JTextArea();
		jta01.setEditable(false);
		jta01.setLineWrap(true);
		jsp01.setViewportView(jta01);

		JButton jb03 = new JButton("发送");
		jb03.setBounds(210, 280, 85, 35);
		jb03.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				sendBtnActionPerfoemed(loginName);
			}

		});
		cc.add(jb03);

		exitButton(cc);

		clearTextButton(cc);

		JScrollPane jsp02 = new JScrollPane();// 滚动面板
		jsp02.setBorder(BorderFactory.createTitledBorder("在线用户"));
		jsp02.setBounds(300, 10, 150, 250);
		cc.add(jsp02);

		userList = new Vector<String>();

		list = new JList<>();
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.addListSelectionListener(this);
		jsp02.setViewportView(list);
		list.setListData(userList);

		jsp03 = new JScrollPane();
		jsp03.setBounds(10, 280, 190, 35);
		cc.add(jsp03);
		jta02 = new JTextArea();
		jsp03.add(jta02);
		jta02.setLineWrap(true);
		jsp03.setViewportView(jta02);

		JButton jb04 = new JButton("单人聊天");
		jb04.setBounds(320, 280, 100, 35);
		jb04.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String liststr = (String) myList.getSelectedValue();
				// 如果点击的用户名是自己，则提示“无法与自己私聊”
				if (userName.equals(loginName))
				{
					JOptionPane.showMessageDialog(null, "无法与自己私聊");
				}
				else
				{
					SingleChatroom sroom01=new SingleChatroom(loginName, sc, userName);
					listcsf.add(sroom01);
				}
				
			
				
			}
		});
		cc.add(jb04);

		try
		{
			sc = new Socket("localhost", 5050);

			ClientThread clientThread = new ClientThread(sc, this);
			clientThread.start();

		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				PrintWriter bbPW;
				try
				{
					bbPW = new PrintWriter(new OutputStreamWriter(sc.getOutputStream()));
					bbPW.println("delete-" + loginName); // 加入“delete”单词，用于截取用户名
					bbPW.flush();
				} catch (IOException e1)
				{

					e1.printStackTrace();
				}

			}
		});

		deliverLoginnameToServer(loginName);// 传递用户名给服务器

		this.setVisible(true);
	}

	// 具体实现过程
	public void deliverLoginnameToServer(String lo)
	{
		try
		{

			OutputStreamWriter ops;
			ops = new OutputStreamWriter(sc.getOutputStream());

			PrintWriter pw = new PrintWriter(ops);

			String clientString = "connect-" + lo;
			pw.println(clientString);

			pw.flush();

		} catch (IOException e)
		{

			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{

	}

	public void sendBtnActionPerfoemed(String loginName)
	{
		strName = loginName;
		try
		{
			OutputStreamWriter ops = new OutputStreamWriter(sc.getOutputStream());
			PrintWriter pw = new PrintWriter(ops);

			String clientString = serverSimpleDate.format(serverDate) + "\n" + strName + " 说: " + this.jta02.getText();
			this.jta02.setText(null);
			pw.println(clientString);

			pw.flush();

		} catch (UnknownHostException e1)
		{

			e1.printStackTrace();
		} catch (IOException e2)
		{

			e2.printStackTrace();
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e)
	{
		myList = (JList) e.getSource();

		userName = (String) myList.getSelectedValue();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
	}

	// 按钮“退出聊天室”的布局以及响应事件
	public void exitButton(Container cc)
	{
		JButton jb01 = new JButton("退出聊天室");
		jb01.setBounds(20, 225, 120, 30);
		jb01.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{

				int n = JOptionPane.showConfirmDialog(null, "确认退出聊天室吗", "标题", JOptionPane.YES_NO_OPTION);
				if (n == 0)
				{
					// 退出聊天室之前给服务器发送消息，请求删除用户，传递用户名进去
					try
					{
						deleteClient(loginName);
					} catch (IOException e1)
					{
						e1.printStackTrace();
					}
					System.exit(0);// 关闭该聊天室的程序
				}

			}

		});
		cc.add(jb01);
	}

	// 传递需要删除的用户名给服务器
	public void deleteClient(String strqq) throws IOException
	{
		strqq = loginName;
		PrintWriter bbPW = new PrintWriter(new OutputStreamWriter(sc.getOutputStream()));
		bbPW.println("delete-" + strqq); // 加入“delete”单词，用于截取用户名
		bbPW.flush();

	}

	// 按钮“清除聊天记录”布局以及响应事件
	public void clearTextButton(Container cc)
	{
		JButton jb02 = new JButton("清除聊天纪录");
		jb02.setBounds(150, 225, 125, 30);
		jb02.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				jta01.setText(null);

			}

		});
		cc.add(jb02);
	}

}
