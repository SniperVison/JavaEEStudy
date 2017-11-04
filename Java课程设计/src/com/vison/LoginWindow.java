package com.vison;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindow extends JFrame implements ActionListener
{
	static Chatroom login;
	static LoginWindow qq;
	JTextField jtf01;
	JPasswordField jpf01;
	public String User;

	LoginWindow(String str)
	{
		this.setTitle(str);
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = this.getContentPane();

		imageBackground();// ����ͼƬ��Ϊ����

		// ��¼��
		JButton loginButton = new JButton("��¼");
		this.setLayout(null);
		loginButton.setBounds(45, 250, 100, 30);
		c.add(loginButton);
		loginButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				loginButtonActionPerformed(e);
			}

		});

		JButton registerButton = new JButton("ע��");
		registerButton.setBounds(220, 250, 100, 30);
		c.add(registerButton);
		registerButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				registerButtonActionPerformed(e);
			}
		});

		// �����ʽ
		Font f = new Font("����", Font.BOLD + Font.ITALIC, 15);

		// �û���ǩ
		JLabel l01 = new JLabel("�û�����");
		l01.setBounds(20, 20, 100, 30);
		c.add(l01);
		l01.setFont(f);

		// �û��������
		jtf01 = new JTextField();
		jtf01.setBounds(140, 20, 200, 30);
		c.add(jtf01);

		// �����ǩ
		JLabel l02 = new JLabel("����:");
		l02.setFont(f);
		l02.setBounds(20, 60, 100, 30);
		c.add(l02);

		// ���������
		jpf01 = new JPasswordField();
		jpf01.setBounds(140, 60, 200, 30);
		c.add(jpf01);

		this.setVisible(true);

	}

	// ����ͼƬ��Ϊ����
	public void imageBackground()
	{
		ImageIcon loginImage = new ImageIcon("F:\\JAVA���\\�γ����\\name.jpg");
		JLabel imageLabel = new JLabel(loginImage);
		imageLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
		getLayeredPane().add(imageLabel, new Integer(-30001));// ������ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
		// ����͸����
		JPanel imageContentPane = (JPanel) getContentPane();//// �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
		imageContentPane.setOpaque(false);
	}

	public static void main(String[] args)
	{
		LoginWindow qq = new LoginWindow("QQ");

	}

	public void loginButtonActionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("��¼"))
		{
			// System.out.println("�û����� " + jtf01.getText() + " " + "���룺 " +
			// String.valueOf(jpf01.getPassword()));//
			// getPassword()�����õ������ֽ��룬��Ҫװ�����ַ�����������ʾ����
			if (String.valueOf(jpf01.getPassword()).equals("") || jtf01.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "�û����������벻��Ϊ��");
				jtf01.setText(null);
				jpf01.setText(null);

			}

			else
			{
				File loginTXT = new File("userTXT.txt");
				try
				{
					boolean loginFlag = false;
					BufferedReader userBR = new BufferedReader(new FileReader(loginTXT));
					String stringTXT = (String) userBR.readLine();
					while (stringTXT != null)
					{
						String[] kklogin = stringTXT.split("-");
						if (jtf01.getText().equals(kklogin[0])
								&& String.valueOf(jpf01.getPassword()).equals(kklogin[1]))
						{
							loginFlag = true;
							break;
						}
						stringTXT = (String) userBR.readLine();
					}
					userBR.close();
					if (loginFlag )
					{
						JOptionPane.showMessageDialog(null, "��¼�ɹ�");
						new Chatroom(jtf01.getText() + "������������", jtf01.getText());
						this.dispose();
					} else
					{
						jtf01.setText(null);
						jpf01.setText(null);
						JOptionPane.showMessageDialog(null, "��������˺Ż�������������������룡");
					}
				} catch (FileNotFoundException e1)
				{
					e1.printStackTrace();
				} catch (IOException e2)
				{
					e2.printStackTrace();
				}

			}
		}

	}
	
//��¼ҳ���ע�Ṧ��
	public void registerButtonActionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("ע��"))
		{
			if (String.valueOf(jpf01.getPassword()).equals("") || jtf01.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "�û����������벻��Ϊ��");
				jtf01.setText(null);
				jpf01.setText(null);

			} else
			{
				File loginTXT01 = new File("userTXT.txt");
				try
				{
					boolean loginFlag01 = false;
					FileReader frLogin = new FileReader(loginTXT01);
					BufferedReader userBR01 = new BufferedReader(frLogin);
					String stringTXT01 = (String) userBR01.readLine();
					while (stringTXT01 != null)
					{
						String[] kk01 = stringTXT01.split("-");
						if (kk01[0].equals(jtf01.getText()))
						{
							loginFlag01 = true;
							break;
						}
						stringTXT01 = (String) userBR01.readLine();
					}
					userBR01.close();
					if (loginFlag01)
					{
						JOptionPane.showMessageDialog(null, "�û����Ѵ��ڣ�����������");
						jtf01.setText(null);
						jpf01.setText(null);
					} else
					{
						FileWriter fwLogin01 = new FileWriter(loginTXT01, true);
						PrintWriter pwLogin01 = new PrintWriter(fwLogin01, true);
						pwLogin01.println(jtf01.getText() + "-" + String.valueOf(jpf01.getPassword()) + "-"+"\n");
						pwLogin01.flush();
						JOptionPane.showMessageDialog(null, "ע��ɹ�");
						jtf01.setText(null);
						jpf01.setText(null);

					}

				} catch (FileNotFoundException e3)
				{
					e3.printStackTrace();
				} catch (IOException e3)
				{
					e3.printStackTrace();
				}
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
	}

}