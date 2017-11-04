package com.vison;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Server extends JFrame implements ActionListener, ListSelectionListener
{
	static ArrayList<Socket> socketList = new ArrayList<Socket>();
	JTextArea textArea;
	String serverName;
	static Socket socket;
	static String ip;
	static Server server;

	static ServerThread serverThread;

	static Vector<String> serverlist;
	static JList<String> onlineClient;


	public static ArrayList<Socket> getSocketList()
	{
		return socketList;
	}

	public static void setSocketList(ArrayList<Socket> socketList)
	{
		Server.socketList = socketList;
	}

	public Server(String serverName)
	{
		guiWindow(serverName);
	}

	
	public static void main(String[] args)
	{
		// 创建集合存储Socket
		onlineClient = new JList();
		server = new Server("服务器");

		try
		{
			ServerSocket serversocket = new ServerSocket(5050);
			System.out.println("服务器启动中，等待客户端接入");
			while (true)
			{
				socket = serversocket.accept();
				socketList.add(socket);// 存储接收进来的Socket
				ip = socket.getInetAddress().getHostAddress(); // 获取IP地址
				System.err.println(ip + " 有用户上线了 , 当前在线用户为: " + socketList.size() + "人 !");

				serverThread = new ServerThread(socket, server);
				serverThread.start();
			}

		} catch (UnknownHostException e1)
		{
			e1.printStackTrace();
		} catch (IOException e2)
		{
			e2.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

	}

	public void guiWindow(String serverName)
	{
		this.serverName = serverName;
		this.setTitle(serverName);
		this.setSize(650, 500);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		Container serverContent = this.getContentPane();

		/*// 启动服务器按钮，以及其事件响应启动多线程（未实现）
		JButton serverStart = new JButton("启动服务器");
		serverStart.setBounds(40, 30, 120, 50);
		serverStart.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				startServer(e);
			}
		});*/

		/*// 停止服务器按钮，以及其事件响应暂停多线程（未实现）
		JButton serverStop = new JButton("停止服务器");
		serverStop.setBounds(230, 30, 120, 50);
		serverStop.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				stopServer(e);
			}

		});*/

		// 退出服务器按钮，以及其事件响应
		JButton serverExit = new JButton("退出服务器");
		serverExit.setBounds(200, 30, 200, 50);
		serverExit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				exitServer(e);
			}

		});

		//serverContent.add(serverStart);
		//serverContent.add(serverStop);
		serverContent.add(serverExit);

		JScrollPane userWindow = new JScrollPane();
		userWindow.setBounds(400, 120, 200, 300);
		userWindow.setBorder(BorderFactory.createTitledBorder("在线用户"));
		serverContent.add(userWindow);

		onlineClient.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		onlineClient.addListSelectionListener(this);
		userWindow.setViewportView(onlineClient);

		JScrollPane textWindow = new JScrollPane();
		textWindow.setBounds(20, 120, 300, 300);
		textWindow.setBorder(BorderFactory.createTitledBorder("聊天消息"));
		serverContent.add(textWindow);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textWindow.setViewportView(textArea);

		this.setVisible(true);
	}

	/*// 启动服务器响应事件
	public void startServer(ActionEvent e)
	{
		// serverThread.notifyAll();
	}

	// 停止服务器响应事件
	public void stopServer(ActionEvent e)
	{

		

	}*/

	// 退出服务器响应事件
	public void exitServer(ActionEvent e)
	{
		int n = JOptionPane.showConfirmDialog(null, "是否确认退出服务器？", "提示", JOptionPane.YES_NO_OPTION);
		if (n == 0)
			System.exit(0);
	}

	@Override
	public void valueChanged(ListSelectionEvent e)
	{
	}

	public static void addJList(String str)
	{
		if (0 == onlineClient.getModel().getSize())
		{
			// 新建一个默认项集合
			DefaultListModel listModel = new DefaultListModel();
			// 操作这个集合
			listModel.add(0, str);
			// 将这个集合添加到JList中
			onlineClient.setModel(listModel);
		} else
		{
			// 从JList中获得这个集合,转换为默认项集合类型
			DefaultListModel listModel = (DefaultListModel) onlineClient.getModel();
			// 追加元素
			listModel.add(listModel.getSize(), str);
			// 将这个集合添加到JList中
			onlineClient.setModel(listModel);
		}
	}
	
	
	//获取服务器在线用户列表的人，用于更新用户列表
	public static String getUserList()
	{
		String str = "";
		DefaultListModel listModel= (DefaultListModel) onlineClient.getModel();
        for( int i=0; i < listModel.getSize() ; i++ )
        {
        	str = str + "%" +listModel.getElementAt(i);      //加入%号，让后续步骤能够截取用户名
        }
        return str;
	}
	
	
	
	//通过从线程中的消息截取用户名，并与列表项匹配，相同则移除已退出的用户，
	public static void removeList( String str )
	{
		DefaultListModel listModel= (DefaultListModel) onlineClient.getModel();
        for( int i=0; i < listModel.getSize() ; i++ )
        {
        	if( str.equals(listModel.getElementAt(i)) )
        	{
        		listModel.remove(i);
        	}
        }
	}
	
	

}
