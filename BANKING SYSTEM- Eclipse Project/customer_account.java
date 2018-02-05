import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.*;

public class customer_account extends JFrame implements ActionListener,ItemListener
{
 JLabel  l0,l,la,l1,l2,l3,l4,l5,l6,l7,l8,l9,l11,l12,l13;
 JTextField t0,t1,t2,t3,t5,t6,t7,t12,t13;
 JButton save,modify,delete,clear;
 JComboBox s,c,at;
 
 JPanel p,p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p_main;
 ResultSet rs;
 GridLayout g;
 FlowLayout f;

Checkbox r1,r2;
CheckboxGroup bg;
 String s0,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13;
 public customer_account(){
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
		
		t5=new JTextField(15);
		t6=new JTextField(15);
		t7=new JTextField(15);
		
		t12=new JTextField(15);
		t13=new JTextField(15);
		
		s=new JComboBox();
		c=new JComboBox();
		at=new JComboBox();
		
	
		bg=new CheckboxGroup();
		r1=new Checkbox("Male",bg,true);
		r2=new Checkbox("Female",bg,false);
	
		
		
		save=new JButton("SAVE");
		modify=new JButton("MODIFY");
		
		delete=new JButton("DELETE");
		clear=new JButton("CLEAR");
			
		s.addItem("Punjab");
		s.addItem("Haryana");
		s.addItem("Rajasthan");
		s.addItem("Maharashtra");
		s.addItem("Himachal Pradesh");
		
		c.addItem("Amritsar");
		c.addItem("Chandigarh");
		c.addItem("Jaipur");
		c.addItem("Pune");
		c.addItem("Dulhousie");
		
		at.addItem("Current A/C");
		at.addItem("Savings A/C");
		
		
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
		
		
		

		p9.add(t0);
		p0.add(t1);
		p1.add(t2);
		p2.add(t3);
		p3.add(r1);
		
		p3.add(r2);
		p4.add(t5);
		p5.add(t6);
		p6.add(t7);
		p7.add(s);
		p8.add(c);
		
		p10.add(at);
		p11.add(t12);
		p12.add(t13);
		p13.add(save);
		p13.add(modify);
		p13.add(delete);
		p13.add(clear);
		
		p_main.add(l0);
		p_main.add(p9);
		p_main.add(l1);
		p_main.add(p0);
		p_main.add(l2);
		p_main.add(p1);
		p_main.add(l3);
		p_main.add(p2);
		p_main.add(l4);
		p_main.add(p3);
		p_main.add(l5);
		p_main.add(p4);
		p_main.add(l6);
		p_main.add(l6);
		p_main.add(p5);
		p_main.add(l7);
		p_main.add(p6);
		p_main.add(l8);
		p_main.add(p7);
		p_main.add(l9);
		p_main.add(p8);
		
		p_main.add(l11);
		p_main.add(p10);
		p_main.add(l12);
		p_main.add(p11);
		p_main.add(l13);
		p_main.add(p12);
		p_main.add(p13);
		p_main.add(p13);
		p_main.add(p13);
		p_main.add(p13);
	
		
		add(p_main);
		
    save.addActionListener(this);
	modify.addActionListener(this);
	delete.addActionListener(this);
	clear.addActionListener(this);
	 }	
 
public static void main(String args[])
{
	customer_account ac=new customer_account ();
	ac.setVisible(true);
	ac.setSize(1000,900);
	ac.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ac.setTitle("Customer Account/BANKING SYSTEM/ SARANG KAUR(B.tech CSE 3rd yr GNDU Amritsar) copyright protection");
	
}

public void itemStateChanged(ItemEvent arg0) {
	// TODO Auto-generated method stub
	
}



public void actionPerformed(ActionEvent arg0) {
	
	//insertion begins
	
	if(arg0.getSource()==save)
	
	{
		if(t0.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Fill customer_id");
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
			JOptionPane.showMessageDialog(this,"Fill address");
		}
		else if (t5.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Fill phone");
		}
		else if (t6.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Fill mobile");
		}
		else if (t7.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Fill email");
		}
		else if (t12.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Fill amount");
		}
		else if (t13.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Fill date");
		}
		else
		{
			
		
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
	            if (r1.getState()==true)
	            {
	            	s4="male";
	            }
	            else if (r2.getState()==true)
	            {
	            	s4="female";
	            }
	            s5=t5.getText();
	            s6=t6.getText();
	            s7=t7.getText();
	            s8=(String)s.getSelectedItem();
	            s9=(String)c.getSelectedItem();
	            s11=(String)at.getSelectedItem();
	            s12=t12.getText();
	            s13=t13.getText();
	            t0.setText(null);
	            t1.setText(null);
	            t2.setText(null);
	            t3.setText(null);
	            t5.setText(null);
	            t6.setText(null);
	            t7.setText(null);
	            t12.setText(null);
	            t13.setText(null);
	           
	            String sp="insert into CUSTOMER_ACCOUNT values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(sp);
				
				
				ps.setString(1,s0);
				ps.setString(2,s1);
				ps.setString(3,s2);
				ps.setString(4,s3);
				ps.setString(5,s4);
				ps.setString(6,s5);
				ps.setString(7,s6);
				ps.setString(8,s7);
				ps.setString(9,s8);
				ps.setString(10,s9);
	           ps.setString(11,s11);
				ps.setString(12,s12);
				ps.setString(13,s13);
				
				
				System.out.print(s0+" "+s1+"  "+s2+" "+s3+s4+" "+s5+"  "+s6+" "+s7+s8+" "+s9+"  "+s11+" "+s12+" "+s13+" ");
				
				
				ps.executeQuery();
				
				con.close();
				}
	            
		
	            
	            
	            
		
	catch( Exception e)
	{
		e.printStackTrace();	}
  
	}
	}
	
	//modify begins
	
	if(arg0.getSource()==modify)
		
	{
		if(t0.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Fill customer_id");
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
			JOptionPane.showMessageDialog(this,"Fill address");
		}
		else if (t5.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Fill phone");
		}
		else if (t6.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Fill mobile");
		}
		else if (t7.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Fill email");
		}
		else if (t12.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Fill amount");
		}
		else if (t13.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Fill date");
		}
		else
		{
			
		
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
	            if (r1.getState()==true)
	            {
	            	s4="male";
	            }
	            else if (r2.getState()==true)
	            {
	            	s4="female";
	            }
	            s5=t5.getText();
	            s6=t6.getText();
	            s7=t7.getText();
	            s8=(String)s.getSelectedItem();
	            s9=(String)c.getSelectedItem();
	            s11=(String)at.getSelectedItem();
	            s12=t12.getText();
	            s13=t13.getText();
	            t0.setText(null);
	            t1.setText(null);
	            t2.setText(null);
	            t3.setText(null);
	            t5.setText(null);
	            t6.setText(null);
	            t7.setText(null);
	            t12.setText(null);
	            t13.setText(null);
	           
	            String sp="update customer_account set customer_first_name=?,customer_last_name=?,address=?,gender=?,phone=?,mobile=?,email=?,state=?,city=?,account_type=?,amount=?,date_of_opening=? where customer_id=?";
				PreparedStatement ps=con.prepareStatement(sp);
				
				
				//ps.setString(1,s0);
				ps.setString(1,s1);
				ps.setString(2,s2);
				ps.setString(3,s3);
				ps.setString(4,s4);
				ps.setString(5,s5);
				ps.setString(6,s6);
				ps.setString(7,s7);
				ps.setString(8,s8);
				ps.setString(9,s9);
	           ps.setString(10,s11);
				ps.setString(11,s12);
				ps.setString(12,s13);
				ps.setString(13,s0);
				
				System.out.print(s0+" "+s1+"  "+s2+" "+s3+" "+s4+" "+s5+"  "+s6+" "+s7+" "+s8+" "+s9+"  "+s11+" "+s12+" "+s13+" ");
				
				
				ps.executeQuery();
				JOptionPane.showMessageDialog(this,"Modified");
				con.close();
				}
	            
		
	            
	            
	            
		
	catch( Exception e)
	{
		e.printStackTrace();	}
  
	}
	}





//deletion begins

if(arg0.getSource()==delete)
	
{
	if(t0.getText().isEmpty())
	{
		JOptionPane.showMessageDialog(this,"Fill customer_id");
	}

	else
	{
		
	
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
            if (r1.getState()==true)
            {
            	s4="male";
            }
            else if (r2.getState()==true)
            {
            	s4="female";
            }
            s5=t5.getText();
            s6=t6.getText();
            s7=t7.getText();
            s8=(String)s.getSelectedItem();
            s9=(String)c.getSelectedItem();
            s11=(String)at.getSelectedItem();
            s12=t12.getText();
            s13=t13.getText();
            t0.setText(null);
            t1.setText(null);
            t2.setText(null);
            t3.setText(null);
            t5.setText(null);
            t6.setText(null);
            t7.setText(null);
            t12.setText(null);
            t13.setText(null);
           
            String sp="delete from customer_account where customer_id=?";
			PreparedStatement ps=con.prepareStatement(sp);
			
			
			ps.setString(1,s0);
			
			
			ps.executeQuery();
			JOptionPane.showMessageDialog(this,"Deleted");
			con.close();
			}
            
	
            
            
            
	
catch( Exception e)
{
	e.printStackTrace();	}

}
}
//clear operation begins

if (arg0.getSource()==clear)
{
	t0.setText(null);
    t1.setText(null);
    t2.setText(null);
    t3.setText(null);
    t5.setText(null);
    t6.setText(null);
    t7.setText(null);
    t12.setText(null);
    t13.setText(null);
}
}

}



