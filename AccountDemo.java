package com.mooc.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mooc.jdbcUtil.jdbcUtil;

 public class AccountDemo  extends JFrame implements ActionListener{
	//���ڳ�ʼ��
	JLabel jlabel1,jlabel2,jlabel3,jlabel4,jlabel5;
	JTextField account_id,account_name,account_price,account_time,account_type;
	JButton jb1,jb2,jb3,jb4,jb5;
	//�������췽��
	public AccountDemo() {
		jlabel1 = new JLabel("�˱��ı��");
		jlabel1.setBounds(20, 20, 70, 70);
		jlabel2 = new JLabel("�˱�����");
		jlabel2.setBounds(20, 60, 70, 70);
		jlabel3 = new JLabel("���");
		jlabel3.setBounds(20, 100, 70, 70);
		jlabel4 = new JLabel("����ʱ��");
		jlabel4.setBounds(20, 140, 70, 70);
		jlabel5 = new JLabel("��������");
		jlabel5.setBounds(20, 180, 70, 70);
		account_id = new JTextField();
		account_id.setBounds(100,20, 70, 30);
		account_name = new JTextField();
		account_name.setBounds(100,60, 70, 30);
		account_price = new JTextField();
		account_price.setBounds(100,100, 70, 30);
		account_time = new JTextField();
		account_time.setBounds(100,140, 70, 30);
		account_type = new JTextField();
		account_type.setBounds(100,180, 70, 30);
		jb1 = new JButton("����");
		jb1.setBounds(20, 230, 60, 30);
		jb1.addActionListener(this); //����¼�����
		jb2 = new JButton("ɾ��");
		jb2.setBounds(90, 230, 60, 30);
		jb2.addActionListener(this); //����¼�����
		jb3 = new JButton("�޸�");
		jb3.setBounds(160, 230, 60, 30);
		jb3.addActionListener(this); //����¼�����
		jb4 = new JButton("��ѯ");
		jb4.setBounds(230, 230, 60, 30);
		jb4.addActionListener(this); //����¼�����
		jb5 = new JButton("����");
		jb5.setBounds(30, 260, 200, 30);
		jb5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==jb5) {
					dispose();
					new MainTest();
				}
			}
			
		}); 
		//��ӵ����
		add(jlabel1);
		add(jlabel2);
		add(jlabel3);
		add(jlabel4);
		add(jlabel5);
		add(account_id);
		add(account_name);
		add(account_price);
		add(account_time);
		add(account_type);
		add(jb1);
		add(jb2);
		add(jb3);
		add(jb4);
		add(jb5);
		setTitle("��һ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setBounds(50, 50,500, 400);
		//setResizable(false);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e){
	// TODO Auto-generated method stub
	Connection conn=null;
	try {
		conn = jdbcUtil.getConnection();
	} catch (Exception e3) {
		// TODO Auto-generated catch block
		e3.printStackTrace();
	}
	if(e.getActionCommand().equals("��ѯ")) {
		//���� Statement ����
		try {
			Statement stmt = conn.createStatement();
			//String sql  = "select * from book where name='test'  ";
			String sql = "select * from account where name ='"+account_name.getText()+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
			//	System.out.println("��ѯ�ɹ�");
				int id = rs.getInt(1);
				String name  = rs.getString(2);
				String price = rs.getString(3);
				String time = rs.getString(4);
				String type = rs.getString(5);
				System.out.println("�˱��ı��Ϊ"+id+",�˱�����Ϊ"+name+",���Ϊ"+price+",����ʱ��Ϊ"+time+",��������Ϊ"+type);
				//����һ����ʾ��
					JOptionPane.showMessageDialog(this, "��ѯ�ɹ�");
				}else {
					JOptionPane.showMessageDialog(this, "��ѯʧ��");
				}
		//		JOptionPane.showMessageDialog(this, "��ѯ��һ����¼");					
		}
		catch(Exception e1) {
			System.out.print(e);	
		}
	}
	if(e.getActionCommand().equals("����")) {
		//����һ��preparedStatment
		PreparedStatement stat = null;
		//insert into book(id,name.price) values(7,"java",99)
		String sql = "insert into account (id,name,price,time,type) values(?,?,?,?,?)";  //?��ʾռλ��
		try {
			PreparedStatement stat1=conn.prepareStatement(sql);
			//stat = conn.prepareStatement(sql);
			//���3������
			stat1.setString(1, account_id.getText());      //��ȡͼ���ŵ��ı�ֵ
			stat1.setString(2, account_name.getText());   //��ȡͼ�����Ƶ��ı�ֵ
			stat1.setInt(3, Integer.valueOf(account_price.getText()).intValue());  //��ȡͼ��۸���ı�ֵ
			stat1.setString(4,account_time.getText());   //��ȡ����ʱ��
			stat1.setString(5, account_type.getText());
			//���²���
			stat1.executeUpdate();
			//����һ����ʾ��
			JOptionPane.showMessageDialog(this, "������һ����¼");					
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "����Ѵ��ڣ����ʧ��");
			System.out.println("����Ѵ��ڣ����ʧ��");
			System.out.print(e);	
			System.out.println("1111");
		}	
	}
	//ɾ��ͼ����Ϣ����
	if(e.getActionCommand().equals("ɾ��")) {
		//����һ��preparedStatment
		PreparedStatement stat = null;
		//delete from book where name = "test"
		String sql = "delete from account where name=?";
		try {
			stat = conn.prepareStatement(sql);
			//���1������
			stat.setString(1,account_name.getText());  //��ȡͼ�����Ƶ��ı�ֵ
			//���²���
			//stat.executeUpdate();
			//����һ����ʾ��
			
			int rows = stat.executeUpdate();
			if(rows>0) {
				//System.out.println("ɾ���ɹ�");
				JOptionPane.showMessageDialog(this, "ɾ���ɹ�");
			}else {
				JOptionPane.showMessageDialog(this, "ɾ��ʧ��");
				//System.out.println("ɾ��ʧ��");
			}
				
		} catch (Exception e2) {
			// TODO: handle exception
			//JOptionPane.showMessageDialog(this, "�ü�¼������");
			System.out.print(e);	
		}
	}
	//�޸�
	if(e.getActionCommand().equals("�޸�")) {
		//����һ��preparedStatment
		PreparedStatement stat = null;
		//update book set name="java",price=99 where id=6;
		String sql ="update account set name=?,price=?,time=?,type=?where id=?";
		//String sql="update account (id,name,price,time,type) values(?,?,?,?,?)";
		try {
			stat = conn.prepareStatement(sql);
			//���5������
			stat.setString(1, account_name.getText());  //����
			System.out.println(account_name.getText());
			stat.setString(2,account_price.getText());
			System.out.println(account_price.getText());
			
			stat.setString(3, account_time.getText());
			System.out.println(account_time.getText());
			stat.setString(4, account_type.getText());
			System.out.println(account_type.getText());
			
			stat.setString(5, account_id.getText());
			System.out.println(account_id.getText());
			//���²���
	//		stat.executeUpdate();
			//����һ����ʾ��
			int rows = stat.executeUpdate();
			if(rows>0) {
				//System.out.println("ɾ���ɹ�");
				JOptionPane.showMessageDialog(this, "�޸ĳɹ�");
				System.out.println("�˱��ı��Ϊ"+account_id.getText()+",�˱�����Ϊ"+account_name.getText()+",���Ϊ"+account_price.getText()+",����ʱ��Ϊ"+account_time.getText()+",��������Ϊ"+account_type.getText());
			}else {
				JOptionPane.showMessageDialog(this, "�޸�ʧ��");
				//System.out.println("ɾ��ʧ��");
			}
	//		JOptionPane.showMessageDialog(this, "�޸���һ����¼");	
	//		System.out.println("�޸���һ����¼");
			
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.print(e);	
		}
		
		
	}
	
}
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AccountDemo();

	}*/

	

}
