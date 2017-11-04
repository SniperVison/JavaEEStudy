package com.vison;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SingleChatroom extends JFrame implements WindowListener

{

	JScrollPane jsp04, jsp05;
	JTextArea jta03, jta04;
	Socket singleSocket;
	String single;
	String clientname;

	SingleChatroom(String single, Socket singleSocket, String clientname)
	{
		this.single = single;
		this.singleSocket = singleSocket;
		this.clientname = clientname;
		this.setTitle(single + "正在与" + clientname + "聊天中");
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);

		Container cg = this.getContentPane();
		this.setLayout(null);

		this.addWindowListener(this);

		jsp04 = new JScrollPane();// 滚动面板
		jsp04.setBorder(BorderFactory.createTitledBorder("聊天消息"));

		jsp04.setBounds(10, 10, 560, 450);

		jta03 = new JTextArea();
		jta03.setEditable(false);
		jta03.setLineWrap(true);
		jsp04.setViewportView(jta03);
		cg.add(jsp04);

		jsp05 = new JScrollPane();// 滚动面板
		jsp05.setBorder(BorderFactory.createTitledBorder("发送消息"));
		jsp05.setBounds(10, 470, 450, 50);
		jsp05.setViewportView(jta04);
		cg.add(jsp05);

		jta04 = new JTextArea();
		jta04.setLineWrap(true);
		jsp05.setViewportView(jta04);

		JButton deliverButton = new JButton("发送");
		deliverButton.setBounds(465, 485, 80, 30);
		deliverButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					deliverButtonActionPerformed(e);
				} catch (IOException e1)
				{

					e1.printStackTrace();
				}
			}
		});

		cg.add(deliverButton);

		this.addWindowListener(new WindowAdapter()
		{
         public void windowClosing(WindowEvent e)
         {
        	 for(int i=0;i<Chatroom.listcsf.size();i++)
        	 {
        		 SingleChatroom sign=Chatroom.listcsf.get(i);
        		 {
        			 if(sign.clientname.equals(clientname))
        				 Chatroom.listcsf.remove(i);
        		 }
        	 }
        	 dispose();
         }
		});

		this.setVisible(true);
	}

	public static void main(String[] args)
	{

	}

	public void deliverButtonActionPerformed(ActionEvent e) throws IOException
	{
		Date singleDate = new Date();
		SimpleDateFormat singlesdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		PrintWriter pwSingle = new PrintWriter(new OutputStreamWriter(singleSocket.getOutputStream()));
		String singleString = "sendsecret-" + single + "-" + clientname + "-" + jta04.getText();
		//System.out.println(clientname);
		pwSingle.println(singleString);
		pwSingle.flush();

		jta03.append(single + " 对  " + clientname + " 说  " + jta04.getText() + "\n");
		jta04.setText(null);
	}

	@Override
	public void windowClosed(WindowEvent e)
	{
		
	}

	@Override
	public void windowOpened(WindowEvent e)
	{
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
	}

	@Override
	public void windowIconified(WindowEvent e)
	{
	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{
	}

	@Override
	public void windowActivated(WindowEvent e)
	{
	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
	}

}
