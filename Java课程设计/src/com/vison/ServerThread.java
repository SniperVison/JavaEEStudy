package com.vison;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;

public class ServerThread extends Thread
{
	Socket socket = null;
	Server server = null;
	ArrayList<Socket> socketList = Server.getSocketList();
	InputStreamReader isr;
	BufferedReader br;
	PrintWriter pwThread;
	static File inputFile = new File("qq.txt");
	static File secretFile=new File("secretqq.txt");
	
	boolean serverFlag = false;

	public ServerThread(Socket socket, Server server)
	{
		this.socket = socket;
		this.server = server;

	}

	public void run()
	{
		try
		{
			isr = new InputStreamReader(socket.getInputStream());// 接收客户端的消息
			br = new BufferedReader(isr);
			String serverInfo = null;

			while ((serverInfo = br.readLine()) != null)
			{
				String[] message = serverInfo.split("-");// 用横杠截取用户名
				// 判断如果是用户名并且是 “connect”开头，则群发给各个客户端
				if ("connect".equals(message[0]))
				{
					server.addJList(message[1]);  //添加用户名到服务器中
					receiveList(); //更新各个客户端的用户列表
				} 
				
				//判断如果是用户名并且是“delete”开头，则从服务器中删除用户名，并且群发到各个客户端中
				else if("delete".equals(message[0]))
				{
					server.removeList(message[1]);  //从服务器列表中删除已退出的用户
					receiveList();     // //更新各个客户端的用户列表
				}
				
				else if("sendsecret".equals(message[0]))
				{
					Date secretDate=new Date();
					SimpleDateFormat secretsdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					FileWriter secretTXT = new FileWriter(secretFile, true);
					BufferedWriter secretqqTXT = new BufferedWriter(secretTXT);
					secretqqTXT.write(secretsdf.format(secretDate)+"\n"+message[1]+" 对 "+message[2]+" 说 "+message[3]+ "\n");
					secretqqTXT.flush();
					
					
					DefaultListModel singlelistModel= (DefaultListModel) server.onlineClient.getModel();
					for( int i=0; i < singlelistModel.getSize() ; i++ )
			        {
			        	if(message[2].equals(singlelistModel.getElementAt(i)))
			        	{
			        		//System.out.println(serverInfo);
			        		PrintWriter pwSingle=new PrintWriter(new OutputStreamWriter(socketList.get(i).getOutputStream()));
			        		pwSingle.println("sendsecret%"+message[1]+"%"+message[2]+"%"+message[3]);
			        		pwSingle.flush();
			        				
			        	}
			        }
				}
				
				
				//如果不是用户名，则将从客户端中收到的消息群发给各个客户端
				else
				{
					for (Socket ss : socketList)
					{
						// 将收到的客户端消息转发到各个客户端中
					pwThread = new PrintWriter(ss.getOutputStream());
						pwThread.println(serverInfo);
						pwThread.flush();
					}

					// 把接收到客户端的消息写入到GUI界面的文本框中
					String serverString = server.textArea.getText() + serverInfo + "\n";
					server.textArea.setText(serverString);

					

					// 把从客户端中接收到的消息通过用输入流写入qq.txt文件中
					FileWriter fwTXT = new FileWriter(inputFile, true);
					BufferedWriter bwTXT = new BufferedWriter(fwTXT);
					bwTXT.write(serverInfo + "\n");
					bwTXT.flush();
				}

			}

		} catch (SocketException e)
		{
			socketList.remove(socket);
			System.err.println(server.ip + " 有用户已下线 , 当前在线人数为: " + socketList.size() + "人！");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void receiveList() throws IOException
	{
		for (int i = 0; i < socketList.size(); i++)
		{
			Socket socket2 = (Socket) socketList.get(i);
			pwThread = new PrintWriter(socket2.getOutputStream());
			String str1 = server.getUserList();
			pwThread.println("receive" + str1);
			pwThread.flush();

		}
	}

}
