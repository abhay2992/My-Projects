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

public class suplier extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JButton b1,b2,b3,b4;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16;
	GridLayout g,g1;
	FlowLayout f;
	ResultSet q;
public suplier()
{
	setTitle("Supplier/Inventory System/ NITIN JINDAL(B.tech CSE 3rd yr GNDU Amritsar) copyright protection");
	g=new GridLayout(8,2);
	g1=new GridLayout(2,1);
	f=new FlowLayout(FlowLayout.CENTER);
	l1=new JLabel("supplier Code");
	l2=new JLabel("First Name");
	l3=new JLabel("Last Name");
	l4=new JLabel("Company Name");
	l5=new JLabel("Fill Address");
	l6=new JLabel("Phone Number");
	l7=new JLabel("Mobile");
	l8=new JLabel("E-mail");
	t1=new JTextField(15);
	t2=new JTextField(15);
	t3=new JTextField(15);
	t4=new JTextField(15);
	t5=new JTextField(15);
	t6=new JTextField(15);
	t7=new JTextField(15);
	t8=new JTextField(15);
	b1=new JButton("Save");
	b2=new JButton("Modify");
	b3=new JButton("Delete");
	b4=new JButton("Search");
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
	p13=new JPanel(g);
	p14=new JPanel();
	p15=new JPanel(g1);
	p16=new JPanel(f);
	p1.add(t1);
	p2.add(t2);
	p3.add(t3);
	p4.add(t4);
	p5.add(t5);
	p6.add(t6);
	p7.add(t7);
	p8.add(t8);
	p9.add(b1);
	p10.add(b2);
	p11.add(b3);
	p12.add(b4);
	p13.add(l1);
	p13.add(p1);
	p13.add(l2);
	p13.add(p2);
	p13.add(l3);
	p13.add(p3);
	p13.add(l4);
	p13.add(p4);
	p13.add(l5);
	p13.add(p5);
	p13.add(l6);
	p13.add(p6);
	p13.add(l7);
	p13.add(p7);
	p13.add(l8);
	p13.add(p8);
	p14.add(p9);
	p14.add(p10);
	p14.add(p11);
	p14.add(p12);
	p15.add(p13);
	p15.add(p14);
	p16.add(p15);
	add(p16);
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
			JOptionPane.showMessageDialog(this, "Fill suplier Code");
		}
		else if(t2.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Fill Name");
		}
		else if(t4.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Fill Company Name");
		}
		else if(t5.getText().isEmpty())
			
		{
			JOptionPane.showMessageDialog(this, "Fill Address");
		}
		else if(t6.getText().isEmpty()&& t7.getText().isEmpty() )
			
		{
			JOptionPane.showMessageDialog(this, "Fill Contact number");
		}
	
		else
		{
			try
			{
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection con=null;
				String str="jdbc:oracle:thin:@localhost:1521:";
				con=DriverManager.getConnection(str,"System","password");
				System.out.print("connection done");
				String sp1="select * from suplier where suplier_code=?";
				PreparedStatement ps1=con.prepareStatement(sp1);
				String s11=t1.getText();
				ps1.setString(1,s11);
				q=ps1.executeQuery();
				if(q.next())
				{
					JOptionPane.showMessageDialog(this, "suplier code already exists");
				}
				else
				{
					String sp="insert into suplier values(?,?,?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(sp);
					String s1=t1.getText();
					String s2=t2.getText();
					String s3=t3.getText();
					String s4=t4.getText();
					String s5=t5.getText();
					String s6=t6.getText();
					String s7=t7.getText();
					String s8=t8.getText();
					ps.setString(1,s1);
					ps.setString(2,s2);
					ps.setString(3,s3);
					ps.setString(4,s4);
					ps.setString(5,s5);
					ps.setString(6,s6);
					ps.setString(7,s7);
					ps.setString(8,s8);
					ps.executeQuery();
					con.close();
					JOptionPane.showMessageDialog(this, "SAVED");
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
					t5.setText(null);
					t6.setText(null);
					t7.setText(null);
					t8.setText(null);
					
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();	
			}
		}
		}
	if(arg0.getSource()==b2)
	{
		if(t1.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Fill suplier Code");
		}
		else if(t2.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Fill Name");
		}
		else if(t4.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Fill Company Name");
		}
		else if(t5.getText().isEmpty())
			
		{
			JOptionPane.showMessageDialog(this, "Fill Address");
		}
		else if(t6.getText().isEmpty()&& t7.getText().isEmpty() )
			
		{
			JOptionPane.showMessageDialog(this, "Fill Contact number");
		}
	

		else
		{
		try
			{
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection con=null;
				String str="jdbc:oracle:thin:@localhost:1521:";
				con=DriverManager.getConnection(str,"System","password");
				System.out.print("connection done");
				String sp1="select * from suplier where suplier_code=?";
				PreparedStatement ps1=con.prepareStatement(sp1);
				String s11=t1.getText();
				ps1.setString(1,s11);
				q=ps1.executeQuery();
				if(q.next())
				{
					String sp="update suplier set suplier_code=?, suplier_firstname=?, suplier_lasttname=?, company_name=?, address=?, phone=?, mobile_number=?, e_mail=? where suplier_code=?";
					PreparedStatement ps=con.prepareStatement(sp);
					String s1=t1.getText();
					String s2=t2.getText();
					String s3=t3.getText();
					String s4=t4.getText();
					String s5=t5.getText();
					String s6=t6.getText();
					String s7=t7.getText();
					String s8=t8.getText();
									
					ps.setString(1,s1);
					ps.setString(2,s2);
					ps.setString(3,s3);
					ps.setString(4,s4);
					ps.setString(5,s5);
					ps.setString(6,s6);
					ps.setString(7,s7);
					ps.setString(8,s8);
					ps.setString(9,s1);
					ps.executeQuery();
					con.close();
					JOptionPane.showMessageDialog(this, "Modified");
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
					t5.setText(null);
					t6.setText(null);
					t7.setText(null);
					t8.setText(null);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Invalid suplier code");
				}
			}
			
			catch(Exception e)
			
			{
				e.printStackTrace();	
				
			}}}
		if(arg0.getSource()==b3)
		{
			if(t1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill suplier code");
			}
			else
			{
			try
			{
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection con=null;
				String str="jdbc:oracle:thin:@localhost:1521:";
				con=DriverManager.getConnection(str,"System","password");
				System.out.print("connection done");
				String sp1="select * from suplier where suplier_code=?";
				PreparedStatement ps1=con.prepareStatement(sp1);
				String s11=t1.getText();
				ps1.setString(1,s11);
				q=ps1.executeQuery();
				if(q.next())
				{
				String sp="delete suplier where suplier_code=?";
				PreparedStatement ps=con.prepareStatement(sp);
				String s1=t1.getText();
				ps.setString(1,s1);
				ps.executeQuery();
				con.close();
				JOptionPane.showMessageDialog(this, "deleted");
				t1.setText(null);
				t2.setText(null);
				t3.setText(null);
				t4.setText(null);
				t5.setText(null);
				t6.setText(null);
				t7.setText(null);
				t8.setText(null);}
				
				
				else
					{
					JOptionPane.showMessageDialog(this, "invalid suplier code");
					}
					}
			
			catch(Exception e)
			
			{
			//	JOptionPane.showMessageDialog(this, "category is not empty");
			e.printStackTrace();	
				
			}
			}
		}	
	
	
	if(arg0.getSource()==b4)
	{
		if(t1.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"fill suplier code");
		}
		else
		{
		try
		{
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection con=null;
				String str="jdbc:oracle:thin:@localhost:1521:";
				con=DriverManager.getConnection(str,"System","password");
				System.out.print("connection done");
				String sp1="select * from suplier where suplier_code=?";
				PreparedStatement ps1=con.prepareStatement(sp1);
				String s11=t1.getText();
				ps1.setString(1,s11);
				q=ps1.executeQuery();
				if(q.next())
				{
					String sp="select * from suplier where suplier_code=?";
					PreparedStatement ps=con.prepareStatement(sp);
					String s1=t1.getText();
					ps.setString(1,s1);
					q=ps.executeQuery();
					if(q.next())
					{
						String n1=q.getString(2);
						String n2=q.getString(3);
						String n3=q.getString(4);
						String n4=q.getString(5);
						String n5=q.getString(6);
						String n6=q.getString(7);
						String n7=q.getString(8);
						t2.setText(n1);
						t3.setText(n2);
						t4.setText(n3);
						t5.setText(n4);
						t6.setText(n5);
						t7.setText(n6);
						t8.setText(n7);
						con.close();
					}
				}
					else
					{
						JOptionPane.showMessageDialog(this, "invalid suplier code");
					}
			}
			catch(Exception e)
			{
			e.printStackTrace();	
			}
			
		}
}

}

public static void main(String a[])
{
suplier k=new suplier();
k.setSize(800,400);
k.setVisible(true);
}
}
