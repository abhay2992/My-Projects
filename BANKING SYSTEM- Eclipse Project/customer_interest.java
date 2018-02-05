

import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.*;


public class customer_interest  extends JFrame implements ActionListener,ItemListener
{
 JLabel  l0,l1,l2,l6,ldate,l_id,lint,lbal,linttt1,linttt2;
 JTextField t0,t1,t2,t6,tdate,tid,tint,tbal;
 JButton b,save,cal;
 JPanel p,p0,p1,p2,p6,p_main,pdate,ps,pi,pint,panel_bal;
 ResultSet rs,rrs;
 GridLayout g;
 FlowLayout f,f1;
 String s0,s1,sdate,s6;
 String dtt;
 
 
 public customer_interest (){
	    lint=new JLabel("Interest Incurred");
	    linttt1=new JLabel("Last Date of Interest Calculation");
	    linttt2=new JLabel("    ");
	    l_id=new JLabel("Interest ID");
	    l0=new JLabel("Account No");
	    l1=new JLabel("Customer Firstname");
		l2=new JLabel("Customer Lastname");
		l6=new JLabel("Current Balance");
		ldate=new JLabel("Last Date of Transaction");
		lbal=new JLabel("Total Balance");
		
		tint=new JTextField(15);
		tbal=new JTextField(15);
		tid=new JTextField(15);
		t0=new JTextField(15);
		t1=new JTextField(15);
		t2=new JTextField(15);
		t6=new JTextField(15);
		tdate=new JTextField(15);
		b=new JButton("Get Details");
		save=new JButton("Save");
		cal=new JButton("Calculate Interest");
		
		
		g=new GridLayout(8,2);
		p_main=new JPanel(g);
		f=new FlowLayout(FlowLayout.LEFT);
		f1=new FlowLayout(FlowLayout.RIGHT);
		p=new JPanel(f);
		p0=new JPanel();
		p1=new JPanel();
		p2=new JPanel();
		p6=new JPanel();
		ps=new JPanel();
		pdate=new JPanel();
		pi=new JPanel();
		pint=new JPanel();
		panel_bal=new JPanel();
		
		pi.add(l_id);
		pi.add(tid);
		p0.add(l0);
		p0.add(t0);
		p0.add(b);
		p1.add(l1);
		p1.add(t1);
		p2.add(l2);
		p2.add(t2);
		p6.add(l6);
		p6.add(t6);
		pdate.add(ldate);
		pdate.add(tdate);
		pint.add(lint);
		pint.add(tint);
		pint.add(cal);
		panel_bal.add(lbal);
		panel_bal.add(tbal);
		ps.add(save);
		
		p_main.add(pi);
		
		p_main.add(p0);
		
		p_main.add(p1);
		
		p_main.add(p2);
		
		p_main.add(p6);
		
		p_main.add(pdate);
		
		p_main.add(pint);
		
		p_main.add(panel_bal);
		
		p_main.add(ps);
		
		add(p_main);
		
		b.addActionListener(this);
		save.addActionListener(this);
		cal.addActionListener(this);
		
		try{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
						Connection con=null;
				String	str1="jdbc:oracle:thin:@localhost:1521:";
						con=DriverManager.getConnection(str1,"system","sarang");
						System.out.print("Connection done in main");
						
						
						
						String sp="select sysdate from dual";
						PreparedStatement ps=con.prepareStatement(sp);
					 
						 ResultSet rrs=ps.executeQuery();
						
						if(rrs.next())
							{
							
							String ss[]=new String[18];
							ss[0]=rrs.getString(1);
							dtt=ss[0].substring(0,10);
							//System.out.print(ss[0]);
							String []stt=new String[1];
							stt=ss[0].split("-");
							
						/*	ci.tid.setText(ss[0]);
						JOptionPane.showMessageDialog(ci,"exists");
						ci.	tdate.setText(ss[0]);*/
							System.out.print(dtt);
							
							/*for(int i=0;i<ss.length;i++)
							{
								System.out.println(stt[0]+" "+stt[1]+" "+stt[2]);
							//	String ab=stt[i].substring(1,3);
							//	System.out.print("ab="+ab);
							}*/
							//for ends
							
							}
					
						
						String sp123="select * from interest";
						PreparedStatement ps123=con.prepareStatement(sp123);
					    
						 ResultSet rs123=ps123.executeQuery();
						 String []tt=new String[4];
						//if(rs123.next())
						//{
							while(rs123.next())
							 {
								
								 tt[0]=rs123.getString(1);
								//JOptionPane.showMessageDialog(ci,tt[0]);
								
							 }
							
								 tid.setText(tt[0]);
							//}
							
							 
						//}
					//else
					//{
					//ci.tid.setText("600");
					//}
						
						 
	 	}
	 	catch(Exception e)
	 	{
	 		e.printStackTrace();
	 			 	}
	 	
 }
     public static void main(String args[])
    {
    	 customer_interest  ci=new  customer_interest();
 	     ci.setVisible(true);
 	     ci.setSize(1000,900);
 	     ci.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	     ci.setTitle("Customer Interest/BANKING SYSTEM/ SARANG KAUR(B.tech CSE 3rd yr GNDU Amritsar) copyright protection");
 	
 	  
 	  
 	 try{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
						Connection con=null;
				String	str1="jdbc:oracle:thin:@localhost:1521:";
						con=DriverManager.getConnection(str1,"system","sarang");
						System.out.print("Connection done in main");
						
						
						
						String sp="select sysdate from dual";
						PreparedStatement ps=con.prepareStatement(sp);
					 
						 ResultSet rrs=ps.executeQuery();
						
						if(rrs.next())
							{
							
							String ss[]=new String[18];
							ss[0]=rrs.getString(1);
							ci.dtt=ss[0].substring(0,10);
							//System.out.print(ss[0]);
							String []stt=new String[1];
							stt=ss[0].split("-");
							
						/*	ci.tid.setText(ss[0]);
						JOptionPane.showMessageDialog(ci,"exists");
						ci.	tdate.setText(ss[0]);*/
							System.out.print(ci.dtt);
							
							/*for(int i=0;i<ss.length;i++)
							{
								System.out.println(stt[0]+" "+stt[1]+" "+stt[2]);
							//	String ab=stt[i].substring(1,3);
							//	System.out.print("ab="+ab);
							}*/
							//for ends
							
							}
					
						
						String sp123="select * from interest";
						PreparedStatement ps123=con.prepareStatement(sp123);
					    
						 ResultSet rs123=ps123.executeQuery();
						 String []tt=new String[4];
						//if(rs123.next())
						//{
							while(rs123.next())
							 {
								
								 tt[0]=rs123.getString(1);
								//JOptionPane.showMessageDialog(ci,tt[0]);
								
							 }
							
								 ci.tid.setText(tt[0]);
							//}
							
							 
						//}
					//else
					//{
					//ci.tid.setText("600");
					//}
						
						 
	 	}
	 	catch(Exception e)
	 	{
	 		e.printStackTrace();
	 			 	}
	 	
 }
public void actionPerformed(ActionEvent arg0) {
	
	
	s0=t0.getText();
	
    s6=t6.getText();
    sdate=tdate.getText();
	if(arg0.getSource()==b)
			{
		if(t0.getText().isEmpty())
		{ 			JOptionPane.showMessageDialog(this,"Fill Customer Account");
			
		}
		else
		{
			try{
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
							Connection con=null;
					String	str1="jdbc:oracle:thin:@localhost:1521:";
							con=DriverManager.getConnection(str1,"system","sarang");
							System.out.print("Connection done");
							
							
							
							String sp="select * from customer_account,transc where customer_account.customer_id=? and transc.cid=?";
							PreparedStatement ps=con.prepareStatement(sp);
							ps.setString(1,t0.getText());
							ps.setString(2,t0.getText());
							
							 rrs=ps.executeQuery();
							
							if(rrs.next())
								{
								String []tt=new String[17];
								tt[0]=rrs.getString(1);
								tt[1]=rrs.getString(2);
								tt[2]=rrs.getString(3);
								tt[14]=rrs.getString(16);
								tt[15]=rrs.getString(17);
								
								System.out.print(tt[0]+"   "+tt[1]+" "+tt[2]+" "+tt[14]+" "+tt[15]);
								
		                     t0.setText(tt[0]);
		                     t1.setText(tt[1]);
		                     t2.setText(tt[2]);
		                     t6.setText(tt[14]);
		                     tdate.setText(tt[15]);
		                     
								
						}
							}
			catch(Exception e)
			{
			e.printStackTrace();	
			}
			
		}
		
		
	}
	
	
	//cal starts
	
	
	if(arg0.getSource()==cal)
	{
		int cbal=Integer.parseInt(s6);
		int  int1=cbal*(1)/(10000);
		int tba12l=int1+Integer.parseInt(s6);
	    tint.setText(String.valueOf(int1));
	    tbal.setText(String.valueOf(tba12l));
	    
	}
	
	//cal ends
	
	
	if (arg0.getSource()==save)
	{
		if(tid.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Fill Interest_id");
		}
		
		else
		{
			try{
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection con=null;
		String	str1="jdbc:oracle:thin:@localhost:1521:";
				con=DriverManager.getConnection(str1,"system","sarang");
				System.out.print("Connection done");
				
				/*String dts="select sysdate from dual";
				PreparedStatement psp=con.prepareStatement(dts);
			
				ResultSet rsr=psp.executeQuery();
				String tr[]=new String[10];
				if(rsr.next())
				{
				tr[0]=rsr.getString(1);
				JOptionPane.showMessageDialog(this,tr[0]);
					//String dtt=
				}*/
				String sp="select * from interest where dated=?";
				PreparedStatement ps=con.prepareStatement(sp);
	ps.setString(1,dtt);
				rs=ps.executeQuery();
				
				if(rs.next())
					{
					
					JOptionPane.showMessageDialog(this,"already calculated");
					
					}else
					{
						
					
			String sp1="insert into interest values(?,?,?,?)";
			PreparedStatement ps1=con.prepareStatement(sp1);
			
			String ttid=tid.getText();
			
			
            int intt=Integer.parseInt(tint.getText());
			ps1.setString(1,ttid);
			ps1.setString(2,s0);
			
			ps1.setString(3,String.valueOf(intt));
			
			ps1.setString(4,dtt);
			
        ps1.executeQuery();
        	
			//JOptionPane.showMessageDialog(this,"Interest  not saved");
		  JOptionPane.showMessageDialog(this,"Interest saved");
	
			}	            
			}

			
	

	
catch(Exception ed)
{
	ed.printStackTrace();
} }
}}

public void itemStateChanged(ItemEvent arg0) {
	// TODO Auto-generated method stub
	
}}