
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.*;

public class view_customer_details extends JFrame implements ActionListener,ItemListener
{
	JLabel  l0,l,la,l1,l2,l3,l4,l5,l6,l7,l8,l9,l11,l12,l13;
	 JTextField t0,t1,t2,t3,t4,t5,t6,t7,t8,t9,t11,t12,t13;
	 JButton b;
	 JPanel p,p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p_main;
	 ResultSet rs;
	 GridLayout g;
	 FlowLayout f;

	 
	 
	 public view_customer_details(){
		    l0=new JLabel("Account No");
		    l1=new JLabel("Customer Firstname");
			l2=new JLabel("Customer Lastname");
			l3=new JLabel("Address");
			l4=new JLabel("Gender");
			l5=new JLabel("Phone");
			l6=new JLabel("Mobile");
			l7=new JLabel("Email");
			l8=new JLabel("State");
			l9=new JLabel("City");
			l11=new JLabel("Account Type");
			l12=new JLabel("Amount(Deposited)Op.Bal");
			l13=new JLabel("Date of Opening");
			
			t0=new JTextField(15);
			t1=new JTextField(15);
			t2=new JTextField(15);
			t3=new JTextField(15);
			t4=new JTextField(15);
			t5=new JTextField(15);
			t6=new JTextField(15);
			t7=new JTextField(15);
			t8=new JTextField(15);
			t9=new JTextField(15);
			t11=new JTextField(15);
			t12=new JTextField(15);
			t13=new JTextField(15);
			
			b=new JButton("Get Details");
			
			g=new GridLayout(20,2);
			p_main=new JPanel(g);
			f=new FlowLayout(FlowLayout.LEFT);
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
			p9=new JPanel();
			p10=new JPanel();
			p11=new JPanel();
			p12=new JPanel();
			p13=new JPanel();
			p14=new JPanel();
			
			
			
			
			p0.add(t0);
			p0.add(b);
			p1.add(t1);
			p2.add(t2);
			p3.add(t3);
			p4.add(t4);
			p5.add(t5);
			p6.add(t6);
			p7.add(t7);
			p8.add(t8);
			p9.add(t9);
			p11.add(t11);
			p12.add(t12);
			p13.add(t13);
			
			
			
			
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
			p_main.add(l5);
			p_main.add(p5);
			p_main.add(l6);
			p_main.add(p6);
			
			p_main.add(l7);
			p_main.add(p7);
			p_main.add(l8);
			p_main.add(p8);
			p_main.add(l9);
			p_main.add(p9);
			
			p_main.add(l11);
			p_main.add(p11);
			p_main.add(l12);
			p_main.add(p12);
			p_main.add(l13);
			p_main.add(p13);
			
			add(p_main);

			b.addActionListener(this);
			
			
			
			
	 }
	 public static void main(String args[])
	 {
		 view_customer_details vc=new view_customer_details ();
	 	vc.setVisible(true);
	 	vc.setSize(1000,900);
	 	vc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	vc.setTitle("View Customer Details/BANKING SYSTEM/ SARANG KAUR(B.tech CSE 3rd yr GNDU Amritsar) copyright protection");
	 	
	 }
	 
	 
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource()==b)
		{
			if (t0.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Fill Account No.");
							}
			else
			{
				try{
					Connection con;
					DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
					 con=null;
						
						String	str="jdbc:oracle:thin:@localhost:1521:";
						 
						con=DriverManager.getConnection(str,"system","sarang");
						System.out.print("Connection done");
						String s1=t0.getText();
						
						String sp="select * from customer_account where customer_id=? ";
						PreparedStatement ps=con.prepareStatement(sp);
					ps.setString(1,s1);
						rs=ps.executeQuery();
						
						if(rs.next())
							{
							String s[]=new String[15];
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
							s[12]=rs.getString(13);
										
							
							
							
							
							
						
							t1.setText(s[0]);
							t2.setText(s[1]);
							t3.setText(s[2]);
							t4.setText(s[3]);
							t5.setText(s[4]);
							t6.setText(s[5]);
							t7.setText(s[6]);
							t8.setText(s[7]);
							t9.setText(s[8]);
							t11.setText(s[9]);
							t12.setText(s[11]);
							t13.setText(s[12]);
							
							}
						else
						{
							JOptionPane.showMessageDialog(this,"Invalid customer id");
						}
						con.close();
					
				}
				catch(Exception e)
				{
					
				}
			}
				
		}
			
		}

	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
