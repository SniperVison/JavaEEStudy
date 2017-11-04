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
                     //如果收到的消息是用户名，则做如下处理
					if ("receive".equals(clientmessage[0]))
					{
						chatRoom.userList.removeAllElements();   //先清空客户端在线用户列表
						for (int i = 1; i < clientmessage.length; i++)//然后重新加入用户
						{
							chatRoom.userList.add(clientmessage[i]);
							chatRoom.list.setListData(chatRoom.userList);
						}
					} 
					
					
					else if("sendsecret".equals(clientmessage[0]))
					{
						
								//主动创建私聊窗口		     
					    	  int countcsf=0;
					    	  for(SingleChatroom singleff:chatRoom.listcsf)
					    	  {					    		
					    		 if(singleff.clientname.equals(clientmessage[1])) 
					    		 {
					    			 countcsf++;
					    			 singleff.jta03.append(clientmessage[1]+" 对 "+clientmessage[2]+" 说 "+clientmessage[3]+"\n");
					    		 }					    	 
					    	  }
					    	  //被动创建聊天窗口
					    	  if(countcsf==0)
					    	  {
					    		SingleChatroom singleThread01=new SingleChatroom(clientmessage[2], clientSocket, clientmessage[1]);
					    		singleThread01.jta03.append(clientmessage[1]+" 对 "+clientmessage[2]+" 说 "+clientmessage[3]+"\n");
					    		chatRoom.listcsf.add(singleThread01);
					    	  }
						
						
					}
					//否则将收到的消息设置在文本框中
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
