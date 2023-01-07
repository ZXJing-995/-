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
	//窗口初始化
	JLabel jlabel1,jlabel2,jlabel3,jlabel4,jlabel5;
	JTextField account_id,account_name,account_price,account_time,account_type;
	JButton jb1,jb2,jb3,jb4,jb5;
	//创建构造方法
	public AccountDemo() {
		jlabel1 = new JLabel("账本的编号");
		jlabel1.setBounds(20, 20, 70, 70);
		jlabel2 = new JLabel("账本事项");
		jlabel2.setBounds(20, 60, 70, 70);
		jlabel3 = new JLabel("金额");
		jlabel3.setBounds(20, 100, 70, 70);
		jlabel4 = new JLabel("记账时间");
		jlabel4.setBounds(20, 140, 70, 70);
		jlabel5 = new JLabel("记账类型");
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
		jb1 = new JButton("增加");
		jb1.setBounds(20, 230, 60, 30);
		jb1.addActionListener(this); //添加事件监听
		jb2 = new JButton("删除");
		jb2.setBounds(90, 230, 60, 30);
		jb2.addActionListener(this); //添加事件监听
		jb3 = new JButton("修改");
		jb3.setBounds(160, 230, 60, 30);
		jb3.addActionListener(this); //添加事件监听
		jb4 = new JButton("查询");
		jb4.setBounds(230, 230, 60, 30);
		jb4.addActionListener(this); //添加事件监听
		jb5 = new JButton("返回");
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
		//添加到面板
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
		setTitle("记一笔账");
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
	if(e.getActionCommand().equals("查询")) {
		//创建 Statement 对象
		try {
			Statement stmt = conn.createStatement();
			//String sql  = "select * from book where name='test'  ";
			String sql = "select * from account where name ='"+account_name.getText()+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
			//	System.out.println("查询成功");
				int id = rs.getInt(1);
				String name  = rs.getString(2);
				String price = rs.getString(3);
				String time = rs.getString(4);
				String type = rs.getString(5);
				System.out.println("账本的编号为"+id+",账本事项为"+name+",金额为"+price+",记账时间为"+time+",记账类型为"+type);
				//弹出一个提示框
					JOptionPane.showMessageDialog(this, "查询成功");
				}else {
					JOptionPane.showMessageDialog(this, "查询失败");
				}
		//		JOptionPane.showMessageDialog(this, "查询了一个记录");					
		}
		catch(Exception e1) {
			System.out.print(e);	
		}
	}
	if(e.getActionCommand().equals("增加")) {
		//创建一个preparedStatment
		PreparedStatement stat = null;
		//insert into book(id,name.price) values(7,"java",99)
		String sql = "insert into account (id,name,price,time,type) values(?,?,?,?,?)";  //?表示占位符
		try {
			PreparedStatement stat1=conn.prepareStatement(sql);
			//stat = conn.prepareStatement(sql);
			//添加3个参数
			stat1.setString(1, account_id.getText());      //获取图书编号的文本值
			stat1.setString(2, account_name.getText());   //获取图书名称的文本值
			stat1.setInt(3, Integer.valueOf(account_price.getText()).intValue());  //获取图书价格的文本值
			stat1.setString(4,account_time.getText());   //获取记账时间
			stat1.setString(5, account_type.getText());
			//更新操作
			stat1.executeUpdate();
			//弹出一个提示框
			JOptionPane.showMessageDialog(this, "增加了一个记录");					
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "编号已存在，添加失败");
			System.out.println("编号已存在，添加失败");
			System.out.print(e);	
			System.out.println("1111");
		}	
	}
	//删除图书信息操作
	if(e.getActionCommand().equals("删除")) {
		//创建一个preparedStatment
		PreparedStatement stat = null;
		//delete from book where name = "test"
		String sql = "delete from account where name=?";
		try {
			stat = conn.prepareStatement(sql);
			//添加1个参数
			stat.setString(1,account_name.getText());  //获取图书名称的文本值
			//更新操作
			//stat.executeUpdate();
			//弹出一个提示框
			
			int rows = stat.executeUpdate();
			if(rows>0) {
				//System.out.println("删除成功");
				JOptionPane.showMessageDialog(this, "删除成功");
			}else {
				JOptionPane.showMessageDialog(this, "删除失败");
				//System.out.println("删除失败");
			}
				
		} catch (Exception e2) {
			// TODO: handle exception
			//JOptionPane.showMessageDialog(this, "该记录不存在");
			System.out.print(e);	
		}
	}
	//修改
	if(e.getActionCommand().equals("修改")) {
		//创建一个preparedStatment
		PreparedStatement stat = null;
		//update book set name="java",price=99 where id=6;
		String sql ="update account set name=?,price=?,time=?,type=?where id=?";
		//String sql="update account (id,name,price,time,type) values(?,?,?,?,?)";
		try {
			stat = conn.prepareStatement(sql);
			//添加5个参数
			stat.setString(1, account_name.getText());  //名称
			System.out.println(account_name.getText());
			stat.setString(2,account_price.getText());
			System.out.println(account_price.getText());
			
			stat.setString(3, account_time.getText());
			System.out.println(account_time.getText());
			stat.setString(4, account_type.getText());
			System.out.println(account_type.getText());
			
			stat.setString(5, account_id.getText());
			System.out.println(account_id.getText());
			//更新操作
	//		stat.executeUpdate();
			//弹出一个提示框
			int rows = stat.executeUpdate();
			if(rows>0) {
				//System.out.println("删除成功");
				JOptionPane.showMessageDialog(this, "修改成功");
				System.out.println("账本的编号为"+account_id.getText()+",账本事项为"+account_name.getText()+",金额为"+account_price.getText()+",记账时间为"+account_time.getText()+",记账类型为"+account_type.getText());
			}else {
				JOptionPane.showMessageDialog(this, "修改失败");
				//System.out.println("删除失败");
			}
	//		JOptionPane.showMessageDialog(this, "修改了一个记录");	
	//		System.out.println("修改了一个记录");
			
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
