import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class signup extends JFrame implements ActionListener{
	JButton b1,b2,b3,b4;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11;
	JLabel l1,l2;
	JTextField t1,t2;
	GridLayout g,h;
	FlowLayout f;
	ResultSet q;
	public signup()
	{
		setTitle("Signup/Inventory System/ NITIN JINDAL(B.tech CSE 3rd yr GNDU Amritsar) copyright protection");
		f=new FlowLayout(FlowLayout.CENTER);
		h=new GridLayout(2,1);
		g=new GridLayout(2,2);
		b1=new JButton("Save");
		b2=new JButton("Modify");
		b3=new JButton("remove");
		b4=new JButton("search");
		l1=new JLabel("Username*");
		l2=new JLabel("password");
		t1=new JTextField(10);
		t2=new JTextField(10);
		p2=new JPanel();
		p2.add(t1);
		p3=new JPanel();
		p3.add(t2);
		p4=new JPanel(g);
		p4.add(l1);
		p4.add(p2);
		p4.add(l2);
		p4.add(p3);
		p1=new JPanel();
		p7=new JPanel();
		p8=new JPanel();
		p9=new JPanel();
		p10=new JPanel();
		p1.add(b1);
		p7.add(b2);
		p8.add(b3);
		p9.add(b4);
		p10.add(p1);
		p10.add(p7);
		p10.add(p8);
		p10.add(p9);
		p5=new JPanel(h);
		p5.add(p4);
		p11=new JPanel(f);
		p11.add(p5);
		
		p5.add(p10);
		add(p11);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==b1)
		{
			if(t1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill Username");
			}
			else if(t2.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill password");
			}
			else
			{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=null;
			String str="jdbc:oracle:thin:@localhost:1521:";
			con=DriverManager.getConnection(str,"abhay","abhay");
			System.out.print("connection done");
			String sp="insert into user_account values(?,?)";
			PreparedStatement ps=con.prepareStatement(sp);
			String s1=t1.getText();
			String s2=t2.getText();
			ps.setString(1,s1);
			ps.setString(2,s2);
			ps.executeQuery();
			con.close();
			JOptionPane.showMessageDialog(this, "SAVED");
			t1.setText(null);
			t2.setText(null);
			
		}
		
		catch(Exception e)
		
		{
			JOptionPane.showMessageDialog(this, "username already exsist");	
			
		}
		}}
		
		if(arg0.getSource()==b2)
		{
			if(t1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill username code");
			}
			else if(t2.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill password");
			}
			else
			{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=null;
			String str="jdbc:oracle:thin:@localhost:1521:";
			con=DriverManager.getConnection(str,"abhay","abhay");
			System.out.print("connection done");
			
			String sp1="select * from user_account where username=?";
			PreparedStatement ps1=con.prepareStatement(sp1);
			String s11=t1.getText();
			ps1.setString(1,s11);
			q=ps1.executeQuery();
			if(q.next())
			{
				String sp="update user_account password=? where username=?";
				PreparedStatement ps=con.prepareStatement(sp);
				String s1=t1.getText();
				String s2=t2.getText();
				ps.setString(1,s2);
				ps.setString(2,s1);
				ps.executeQuery();
				con.close();
				JOptionPane.showMessageDialog(this, "Modified");
				t1.setText(null);
				t2.setText(null);
				
			}
			else
			{
				JOptionPane.showMessageDialog(this, "username doesn,t exsist");
					}
			
		}
		
		catch(Exception e)
		
		{
			JOptionPane.showMessageDialog(this, "invalid username");	
			
		}
		}}
		if(arg0.getSource()==b3)
		{
			if(t1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill username");
			}
			else
			{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=null;
			String str="jdbc:oracle:thin:@localhost:1521:";
			con=DriverManager.getConnection(str,"abhay","abhay");
			System.out.print("connection done");
			String sp1="select * from user_account where username=?";
			PreparedStatement ps1=con.prepareStatement(sp1);
			String s11=t1.getText();
			ps1.setString(1,s11);
			q=ps1.executeQuery();
			if(q.next())
			{
			String sp="delete user_account where username=?";
			PreparedStatement ps=con.prepareStatement(sp);
			String s1=t1.getText();
		//	String s2=t2.getText();
			ps.setString(1,s1);
			//ps.setString(2,s2);
			ps.executeQuery();
			con.close();
			JOptionPane.showMessageDialog(this, "deleted");
			t1.setText(null);
			t2.setText(null);
			}
			else
				{
				JOptionPane.showMessageDialog(this, "username doesn,t exsist");
				}
				}
		
		catch(Exception e)
		
		{
			JOptionPane.showMessageDialog(this, "invalid username");
			e.printStackTrace();	
			
		}
		}}
		if(arg0.getSource()==b4)
		{
			if(t1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill username");
			}
			else{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=null;
			String str="jdbc:oracle:thin:@localhost:1521:";
			con=DriverManager.getConnection(str,"abhay","abhay");
			System.out.print("connection done");
			String sp1="select * from user_account where username=?";
			PreparedStatement ps1=con.prepareStatement(sp1);
			String s11=t1.getText();
			ps1.setString(1,s11);
			q=ps1.executeQuery();
			if(q.next())
			{
			String sp="select * from user_account where username=?";
			PreparedStatement ps=con.prepareStatement(sp);
			String s1=t1.getText();
			ps.setString(1,s1);
			q=ps.executeQuery();
			if(q.next())
			{
				//String m=q.getString(1);
				String n=q.getString(2);
				t2.setText(n);
			}
			
			con.close();
			
		}
			else {
				JOptionPane.showMessageDialog(this, "username doesn't exsist");
			}
			}
		
		catch(Exception e)
		
		{
		e.printStackTrace();	
			
		}
		}
		}	}
	public static void main(String a[])
{
	signup c=new signup();
	c.setSize(400,200);
	c.setVisible(true);
}
}
