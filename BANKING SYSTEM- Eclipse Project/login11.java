import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.*;
import java.sql.ResultSet;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class login11 extends JFrame implements ActionListener
{
	JLabel  l0,l1,l2,l3,l4,l5;
	 JTextField t0,t2,t3,t4,t5;
	 TextField t1;
	 JPanel p,p0,p1,p2,p3,p4,p5,p6,p7,p8,p_main;
	 ResultSet rs,rs1,rr,rs22;
	 GridLayout g;
	 FlowLayout f,f1;
	 JButton b,b1;
	String s1,s2;
	 public login11()
	 {
		
		 f=new FlowLayout(FlowLayout.LEFT);
		 f1=new FlowLayout(FlowLayout.CENTER);
		 g=new GridLayout(5,2);
		 l0=new JLabel("Username ");
		 
		 l1=new JLabel("Password ");
		 l2=new JLabel("WELCOME TO STATE BANK OF INDIA");
		 
		 
		 t0=new JTextField(15);
		 t1=new TextField(15);
		t1.setEchoChar('*');
		
		 
		 b=new JButton("Log In");
		 b1=new JButton("Exit");
		 p=new JPanel(g);
		 p0=new JPanel(f);
		 p1=new JPanel(f);
		 p2=new JPanel();
		 p3=new JPanel();
		 
		 p3.add(l2);
		 p0.add(l0);
		 p0.add(t0);
		 p1.add(l1);
		 p1.add(t1);
		 p2.add(b);
		 p2.add(b1);
		 
		 p.add(p3);
		 p.add(p0);
		 p.add(p1);
		 p.add(p2);
		 add(p);
		  b.addActionListener(this);
		 b1.addActionListener(this);
		 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		s1=t0.getText();
		s2=t1.getText();
		if (arg0.getSource()==b)
		{
			if (t0.getText().isEmpty())
				
			{
				JOptionPane.showMessageDialog(this,"Username");
							}
		
		else if (t1.getText().isEmpty())
			
		{
			JOptionPane.showMessageDialog(this,"Password");
						}
		else
			try{
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
							Connection con=null;
					String	str1="jdbc:oracle:thin:@localhost:1521:";
							con=DriverManager.getConnection(str1,"system","sarang");
							System.out.print("Connection done in main");
			
							String sp="select * from login where username=? and password=?";
							PreparedStatement ps=con.prepareStatement(sp);
						ps.setString(1,s1);
						ps.setString(2,s2);
							rs=ps.executeQuery();
			if(rs.next())
			{
			
				main1 k=new main1();
				k.setSize(1000,1000);
				k.setVisible(true);
			}
			else 
			{
				JOptionPane.showMessageDialog(this,"Invalid Login");
			}
			
			
			
			
			}
							catch(Exception e)
						 	{
						 		e.printStackTrace();
						 			 	}
		
		}
		
		if (arg0.getSource()==b1)
		{
			
			this.dispose();
		
		}
	}
	public static void main(String[] ss)
	{
		
		login11  ad=new login11  ();
	 	ad.setVisible(true);
	 	ad.setSize(1000,900);
	 	
	 	ad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	ad.setTitle("Login Form/BANKING SYSTEM/ SARANG KAUR(B.tech CSE 3rd yr GNDU Amritsar) copyright protection");
	}
	 	
	}