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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


	public class amount_deposit  extends JFrame implements ActionListener,ItemListener
	{
		
		JLabel  l0,l,la,l1,l2,l3,l4,l5,l6,l7,l8,lcode,ldate;
		 JTextField t0,t1,t2,t3,t4,t5,t6,t7,tcode,tdate;
		 JButton b,save,clear,currentbal;
		 JPanel p,p0,p1,p2,p3,p4,p5,p6,p7,p8,p_main,ptcode,pdate;
		 ResultSet rs,rs1,rr,rs22;
		 GridLayout g;
		 FlowLayout f;
		 JComboBox m;
		 String s0,s1,s2,s3,s4,s5,s6,s7,s8,pbal_str,amt_str,cbal_str,tdated1,cid,dated,curbal;
		 int tt;
		 int pbal,amt,cbal;
		 String prev;
		
		 String n="Amount deposit";
		 String[] abb=new String [8];
		 String s[]=new String[15];
		 public amount_deposit(){
			lcode=new JLabel("Transaction code");
			ldate=new JLabel("Last Date of transaction ");
			    l0=new JLabel("Account No");
			    l1=new JLabel("Customer Firstname");
				l2=new JLabel("Customer Lastname");
				l3=new JLabel("Previous Balance");
				l4=new JLabel("Amount to be deposited");
				l5=new JLabel("Date of deposit");
				l6=new JLabel("Current Balance");
				l7=new JLabel("Mode");
				
				
				t0=new JTextField(5);
				t1=new JTextField(15);
				t2=new JTextField(15);
				t3=new JTextField(15);
				t4=new JTextField(15);
				t5=new JTextField(15);
				t6=new JTextField(10);
				tcode=new JTextField(15);
				tdate=new JTextField(15);
				m=new JComboBox();
				m.addItem("Cash");
				m.addItem("Cheque");
				m.addItem("Money transfer");
				
				save=new JButton("SAVE");
				clear=new JButton("CLEAR");
				b=new JButton("Get Details");
				currentbal=new JButton("Current Balance ");
				
				g=new GridLayout(15,2);
				f=new FlowLayout(FlowLayout.LEFT);
				p_main=new JPanel(g);
				p=new JPanel(f);
				p0=new JPanel();
				p1=new JPanel();
				p2=new JPanel();
				p3=new JPanel();
				p4=new JPanel();
				p5=new JPanel();
				p6=new JPanel();
				p7=new JPanel();
				p8=new JPanel();
				ptcode=new JPanel();
				pdate=new JPanel();
				p0.add(t0);
				p0.add(b);
				p1.add(t1);
				p2.add(t2);
				p3.add(t3);
				p4.add(t4);
				p5.add(t5);
				p6.add(t6);
				p6.add(currentbal);
				p7.add(m);
				p8.add(save);
				p8.add(clear);
				ptcode.add(tcode);
				pdate.add(tdate);
	
				p_main.add(lcode);
				p_main.add(ptcode);
				
				p_main.add(l0);
				p_main.add(p0);
				p_main.add(l1);
				p_main.add(p1);
				p_main.add(l2);
				p_main.add(p2);
				p_main.add(l3);
				p_main.add(p3);
				p_main.add(l4);
				p_main.add(p4);
				p_main.add(ldate);
				p_main.add(pdate);
				p_main.add(l5);
				p_main.add(p5);
				p_main.add(l6);
				p_main.add(p6);
				p_main.add(l7);
				p_main.add(p7);
				p_main.add(p8);
				
				add(p_main);
				
				save.addActionListener(this);
				clear.addActionListener(this);
				b.addActionListener(this);
				currentbal.addActionListener(this);
				
				
				//starts
				
	
				
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
									String ss[]=new String[1];
									ss[0]=rrs.getString(1);
									System.out.print(ss[0]);
								t5.setText(ss[0]);
									
									}
								
								
								String sp12="select * from transaction";
								PreparedStatement ps12=con.prepareStatement(sp12);
							    
								 ResultSet rs12=ps12.executeQuery();
								if(rs12.next())
								{
									while(rs12.next())
									 {
										 String []tt=new String[8];
										 tt[0]=rs12.getString(1);
										tcode.setText(tt[0]);
									 }
									
								}
								else
								{
									tcode.setText("500");
								}
								 
			 	}
			 	catch(Exception e)
			 	{
			 		e.printStackTrace();
			 			 	}
				
				//ends
		 }
		 
		 public static void main(String args[])
		 {
			amount_deposit  ad=new amount_deposit  ();
		 	ad.setVisible(true);
		 	ad.setSize(1000,900);
		 	ad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 	ad.setTitle("Amount Deposit/BANKING SYSTEM/ SARANG KAUR(B.tech CSE 3rd yr GNDU Amritsar) copyright protection");
		 	
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
								String ss[]=new String[1];
								ss[0]=rrs.getString(1);
								System.out.print(ss[0]);
								ad.t5.setText(ss[0]);
							
								}
							
							
							String sp12="select * from transaction";
							PreparedStatement ps12=con.prepareStatement(sp12);
						    
							 ResultSet rs12=ps12.executeQuery();
							if(rs12.next())
							{
								while(rs12.next())
								 {
									 String []tt=new String[8];
									 tt[0]=rs12.getString(1);
									 ad.tcode.setText(tt[0]);
								 }
								
							}
							else
							{
								 ad.tcode.setText("500");
							}
							 
		 	}
		 	catch(Exception e)
		 	{
		 		e.printStackTrace();
		 			 	}
		 	
		 }
		public void actionPerformed(ActionEvent arg0) {
			cid=t0.getText();
			dated=t5.getText();
			curbal=t6.getText();
	if(arg0.getSource()==currentbal)
		
	{
		if (t0.getText().isEmpty())
		
	{
		JOptionPane.showMessageDialog(this,"Fill Account No.");
					}

	else
	{
 int p1bal=Integer.parseInt(t3.getText());
         
         int amt1=Integer.parseInt(t4.getText());
         
         int c1bal=p1bal+amt1;
         String c1bal_st=String.valueOf(c1bal);
         t6.setText(c1bal_st);
	}
		
	}
			if(arg0.getSource()==b)
				
			{
				if (t0.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(this,"Fill Account No.");
								}
				
				try{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
					Connection con=null;
			String	str1="jdbc:oracle:thin:@localhost:1521:";
					con=DriverManager.getConnection(str1,"system","sarang");
					System.out.print("Connection done");
					
		
			            
			           
			            String s1=t0.getText();
						
						String sp="select * from customer_account where customer_id=? ";
						PreparedStatement ps=con.prepareStatement(sp);
					    ps.setString(1,s1);
						rs=ps.executeQuery();
						
						if(rs.next())
							{
							
							s[0]=rs.getString(2);
							s[1]=rs.getString(3);
							s[2]=rs.getString(4);
							s[3]=rs.getString(5);
							s[4]=rs.getString(6);
							s[5]=rs.getString(7);
							s[6]=rs.getString(8);
							s[7]=rs.getString(9);
							s[8]=rs.getString(10);
							s[9]=rs.getString(11);
							s[11]=rs.getString(12);
							
							prev=s[11];
							tdated1="no transaction";
							s[12]=rs.getString(13);
										
						
						
						
							t1.setText(s[0]);
							t2.setText(s[1]);
							
						
							System.out.print("dd1");
							String sp1="select * from transaction where cid=?";
							PreparedStatement ps1=con.prepareStatement(sp1);
						    ps1.setString(1,s1);
							rs1=ps1.executeQuery();
							System.out.print("dd2");
						
                                   while(rs1.next())
							{
								
								prev=rs1.getString(6);
								
								System.out.print(rs1.getString(7));

								tdated1=rs1.getString(7);
							}
								if (rs1.next())
								{
									String ss[]=new String[8];
									ss[0]=rs1.getString(1);
									ss[1]=rs1.getString(2);
									ss[2]=rs1.getString(3);
									ss[3]=rs1.getString(4);
									ss[4]=rs1.getString(5);
									ss[5]=rs1.getString(6);
									ss[6]=rs1.getString(7);
									ss[7]=rs1.getString(8);
								
							
								
								
							}
								
								else if(!rs1.next()&& rs.next())
									{ String  pr1=rs.getString(12);
								
									System.out.print("not");
								prev=rs.getString(12);
								System.out.print("inside not"+prev);
								t3.setText(pr1);
								
								}
								
								
									t3.setText(prev);	
							tdate.setText(tdated1);
							
							pbal=Integer.parseInt(t3.getText());
						con.close();
						}
				}
			            
			            
			            
				
			catch( Exception e)
			{
				e.printStackTrace();	}
		  
			}
			
			
		//insertion operation begins
		if(arg0.getSource()==save)
			
		{
			if(t0.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Fill account no");
			}
			else if (t1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Fill firstname");
			}
			
			else if (t2.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Fill lastname");
			}
			else if (t3.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Fill previous balance");
			}
			else if (t4.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Fill amt to be deposited");
			}
			else if (t5.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Fill date of deposit");
			}
			
			else
			{
				
				
				pbal_str=t3.getText();
				amt_str=t4.getText();
				cbal_str=t6.getText();
				pbal=Integer.parseInt(pbal_str);
				amt=Integer.parseInt(amt_str);
				cbal=Integer.parseInt(pbal_str)+Integer.parseInt(amt_str);
				try{
					
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
					Connection con=null;
			String	str1="jdbc:oracle:thin:@localhost:1521:";
					con=DriverManager.getConnection(str1,"system","sarang");
					System.out.print("Connection done");
			       
					s0=t0.getText();
					
			            s1=t1.getText();
			            s2=t2.getText();
			            s3=t3.getText();
			           
			            s4=t4.getText();
			           
			            s5=t5.getText();
			            s6=t6.getText();
			           
			            s7=(String)m.getSelectedItem();
			            String ttcode=tcode.getText();
			            
			        
			        
			        String spp="select * from transaction where tid=? ";
					PreparedStatement pss=con.prepareStatement(spp);
				    pss.setString(1,ttcode);
					rr=pss.executeQuery();
		if(rr.next())
		{
			JOptionPane.showMessageDialog(this,"Transaction code already exist");
		}
		else
			{String sp="insert into transaction values(?,?,?,?,?,?,?,?)";
						PreparedStatement ps=con.prepareStatement(sp);
														ps.setInt(1,Integer.parseInt(ttcode));
						ps.setInt(2,Integer.parseInt(s0));
						ps.setString(3,n);
					ps.setInt(4,pbal);
					 ps.setInt(5,amt);
						ps.setInt(6,cbal);
					ps.setString(7,s5);
			          ps.setString(8,s7);
			            
			            
			            
						ps.executeQuery();
			          
					
					
						
						//select transc begins
						
						
						String sp22="select * from transc where cid=? and dated=?";
						PreparedStatement ps22=con.prepareStatement(sp22);
					    ps22.setString(1,cid);
					    ps22.setString(2,t5.getText());
						rs22=ps22.executeQuery();
						
						if(rs22.next())
							{
							//JOptionPane.showMessageDialog(this,"exists");
							String sp1="update transc set cbal=? where cid=? and dated=? ";
							PreparedStatement ps1=con.prepareStatement(sp1);
							ps1.setString(1,curbal); 
							ps1.setString(2,cid);
							    ps1.setString(3,dated);
					    	    ps1.executeQuery();
							    con.close();
							    JOptionPane.showMessageDialog(this," saved");
							}
						else
						{
							String sp1="insert into transc values(?,?,?,?)";
							PreparedStatement ps1=con.prepareStatement(sp1);
							
							String t1code=tcode.getText();
							s0=t0.getText();
							String s5=t5.getText();
							cbal_str=t6.getText();
							
							ps1.setInt(1,Integer.parseInt(t1code));
							ps1.setInt(2,Integer.parseInt(s0));
							ps1.setInt(3,cbal);
						    ps1.setString(4,s5);
						    ps1.executeQuery();
						    JOptionPane.showMessageDialog(this,"Transaction saved");
					
							}
						//select transc ends
						
						
			            	
						con.close();
						}
				}
				
			 
				
			catch( Exception e)
			{
				e.printStackTrace();	}
		  
			}
			}
		
		
		//clear operation begins
		
		if (arg0.getSource()==clear)
		{
		tcode.setText(null);
		t0.setText(null);
		t1.setText(null);
		t2.setText(null);
		t3.setText(null);
		t4.setText(null);
		tdate.setText(null);
		t5.setText(null);
		t6.setText(null);

		
		}
		
		}	
		public void itemStateChanged(ItemEvent arg0) {
		
			
		}

}
