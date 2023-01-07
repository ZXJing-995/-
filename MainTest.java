package com.mooc.login;
 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.WeakHashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
 
public class MainTest extends JFrame implements ActionListener{
 
	private static final int GAME_WIDTH = 1100;
	private static final int GAME_HEIGTH = 600;
	
	private JPanel contentPane;
	private JButton btn1,btn2,btn3;
	private JTextField userName;
	private JPasswordField password;
	private JLabel label1,label2;
	//窗口初始化
		JLabel jlabel1,jlabel2,jlabel3,jlabel4,jlabel5;
		JTextField account_id,account_name,account_price,account_time,account_type;
		JButton jb1,jb2,jb3,jb4;
 
	/**
	 * 构造方法
	 */
	public MainTest() {
		setTitle("主界面");
		setSize(GAME_WIDTH, GAME_HEIGTH);
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
	   	 //
		JLabel label = new JLabel("欢迎来到主页面!");
        label.setBounds(350, 100, 250, 25);
        label.setFont(new Font("微软雅黑", Font.BOLD, 25));
        label.setForeground(Color.red);
		add(label);
		setVisible(true);
		jb1 = new JButton("记一笔账");
		jb1.setBounds(150, 200, 150, 50);//添加事件监听
		jb1.setFont(new Font("微软雅黑", Font.BOLD, 20));
		jb1.setForeground(Color.BLACK);
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new AccountDemo();
			}
		});
		contentPane.add(jb1);
		
		jb2 = new JButton("分类查询");
		jb2.setBounds(150, 300, 150, 50); //添加事件监听
		jb2.setFont(new Font("微软雅黑", Font.BOLD, 20));
		jb2.setForeground(Color.BLACK);
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new SortDemo();
			}
			
		});
		contentPane.add(jb2);
		
		jb3 = new JButton("设置");
		jb3.setBounds(550, 200, 150, 50);
		jb3.setFont(new Font("微软雅黑", Font.BOLD, 20));
		jb3.setForeground(Color.BLACK);
		jb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new InstallDemo();
			}
			
		});
		contentPane.add(jb3);
		jb4 = new JButton("退出");
		jb4.setBounds(550, 300, 150, 50);
		jb4.setFont(new Font("微软雅黑", Font.BOLD, 20));
		jb4.setForeground(Color.BLACK);
		jb4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==jb4) {
					dispose();
				}
			}
			
		});
		contentPane.add(jb4);
	}
	
	public void main(String[] args) {
		new MainTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
 
}