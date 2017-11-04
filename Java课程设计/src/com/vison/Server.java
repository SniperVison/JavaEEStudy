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
		// �������ϴ洢Socket
		onlineClient = new JList();
		server = new Server("������");

		try
		{
			ServerSocket serversocket = new ServerSocket(5050);
			System.out.println("�����������У��ȴ��ͻ��˽���");
			while (true)
			{
				socket = serversocket.accept();
				socketList.add(socket);// �洢���ս�����Socket
				ip = socket.getInetAddress().getHostAddress(); // ��ȡIP��ַ
				System.err.println(ip + " ���û������� , ��ǰ�����û�Ϊ: " + socketList.size() + "�� !");

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

		/*// ������������ť���Լ����¼���Ӧ�������̣߳�δʵ�֣�
		JButton serverStart = new JButton("����������");
		serverStart.setBounds(40, 30, 120, 50);
		serverStart.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				startServer(e);
			}
		});*/

		/*// ֹͣ��������ť���Լ����¼���Ӧ��ͣ���̣߳�δʵ�֣�
		JButton serverStop = new JButton("ֹͣ������");
		serverStop.setBounds(230, 30, 120, 50);
		serverStop.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				stopServer(e);
			}

		});*/

		// �˳���������ť���Լ����¼���Ӧ
		JButton serverExit = new JButton("�˳�������");
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
		userWindow.setBorder(BorderFactory.createTitledBorder("�����û�"));
		serverContent.add(userWindow);

		onlineClient.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		onlineClient.addListSelectionListener(this);
		userWindow.setViewportView(onlineClient);

		JScrollPane textWindow = new JScrollPane();
		textWindow.setBounds(20, 120, 300, 300);
		textWindow.setBorder(BorderFactory.createTitledBorder("������Ϣ"));
		serverContent.add(textWindow);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textWindow.setViewportView(textArea);

		this.setVisible(true);
	}

	/*// ������������Ӧ�¼�
	public void startServer(ActionEvent e)
	{
		// serverThread.notifyAll();
	}

	// ֹͣ��������Ӧ�¼�
	public void stopServer(ActionEvent e)
	{

		

	}*/

	// �˳���������Ӧ�¼�
	public void exitServer(ActionEvent e)
	{
		int n = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ���˳���������", "��ʾ", JOptionPane.YES_NO_OPTION);
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
			// �½�һ��Ĭ�����
			DefaultListModel listModel = new DefaultListModel();
			// �����������
			listModel.add(0, str);
			// �����������ӵ�JList��
			onlineClient.setModel(listModel);
		} else
		{
			// ��JList�л���������,ת��ΪĬ���������
			DefaultListModel listModel = (DefaultListModel) onlineClient.getModel();
			// ׷��Ԫ��
			listModel.add(listModel.getSize(), str);
			// �����������ӵ�JList��
			onlineClient.setModel(listModel);
		}
	}
	
	
	//��ȡ�����������û��б���ˣ����ڸ����û��б�
	public static String getUserList()
	{
		String str = "";
		DefaultListModel listModel= (DefaultListModel) onlineClient.getModel();
        for( int i=0; i < listModel.getSize() ; i++ )
        {
        	str = str + "%" +listModel.getElementAt(i);      //����%�ţ��ú��������ܹ���ȡ�û���
        }
        return str;
	}
	
	
	
	//ͨ�����߳��е���Ϣ��ȡ�û����������б���ƥ�䣬��ͬ���Ƴ����˳����û���
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
