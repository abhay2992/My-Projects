
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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


	public class view_interest  extends JFrame implements ActionListener,ItemListener
	{
		
		JLabel  l0,l1,l2,l3,l4,l5;
		 JTextField t0,t1,t2,t3,t4,t5;
		 JPanel p,p0,p1,p2,p3,p4,p5,p6,p7,p8,p_main;
		 ResultSet rs,rs1,rr,rs22;
		 GridLayout g;
		 FlowLayout f;
		 JButton b,tb;
		 String s0,s1,s2,s3,s4,s5,s6;
		 public view_interest(){
				
				    l0=new JLabel("Account No");
				    l1=new JLabel("Customer Firstname");
					l2=new JLabel("Customer Lastname");
					l3=new JLabel("Closing Balance");
					l4=new JLabel("Interest Incurred");
					l5=new JLabel("Current Balance");
					
					t0=new JTextField(5);
					t1=new JTextField(15);
					t2=new JTextField(15);
					t3=new JTextField(15);
					t4=new JTextField(15);
					t5=new JTextField(15);
					
					b=new JButton("Get Details");
					tb=new JButton("Total Balance");
					
					g=new GridLayout(8,2);
					f=new FlowLayout(FlowLayout.LEFT);
					p_main=new JPanel(g);
					p=new JPanel(f);
					p0=new JPanel();
					p1=new JPanel();
					p2=new JPanel();
					p3=new JPanel();
					p4=new JPanel();
					p5=new JPanel();
					
					p0.add(l0);
					p0.add(t0);
					p0.add(b);
					p1.add(l1);
					p1.add(t1);
					p2.add(l2);
					p2.add(t2);
					p3.add(l3);
					p3.add(t3);
					p4.add(l4);
					p4.add(t4);
					p4.add(tb);
					p5.add(l5);
					p5.add(t5);
				
				
					p_main.add(p0);
					
					p_main.add(p1);
					
					p_main.add(p2);
					
					p_main.add(p3);
					
					p_main.add(p4);
				
					p_main.add(p5);
					
					add( p_main);
					b.addActionListener(this);
					tb.addActionListener(this);
		 }         
			
		 
		 public static void main(String args[])
		 {
			view_interest vi=new view_interest();
		 	vi.setVisible(true);
		 	vi.setSize(1000,900);
		 	vi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 	vi.setTitle("View Interest/BANKING SYSTEM/ SARANG KAUR(B.tech CSE 3rd yr GNDU Amritsar) copyright protection");
		 }
		 
		
		public void actionPerformed(ActionEvent arg0) {
			
			 {
				 int b1,b2,b3;
//total bal starts 
				 if(arg0.getSource()==tb)
				 {
					 if (t3.getText().isEmpty())
					 {
						 JOptionPane.showMessageDialog(this,"Fill Current Bal");
					 }
					 
					 else if (t4.getText().isEmpty())
					 {
						 JOptionPane.showMessageDialog(this,"Fill Interest Incurred");
					 }
					 else
					 {
						 b1=Integer.parseInt(t3.getText());
						 b2=Integer.parseInt(t4.getText());
						 b3=b1+b2;
						 t5.setText(String.valueOf(b3));
					 }
				 }
				                           // total bal ends
	 //show starts
				 if(arg0.getSource()==b)
				 {
					 
				
				 try
				 {
					DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
								Connection con=null;
						String	str1="jdbc:oracle:thin:@localhost:1521:";
								con=DriverManager.getConnection(str1,"system","sarang");
								System.out.print("Connection done in main");
								
								s0=t0.getText();
					            s1=t1.getText();
					            s2=t2.getText();
					            s3=t3.getText();
					            s4=t4.getText();
					            s5=t5.getText();
					            
								String sp="select * from customer_account,transc,interest where customer_account.customer_id=? and transc.cid=?";
								PreparedStatement ps=con.prepareStatement(sp);
							    ps.setString(1,t0.getText());
							    ps.setString(2,t0.getText());
							   
								  rs=ps.executeQuery();
								  System.out.print("sss");
								 String []tt=new String[25];
								
									while(rs.next())
									 {
										
										 tt[0]=rs.getString(1);
										 tt[1]=rs.getString(2);
										 tt[2]=rs.getString(3);
										tt[3]=rs.getString(16);
										 tt[4]=rs.getString(20);
										 
				                         
									 }
									
									 
									t1.setText(tt[1]);
									t2.setText(tt[2]);
									t3.setText(tt[3]);
									t4.setText(tt[4]);
									
				 }
				 
				 
								catch(Exception e)
							 	{
							 		e.printStackTrace();
							 			 	}		
							}
			 }
		}
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
