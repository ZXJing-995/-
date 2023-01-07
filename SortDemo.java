package com.mooc.login;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mooc.jdbcUtil.jdbcUtil;

public class SortDemo extends JFrame  implements ActionListener{
	private static final int GAME_WIDTH = 1100;
	private static final int GAME_HEIGTH = 600;
	private JPanel contentPane;
	private JButton btn3,btn4;
	private JLabel label1,label2,label3,label4,label5;
	private JTextField account_id,account_name,account_price,account_time,account_type;
	private JButton jb1,jb2,jb3,jb4,jb5;
	Connection conn;
	Statement stam;
	
	public SortDemo() {
		setTitle("查询界面");
		setSize(GAME_WIDTH, GAME_HEIGTH);
		//setBounds(50,50,700,600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	setVisible(true);
		setBackground(Color.darkGray);
		setLocationRelativeTo(null);// 居中显示
		//添加一个面板容器到窗体中
		contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	   	setContentPane(contentPane);
	   	contentPane.setLayout(null);
	   	
//	   	label1 = new JLabel("账本的编号");
//		label1.setBounds(20, 20, 70, 70);
		label1 = new JLabel("账本事项");
		label1.setBounds(280, 60, 70, 70);
//		label3 = new JLabel("金额");
//		label3.setBounds(20, 100, 70, 70);
		label2 = new JLabel("记账时间");
		label2.setBounds(280, 100, 70, 70);
		label3 = new JLabel("记账类型");
		label3.setBounds(280, 140, 70, 70);
		
//		account_id = new JTextField();
//		account_id.setBounds(100,20, 70, 30);
		account_name = new JTextField();
		account_name.setBounds(280, 100, 250, 25);
		
//		account_price = new JTextField();
//		account_price.setBounds(100,100, 70, 30);
		account_time = new JTextField();
		account_time.setBounds(280,140, 250, 25);
		account_type = new JTextField();
		account_type.setBounds(280,180, 250, 25);
		contentPane.add(label1);
		contentPane.add(label2);
		contentPane.add(label3);
		contentPane.add(account_name);
		contentPane.add(account_time);
		contentPane.add(account_type);
		setVisible(true); 
		jb1 = new JButton("查询");
		jb1.setBounds(540, 100, 60, 30);
		jb1.addActionListener(new ActionListener() {
		//通过账本内容查询
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==jb1) {
					try {
						conn=jdbcUtil.getConnection();
						stam=conn.createStatement();
						String sql="select * from account where name='"+account_name.getText()+"'";
						ResultSet rs=stam.executeQuery(sql);
						while(rs.next()) {
							int id = rs.getInt(1);
							String name  = rs.getString(2);
							String price = rs.getString(3);
							String time = rs.getString(4);
							String type = rs.getString(5);
							System.out.println("账本的编号为"+id+",账本事项为"+name+",金额为"+price+",记账时间为"+time+",记账类型为"+type);
							//弹出一个提示框
							JOptionPane.showMessageDialog(jb1,"查询成功");
						}
							JOptionPane.showMessageDialog(jb1,"查询失败");
					}catch(Exception e1) {
						System.out.println(e1);
					}
				}
			}
			
		}); //添加事件监听
		contentPane.add(jb1);
		
		jb2 = new JButton("查询");
		jb2.setBounds(540, 140, 60, 30);
		jb2.addActionListener(new ActionListener() {
		//通过记账时间查询
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==jb2) {
					try {
						conn=jdbcUtil.getConnection();
						stam=conn.createStatement();
						String sql="select * from account where time='"+account_time.getText()+"'";
						ResultSet rs=stam.executeQuery(sql);
						while(rs.next()) {
							int id = rs.getInt(1);
							String name  = rs.getString(2);
							String price = rs.getString(3);
							Date time = rs.getDate(4);
							String type = rs.getString(5);
							System.out.println("账本的编号为"+id+",账本事项为"+name+",金额为"+price+",记账时间为"+time+",记账类型为"+type);
							//弹出一个提示框
							JOptionPane.showMessageDialog(jb2,"查询成功");
						}
							JOptionPane.showMessageDialog(jb2,"查询失败");
					}catch(Exception e2) {
						System.out.println(e2);
					}
				}
			}
			
		}); //添加事件监听
		contentPane.add(jb2);
		
		jb3 = new JButton("查询");
		jb3.setBounds(540, 180, 60, 30);
		jb3.addActionListener(new ActionListener() {
		//通过记账类型查询
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==jb3) {
					try {
						conn=jdbcUtil.getConnection();
						stam=conn.createStatement();
						String sql="select * from account where type='"+account_type.getText()+"'";
						ResultSet rs=stam.executeQuery(sql);
						while(rs.next()) {
							int id = rs.getInt(1);
							String name  = rs.getString(2);
							String price = rs.getString(3);
							String time = rs.getString(4);
							String type = rs.getString(5);
							System.out.println("账本的编号为"+id+",账本事项为"+name+",金额为"+price+",记账时间为"+time+",记账类型为"+type);
							//弹出一个提示框
							JOptionPane.showMessageDialog(jb3,"查询成功");
						}
				//		else {
							JOptionPane.showMessageDialog(jb3,"查询失败");
				//		}
					}catch(Exception e3) {
						System.out.println(e3);
					}
				}
			}
			
		}); //添加事件监听
		contentPane.add(jb3);
		
		jb4 = new JButton("退出");
		jb4.setBounds(540, 400, 60, 30);
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				if(e.getSource()==jb4) { 
				    dispose();
				    new MainTest();
				}
			}
		}); //添加事件监听
		contentPane.add(jb4);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
/*	public static void main(String[] args) {
		new SortDemo();
	}*/
}
