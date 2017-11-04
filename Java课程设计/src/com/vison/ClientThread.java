package com.vison;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class ClientThread extends Thread
{
    
	Chatroom chatRoom;
	Socket clientSocket;
	BufferedReader brClient;

	public ClientThread(Socket clientSocket, Chatroom chatRoom)
	{
		this.clientSocket = clientSocket;
		this.chatRoom = chatRoom;

	}

	public void run()
	{
		try
		{
			brClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String clientInfo = null;
			while (true)
			{
				while ((clientInfo = brClient.readLine()) != null)
				{
					String[] clientmessage = clientInfo.split("%");
                     //����յ�����Ϣ���û������������´���
					if ("receive".equals(clientmessage[0]))
					{
						chatRoom.userList.removeAllElements();   //����տͻ��������û��б�
						for (int i = 1; i < clientmessage.length; i++)//Ȼ�����¼����û�
						{
							chatRoom.userList.add(clientmessage[i]);
							chatRoom.list.setListData(chatRoom.userList);
						}
					} 
					
					
					else if("sendsecret".equals(clientmessage[0]))
					{
						
								//��������˽�Ĵ���		     
					    	  int countcsf=0;
					    	  for(SingleChatroom singleff:chatRoom.listcsf)
					    	  {					    		
					    		 if(singleff.clientname.equals(clientmessage[1])) 
					    		 {
					    			 countcsf++;
					    			 singleff.jta03.append(clientmessage[1]+" �� "+clientmessage[2]+" ˵ "+clientmessage[3]+"\n");
					    		 }					    	 
					    	  }
					    	  //�����������촰��
					    	  if(countcsf==0)
					    	  {
					    		SingleChatroom singleThread01=new SingleChatroom(clientmessage[2], clientSocket, clientmessage[1]);
					    		singleThread01.jta03.append(clientmessage[1]+" �� "+clientmessage[2]+" ˵ "+clientmessage[3]+"\n");
					    		chatRoom.listcsf.add(singleThread01);
					    	  }
						
						
					}
					//�����յ�����Ϣ�������ı�����
					else
					{
						String clientThreadString = chatRoom.jta01.getText() + clientInfo + "\n";
						chatRoom.jta01.setText(clientThreadString);
					}

				}
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
