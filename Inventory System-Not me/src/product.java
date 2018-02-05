import java.awt.Color;
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


public class product extends JFrame implements ActionListener, ItemListener{
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3,t4,t5,t6;
	JComboBox c,c1;
	JButton b1,b2,b3,b4;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13;
	GridLayout g,y;
	FlowLayout f;
	ResultSet q,r;
	String m;
public product()
{	
	setTitle("product/Inventory System/ NITIN JINDAL(B.tech CSE 3rd yr GNDU Amritsar) copyright protection");
	
	c1=new JComboBox();
	try
	{
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection con=null;
	String str="jdbc:oracle:thin:@localhost:1521:";
	con=DriverManager.getConnection(str,"abhay","abhay");
	System.out.print("connection done");
	String sp1="select category_code from category";
	PreparedStatement ps1=con.prepareStatement(sp1);
	//ps1.setString(1,sp1);
	r=ps1.executeQuery();
	System.out.print("1");
	while(r.next())
	{
	String aa=r.getString(1);
	c1.addItem(aa);
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	

	String m=(String) c1.getSelectedItem();
	f=new FlowLayout(FlowLayout.CENTER);
	g=new GridLayout(7,2);
	y=new GridLayout(2,1);
	l1=new JLabel("Product Code*");
	l2=new JLabel("Category Code*");
	l3=new JLabel("Product Name");
	l4=new JLabel("Price");
	l5=new JLabel("Openeing Stock");
	l6=new JLabel("Units");
	t1=new JTextField(15);
	t2=new JTextField(10);
	t3=new JTextField(15);
	t4=new JTextField(15);
	t5=new JTextField(15);
	t6=new JTextField(8);
	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	p4=new JPanel();
	p5=new JPanel();
	p1.add(t1);
	p2.add(t2);
	p2.add(c1);
	p3.add(t3);
	p4.add(t4);
	p5.add(t5);
	c=new JComboBox();
	c.addItem("Kilogram");
	c.addItem("Meters");
	c.addItem("Piece");
	c.addItem("Litre");
	p12=new JPanel();
	p12.add(t6);
	p12.add(c);
	b1=new JButton("Save");
	b2=new JButton("Modify");
	b3=new JButton("Remove");
	b4=new JButton("Search");
	p6=new JPanel();
	p7=new JPanel();
	p8=new JPanel();
	p9=new JPanel();
	p6.add(b1);
	p7.add(b2);
	p8.add(b3);
	p9.add(b4);
	p10=new JPanel();
	p10.add(p6);
	p10.add(p7);
	p10.add(p8);
	p10.add(p9);
	p11=new JPanel(g);
	p11.add(l1);
	p11.add(p1);
	p11.add(l2);
	p11.add(p2);
	p11.add(l3);
	p11.add(p3);
	p11.add(l4);
	p11.add(p4);
	p11.add(l5);
	p11.add(p5);
	p11.add(l6);
	p11.add(p12);
	JPanel p14=new JPanel(y);
	p14.add(p11);
	p14.add(p10);
	p13=new JPanel(f);
	p13.add(p14);
	
	add(p13);

	c.addItemListener(this);
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	c1.addActionListener(this);
	t2.setEnabled(false);
	t2.setDisabledTextColor(Color.black);
	t6.setEnabled(false);
	t6.setDisabledTextColor(Color.black);
}
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
	
	m=(String) c1.getSelectedItem();
	t2.setText(m);
	if(arg0.getSource()==b1)
	{
		
		if(t1.getText().isEmpty())
			
		{
			JOptionPane.showMessageDialog(this, "Fill Product Code");
		}
		else if(t2.getText().isEmpty())
			
		{
			JOptionPane.showMessageDialog(this, "Fill Category Code");
		}
		else if(t3.getText().isEmpty())
			
		{
			JOptionPane.showMessageDialog(this, "Fill product Name");
		}
		else if(t4.getText().isEmpty())
			
		{
			JOptionPane.showMessageDialog(this, "Fill product price");
		}
		else if(t5.getText().isEmpty())
			
		{
			JOptionPane.showMessageDialog(this, "Set Opening Balance");
		}
		else if(t6.getText().isEmpty())
			
		{
			JOptionPane.showMessageDialog(this, "Select units");
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
				String sp1="select * from product where product_code=?";
				PreparedStatement ps1=con.prepareStatement(sp1);
				String s11=t1.getText();
				ps1.setString(1,s11);
				q=ps1.executeQuery();
				if(q.next())
				{
					JOptionPane.showMessageDialog(this, "Product code already exists");
				}
				else
				{
					String sp="insert into product values(?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(sp);
					String s1=t1.getText();
					String s2=t2.getText();
					String s3=t3.getText();
					String s4=t4.getText();
					String s5=t5.getText();
					String s6=t6.getText();
					ps.setString(1,s1);
					ps.setString(2,s2);
					ps.setString(3,s3);
					ps.setString(4,s4);
					ps.setString(5,s5);
					ps.setString(6,s6);
					ps.executeQuery();
					con.close();
					JOptionPane.showMessageDialog(this, "SAVED");
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
					t5.setText(null);
					t6.setText(null);
					
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this, "invalid category code");	
			}
		}
	
		}


	
	
	if(arg0.getSource()==b2)
	{
if(t1.getText().isEmpty())
			
		{
			JOptionPane.showMessageDialog(this, "Fill Product Code");
		}
		else if(t2.getText().isEmpty())
			
		{
			JOptionPane.showMessageDialog(this, "Fill Category Code");
		}
		else if(t3.getText().isEmpty())
			
		{
			JOptionPane.showMessageDialog(this, "Fill product Name");
		}
		else if(t4.getText().isEmpty())
			
		{
			JOptionPane.showMessageDialog(this, "Fill product price");
		}
		else if(t5.getText().isEmpty())
			
		{
			JOptionPane.showMessageDialog(this, "Set Opening Balance");
		}
		else if(t6.getText().isEmpty())
			
		{
			JOptionPane.showMessageDialog(this, "Select units");
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
				String sp1="select * from product where product_code=?";
				PreparedStatement ps1=con.prepareStatement(sp1);
				String s11=t1.getText();
				ps1.setString(1,s11);
				q=ps1.executeQuery();
				if(q.next())
				{
					String sp="update product set product_code=?, category_code=?, product_name=?, price=?, opening_balance=?, unit=?  where product_code=?";
					PreparedStatement ps=con.prepareStatement(sp);
					String s1=t1.getText();
					String s2=t2.getText();
					String s3=t3.getText();
					String s4=t4.getText();
					String s5=t5.getText();
					String s6=t6.getText();
					ps.setString(1,s1);
					ps.setString(2,s2);
					ps.setString(3,s3);
					ps.setString(4,s4);
					ps.setString(5,s5);
					ps.setString(6,s6);
					ps.setString(7,s1);
					ps.executeQuery();
					con.close();
					JOptionPane.showMessageDialog(this, "Modified");
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
					t5.setText(null);
					t6.setText(null);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Invalid product code");
				}
			}
			
			catch(Exception e)
			
			{
				JOptionPane.showMessageDialog(this, "Invalid Category code");	
				
			}
		
	}}
	// for remove button
	if(arg0.getSource()==b3)
	{
		if(t1.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"fill Product code");
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
			String sp1="select * from product where product_code=?";
			PreparedStatement ps1=con.prepareStatement(sp1);
			String s11=t1.getText();
			ps1.setString(1,s11);
			q=ps1.executeQuery();
			if(q.next())
			{
			String sp="delete product where product_code=?";
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
			t6.setText(null);}
			else
				{
				JOptionPane.showMessageDialog(this, "invalid product code");
				}
				}
		
		catch(Exception e)
		
		{
		//	JOptionPane.showMessageDialog(this, "category is not empty");
		e.printStackTrace();	
			
		}
		}
	}
	//for search button
	if(arg0.getSource()==b4)
	{
		if(t1.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"fill Product code");
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
				String sp1="select * from product where product_code=?";
				PreparedStatement ps1=con.prepareStatement(sp1);
				String s11=t1.getText();
				ps1.setString(1,s11);
				q=ps1.executeQuery();
				if(q.next())
				{
					String sp="select * from product where product_code=?";
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
						t2.setText(n1);
						t3.setText(n2);
						t4.setText(n3);
						t5.setText(n4);
						t6.setText(n5);
						con.close();
					}
				}
					else
					{
						JOptionPane.showMessageDialog(this, "invalid product code");
					}
			}
			catch(Exception e)
			{
			e.printStackTrace();	
			}
			
		}
}
	}

@Override
public void itemStateChanged(ItemEvent arg0) {
	// TODO Auto-generated method stub
String s=(String) c.getSelectedItem();
t6.setText(s);
}
public static void main(String a[])
{
product k=new product();
k.setSize(400,400);
k.setVisible(true);
}
}


