package com.mooc.login;
 
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
 
import javax.swing.Icon;                                                               
import javax.swing.ImageIcon;
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

public class Login extends JFrame{
     
	private JPanel contentPane;
	private JButton btn1,btn2,btn3;
	private JTextField userName;
	private JPasswordField password;
	private JLabel label1,label2;
	
	private int LOGIN_WIDTH=360;
	private int LOGIN_HEIGTH=350;
	
	
	Connection conn;
	Statement stam;
	
	public Login() {
		
	     setTitle("����ϵͳ");  //���ô������
		 setBounds(100, 50, LOGIN_WIDTH, LOGIN_HEIGTH	);  //���ô��������Լ�����
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //���ô���ɹر�
		 setResizable(false);  //���ô����С�����Ըı�
		 setVisible(true);    //���ô���ɼ�
		 //���ô������ͼ��
		 setIconImage(
			Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/log.jpg"))	 	 
				 );
		 /**
		  * ���һ�����������������
		  */
		 contentPane = new JPanel();
         contentPane.setBackground(Color.WHITE);
		 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	   	 setContentPane(contentPane);
		 contentPane.setLayout(null);	 
		 //�˺ű�ǩ
		 label1=new JLabel("");
		 label1.setBounds(80,76, 54, 28);
		 label1.setIcon(new ImageIcon(Login.class.getResource("/images/user.png"))); 
		 contentPane.add(label1);
		 
		 
		 //�����ǩ
		 label2=new JLabel("");
		 label2.setBounds(80, 135, 54, 28);
		 label2.setIcon(new ImageIcon(Login.class.getResource("/images/psw.png")));
		 contentPane.add(label2);
	
         //�˺������
		 userName=new JTextField();
		 userName.setBounds(139, 80, 161, 25);
		 contentPane.add(userName);
		 
		 //���������
		 password=new JPasswordField();
		 password.setBounds(139, 140, 161, 25);
		 
	     contentPane.add(password);
	     
	     
	     //��ť����¼
	     btn1=new JButton("��   ¼");
	     btn1.setBounds(95, 210, 80, 23);
	     //btn1.setIcon(new ImageIcon(Login.class.getResource("/images/btn1.png")));
	     btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btn1) {	 
					try {
						conn=jdbcUtil.getConnection();//��ȡ���ݿ�����
						stam= (Statement) conn.createStatement();  //����sql���ִ�ж���
						//��дsql���
						String sql="select * from user where username='"+userName.getText()+"'  and password='"+password.getText()+"'     ";
					    //ִ��sql���
						ResultSet rs=stam.executeQuery(sql);
						if(rs.next()) {
					    dispose();//�رյ�ǰ����							
		//				new Main();
					    new MainTest();
						}else {
							JOptionPane.showMessageDialog(btn1, "�û������������");
						}
					}catch (Exception e0) {
		//				JOptionPane.showMessageDialog(btn1, "�û������������");
						e0.printStackTrace();
					}finally {
						jdbcUtil.result(conn, stam);
						
					}
				}
			}
		});
	     contentPane.add(btn1);
	     //��ť���˳�
	     btn2=new JButton("��  ��");
	     btn2.setBounds(210, 210, 80, 23);
	     //btn2.setIcon( new ImageIcon(Login.class.getResource("/images/exit.png")));
	     btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btn2) {
				    dispose();
				}
			}
		});
	     
	     
	     contentPane.add(btn2);     
	     //��ť-ע��
	     btn3=new JButton("ע        ��");
	     btn3.setBounds(95,240,200, 23);
	     //btn3.setIcon(new ImageIcon(Login.class.getResource("/images/regier.png")));
	     btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
 
				 dispose();//�رյ�¼����
				new Register().addMan(); // ��ע�ᴰ��
				
			}
		});
	     contentPane.add(btn3);
	     
	}		
	public JTextField getUserName() {
		return userName;
	}
	public void setUserName(JTextField userName) {
		this.userName = userName;
	}
	public JPasswordField getPassword() {
		return password;
	}
	public void setPassword(JPasswordField password) {
		this.password = password;
	}
	public static void main(String[] args) {
		new Login();
	}	
		
	
}