package com.mooc.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mooc.jdbcUtil.jdbcUtil;
import com.mysql.jdbc.Statement;

public class InstallDemo extends JFrame implements ActionListener{
	
	private static final int GAME_WIDTH = 1100;
	private static final int GAME_HEIGTH = 600;
	private JPanel contentPane;
	private JButton btn1,btn2,btn3; 
	private JTextField username;
	private JPasswordField oldpassword,newpassword,password;
	private JLabel label1,label2,label3;
	Connection conn;
	Statement stam;
	
	public InstallDemo() {
		setTitle("设置");
		setSize(GAME_WIDTH, GAME_HEIGTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(Color.darkGray);
		setLocationRelativeTo(null);// 居中显示
		//添加一个面板容器到窗体中
		contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	   	setContentPane(contentPane);
	   	contentPane.setLayout(null);
	   	
	   	label1=new JLabel("用户名");
	   	label1.setBounds(100, 100, 60, 30);
	   	label1.setFont(new Font("微软雅黑", Font.BOLD, 20));
	   	label1.setForeground(Color.BLACK);
	   	contentPane.add(label1);
	   	
	   	username=new JTextField();
	   	username.setBounds(200, 100, 150, 30);
	   	contentPane.add(username);
	   	
/*	   	label2=new JLabel("旧密码");
	   	label2.setBounds(100, 200, 60, 30);
	   	label2.setFont(new Font("微软雅黑", Font.BOLD, 20));
	   	label2.setForeground(Color.BLACK);
	   	contentPane.add(label2);
	   	
	   	id=new JTextField();
	   	id.setBounds(200, 200, 150, 30);
	   	contentPane.add(id);
	   	
	   	
	   	label3=new JLabel("新密码");
	   	label3.setBounds(100, 300, 60, 30);
	   	label3.setFont(new Font("微软雅黑", Font.BOLD, 20));
	   	label3.setForeground(Color.BLACK);
	   	contentPane.add(label3);
	   	
	   	password=new JPasswordField();
	   	password.setBounds(200, 300, 150, 30);
	   	contentPane.add(password);*/
	   	label2=new JLabel("旧密码");
	   	label2.setBounds(100, 200, 60, 30);
	   	label2.setFont(new Font("微软雅黑", Font.BOLD, 20));
	   	label2.setForeground(Color.BLACK);
	   	contentPane.add(label2);
	   	
	   	oldpassword=new JPasswordField();
	   	oldpassword.setBounds(200, 200, 150, 30);
	   	contentPane.add(oldpassword);
	   	
	   	label3=new JLabel("新密码");
	   	label3.setBounds(100, 300, 60, 30);
	   	label3.setFont(new Font("微软雅黑", Font.BOLD, 20));
	   	label3.setForeground(Color.BLACK);
	   	contentPane.add(label3);
	   	
	   	newpassword=new JPasswordField();
	   	newpassword.setBounds(200, 300, 150, 30);
	   	contentPane.add(newpassword);
	   	
/*	   	btn1=new JButton("修改用户名");
	   	btn1.setBounds(450, 100, 150, 30); 
	   	btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btn1) {	 
					try {
						conn=jdbcUtil.getConnection();//获取数据库连接
						stam= (Statement) conn.createStatement();  //创建sql语句执行对象
						//编写sql语句'"+username.getText()+"'"
						String sql="update user set username='"+username.getText()+"'"+"where username="+username.getText();
						//String sql="update user set username+"+username.getText()+"where username='"+username.getText()+"'";
	//					String sql="update user set username='"+username.getText()+"'"+"where id='"+id.getText()+"'";	
	  			PreparedStatement ps=conn.prepareStatement(sql);
						String userName=username.getText();
		//				String Password=password.getText();
						ps.setString(1, userName);
		//				ps.setString(2, Password);
						ps.executeUpdate();
								//+ "'"+username.getText()+"'";
					    //执行sql语句	
						stam.executeUpdate(sql);
					    dispose();//关闭当前窗口							
		//				new Main();
					    new MainTest();
	
					}catch (Exception e0) {
						e0.printStackTrace();
					}finally {
						jdbcUtil.result(conn, stam);
						
					}
				}
			}
	   		
	   	});
	   	contentPane.add(btn1);*/
	   	
	   	btn2=new JButton("修改密码");
	   	btn2.setBounds(450, 300, 150, 30);
	   	btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btn2) {	 
					try {
						conn=jdbcUtil.getConnection();//获取数据库连接
						stam= (Statement) conn.createStatement();  //创建sql语句执行对象
						String sql1="select * from user where password='"+oldpassword.getText()+"'";
						ResultSet rs=stam.executeQuery(sql1);
						if(rs.next()) {
							String sql="update user set password='"+newpassword.getText()+"'"+"where username='"+username.getText()+"'";
							int rows=stam.executeUpdate(sql);
							if(rows>0) {
								JOptionPane.showMessageDialog(btn2,"修改成功");
								dispose();//关闭当前窗口
							}
						}else {
							JOptionPane.showMessageDialog(btn2,"修改失败");
						}
						
						
					//	String sql2="update user set password='"+newpassword.getText()+"'"+"where username='"+username.getText()+"'";
					    //执行sql语句
					//	stam.executeUpdate(sql2);
						
				/*		PreparedStatement ps=conn.prepareStatement(sql);
						String userName=username.getText();
						String Password=password.getText();
						ps.setString(1, userName);
						ps.setString(2, Password);
						ps.executeUpdate();*/
				//	    dispose();//关闭当前窗口							
		//				new Main();
		//			    new MainTest();
	
					}catch (Exception e0) {
						e0.printStackTrace();
					}/*finally {
						jdbcUtil.result(conn, stam);
						
					}*/
				}
			}
	   		
	   	});
	   	
	   	contentPane.add(btn2);
	   	
/*	   	btn2=new JButton("修改密码");
	   	btn2.setBounds(450, 250, 150, 30);
	   	btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btn2) {	 
					try {
						conn=jdbcUtil.getConnection();//获取数据库连接
						stam= (Statement) conn.createStatement();  //创建sql语句执行对象
						//编写sql语句
						String sql=null;
						if(oldpassword.getText().equals(newpassword)) {
							sql="update user where password='"+newpassword.getText()+"'";
							stam.executeUpdate(sql);//执行sql语句
						}
					    
					    dispose();//关闭当前窗口							
		//				new Main();
		//			    new MainTest();
	
					}catch (Exception e0) {
						e0.printStackTrace();
					}finally {
						jdbcUtil.result(conn, stam);
						
					}
				}
			}
	   		
	   	});
	   	contentPane.add(btn2);*/
	   	
	    btn3=new JButton("返	  回");
	     btn3.setBounds(400, 400, 100, 30);
	     //btn4.setIcon( new ImageIcon(Login.class.getResource("/images/exit.png")));
	     btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				if(e.getSource()==btn3) {
				    dispose();
				    new MainTest();
				}
			}
		});
	     contentPane.add(btn3);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
/*	public static void main(String[] args) {
		new InstallDemo();
	}*/
}
