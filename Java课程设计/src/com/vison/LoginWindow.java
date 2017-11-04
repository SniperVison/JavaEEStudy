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

		imageBackground();// 设置图片作为背景

		// 登录框
		JButton loginButton = new JButton("登录");
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

		JButton registerButton = new JButton("注册");
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

		// 字体格式
		Font f = new Font("黑体", Font.BOLD + Font.ITALIC, 15);

		// 用户标签
		JLabel l01 = new JLabel("用户名：");
		l01.setBounds(20, 20, 100, 30);
		c.add(l01);
		l01.setFont(f);

		// 用户名输入框
		jtf01 = new JTextField();
		jtf01.setBounds(140, 20, 200, 30);
		c.add(jtf01);

		// 密码标签
		JLabel l02 = new JLabel("密码:");
		l02.setFont(f);
		l02.setBounds(20, 60, 100, 30);
		c.add(l02);

		// 密码输入框
		jpf01 = new JPasswordField();
		jpf01.setBounds(140, 60, 200, 30);
		c.add(jpf01);

		this.setVisible(true);

	}

	// 设置图片作为背景
	public void imageBackground()
	{
		ImageIcon loginImage = new ImageIcon("F:\\JAVA编程\\课程设计\\name.jpg");
		JLabel imageLabel = new JLabel(loginImage);
		imageLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
		getLayeredPane().add(imageLabel, new Integer(-30001));// 将背景图片添加到分层窗格的最底层作为背景
		// 设置透明度
		JPanel imageContentPane = (JPanel) getContentPane();//// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
		imageContentPane.setOpaque(false);
	}

	public static void main(String[] args)
	{
		LoginWindow qq = new LoginWindow("QQ");

	}

	public void loginButtonActionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("登录"))
		{
			// System.out.println("用户名： " + jtf01.getText() + " " + "密码： " +
			// String.valueOf(jpf01.getPassword()));//
			// getPassword()方法得到的是字节码，需要装换成字符串，才能显示出来
			if (String.valueOf(jpf01.getPassword()).equals("") || jtf01.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "用户名或者密码不能为空");
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
						JOptionPane.showMessageDialog(null, "登录成功");
						new Chatroom(jtf01.getText() + "正在聊天室中", jtf01.getText());
						this.dispose();
					} else
					{
						jtf01.setText(null);
						jpf01.setText(null);
						JOptionPane.showMessageDialog(null, "你输入的账号或者密码错误，请重新输入！");
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
	
//登录页面的注册功能
	public void registerButtonActionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("注册"))
		{
			if (String.valueOf(jpf01.getPassword()).equals("") || jtf01.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "用户名或者密码不能为空");
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
						JOptionPane.showMessageDialog(null, "用户名已存在，请重新输入");
						jtf01.setText(null);
						jpf01.setText(null);
					} else
					{
						FileWriter fwLogin01 = new FileWriter(loginTXT01, true);
						PrintWriter pwLogin01 = new PrintWriter(fwLogin01, true);
						pwLogin01.println(jtf01.getText() + "-" + String.valueOf(jpf01.getPassword()) + "-"+"\n");
						pwLogin01.flush();
						JOptionPane.showMessageDialog(null, "注册成功");
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