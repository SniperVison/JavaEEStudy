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
			isr = new InputStreamReader(socket.getInputStream());// ���տͻ��˵���Ϣ
			br = new BufferedReader(isr);
			String serverInfo = null;

			while ((serverInfo = br.readLine()) != null)
			{
				String[] message = serverInfo.split("-");// �ú�ܽ�ȡ�û���
				// �ж�������û��������� ��connect����ͷ����Ⱥ���������ͻ���
				if ("connect".equals(message[0]))
				{
					server.addJList(message[1]);  //����û�������������
					receiveList(); //���¸����ͻ��˵��û��б�
				} 
				
				//�ж�������û��������ǡ�delete����ͷ����ӷ�������ɾ���û���������Ⱥ���������ͻ�����
				else if("delete".equals(message[0]))
				{
					server.removeList(message[1]);  //�ӷ������б���ɾ�����˳����û�
					receiveList();     // //���¸����ͻ��˵��û��б�
				}
				
				else if("sendsecret".equals(message[0]))
				{
					Date secretDate=new Date();
					SimpleDateFormat secretsdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					FileWriter secretTXT = new FileWriter(secretFile, true);
					BufferedWriter secretqqTXT = new BufferedWriter(secretTXT);
					secretqqTXT.write(secretsdf.format(secretDate)+"\n"+message[1]+" �� "+message[2]+" ˵ "+message[3]+ "\n");
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
				
				
				//��������û������򽫴ӿͻ������յ�����ϢȺ���������ͻ���
				else
				{
					for (Socket ss : socketList)
					{
						// ���յ��Ŀͻ�����Ϣת���������ͻ�����
					pwThread = new PrintWriter(ss.getOutputStream());
						pwThread.println(serverInfo);
						pwThread.flush();
					}

					// �ѽ��յ��ͻ��˵���Ϣд�뵽GUI������ı�����
					String serverString = server.textArea.getText() + serverInfo + "\n";
					server.textArea.setText(serverString);

					

					// �Ѵӿͻ����н��յ�����Ϣͨ����������д��qq.txt�ļ���
					FileWriter fwTXT = new FileWriter(inputFile, true);
					BufferedWriter bwTXT = new BufferedWriter(fwTXT);
					bwTXT.write(serverInfo + "\n");
					bwTXT.flush();
				}

			}

		} catch (SocketException e)
		{
			socketList.remove(socket);
			System.err.println(server.ip + " ���û������� , ��ǰ��������Ϊ: " + socketList.size() + "�ˣ�");
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
