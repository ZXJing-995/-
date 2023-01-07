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
		setTitle("��ѯ����");
		setSize(GAME_WIDTH, GAME_HEIGTH);
		//setBounds(50,50,700,600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	setVisible(true);
		setBackground(Color.darkGray);
		setLocationRelativeTo(null);// ������ʾ
		//���һ�����������������
		contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	   	setContentPane(contentPane);
	   	contentPane.setLayout(null);
	   	
//	   	label1 = new JLabel("�˱��ı��");
//		label1.setBounds(20, 20, 70, 70);
		label1 = new JLabel("�˱�����");
		label1.setBounds(280, 60, 70, 70);
//		label3 = new JLabel("���");
//		label3.setBounds(20, 100, 70, 70);
		label2 = new JLabel("����ʱ��");
		label2.setBounds(280, 100, 70, 70);
		label3 = new JLabel("��������");
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
		jb1 = new JButton("��ѯ");
		jb1.setBounds(540, 100, 60, 30);
		jb1.addActionListener(new ActionListener() {
		//ͨ���˱����ݲ�ѯ
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
							System.out.println("�˱��ı��Ϊ"+id+",�˱�����Ϊ"+name+",���Ϊ"+price+",����ʱ��Ϊ"+time+",��������Ϊ"+type);
							//����һ����ʾ��
							JOptionPane.showMessageDialog(jb1,"��ѯ�ɹ�");
						}
							JOptionPane.showMessageDialog(jb1,"��ѯʧ��");
					}catch(Exception e1) {
						System.out.println(e1);
					}
				}
			}
			
		}); //����¼�����
		contentPane.add(jb1);
		
		jb2 = new JButton("��ѯ");
		jb2.setBounds(540, 140, 60, 30);
		jb2.addActionListener(new ActionListener() {
		//ͨ������ʱ���ѯ
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
							System.out.println("�˱��ı��Ϊ"+id+",�˱�����Ϊ"+name+",���Ϊ"+price+",����ʱ��Ϊ"+time+",��������Ϊ"+type);
							//����һ����ʾ��
							JOptionPane.showMessageDialog(jb2,"��ѯ�ɹ�");
						}
							JOptionPane.showMessageDialog(jb2,"��ѯʧ��");
					}catch(Exception e2) {
						System.out.println(e2);
					}
				}
			}
			
		}); //����¼�����
		contentPane.add(jb2);
		
		jb3 = new JButton("��ѯ");
		jb3.setBounds(540, 180, 60, 30);
		jb3.addActionListener(new ActionListener() {
		//ͨ���������Ͳ�ѯ
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
							System.out.println("�˱��ı��Ϊ"+id+",�˱�����Ϊ"+name+",���Ϊ"+price+",����ʱ��Ϊ"+time+",��������Ϊ"+type);
							//����һ����ʾ��
							JOptionPane.showMessageDialog(jb3,"��ѯ�ɹ�");
						}
				//		else {
							JOptionPane.showMessageDialog(jb3,"��ѯʧ��");
				//		}
					}catch(Exception e3) {
						System.out.println(e3);
					}
				}
			}
			
		}); //����¼�����
		contentPane.add(jb3);
		
		jb4 = new JButton("�˳�");
		jb4.setBounds(540, 400, 60, 30);
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				if(e.getSource()==jb4) { 
				    dispose();
				    new MainTest();
				}
			}
		}); //����¼�����
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
