import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class sale extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
	JButton b1,b2,b3,b4,sb1,sb2,sb3;
	JTextArea t14;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20;
	GridLayout g1,g2,g3;
	FlowLayout f;
	ResultSet q,r;
	JComboBox c1,c2;
	ArrayList al1,al2;
	@SuppressWarnings("deprecation")
	public sale()
	{
		setTitle("Sale/Inventory System/ NITIN JINDAL(B.tech CSE 3rd yr GNDU Amritsar) copyright protection");
		
		al1=new ArrayList();
		al2=new ArrayList();
		c1=new JComboBox();
		try
		{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection con=null;
		String str="jdbc:oracle:thin:@localhost:1521:";
		con=DriverManager.getConnection(str,"abhay","abhay");
		System.out.print("connection done");
		String sp1="select customer_firstname, customer_code from customer";
		PreparedStatement ps1=con.prepareStatement(sp1);
		//ps1.setString(1,sp1);
		r=ps1.executeQuery();
		System.out.print("1");
		while(r.next())
		{
		String aa=r.getString(1);
		c1.addItem(aa);
		String bb=r.getString(2);
		al1.add(bb);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		c2=new JComboBox();
		try
		{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection con=null;
		String str="jdbc:oracle:thin:@localhost:1521:";
		con=DriverManager.getConnection(str,"abhay","abhay");
		System.out.print("connection done");
		String sp1="select product_name, product_code from product";
		PreparedStatement ps1=con.prepareStatement(sp1);
		//ps1.setString(1,sp1);
		r=ps1.executeQuery();
		System.out.print("1");
		while(r.next())
		{
		String aa=r.getString(1);
		c2.addItem(aa);
		String bb=r.getString(2);
		al2.add(bb);
		
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		g1=new GridLayout(1,2);
		g2=new GridLayout(13,2);
		g3=new GridLayout(2,1);
		f=new FlowLayout(FlowLayout.CENTER);
		l1=new JLabel("Invoice Number");
		l2=new JLabel("       Date");
		l3=new JLabel("Customer Code");
		l4=new JLabel("Customer Name");
		l5=new JLabel("Company Name");
		l6=new JLabel("Contact Number");
		l7=new JLabel("Product Code");
		l8=new JLabel("Category code");
		l9=new JLabel("Product Name, Unit");
		l10=new JLabel("Price/Unit");
		l11=new JLabel("Quantity");
		l12=new JLabel("Amount");
		l13=new JLabel("Narration");
		
		t1=new JTextField(8);
		t2=new JTextField("DD-MMMM-YY",8);
		t3=new JTextField(9);
		t4=new JTextField(15);
		t5=new JTextField(15);
		t6=new JTextField(15);
		t7=new JTextField(9);
		t8=new JTextField(15);
		t9=new JTextField(15);
		t10=new JTextField(15);
		t11=new JTextField(15);
		t12=new JTextField(7);
		t14=new JTextArea(2,2);
		t13=new JTextField(15);
		
		sb1=new JButton("Get Details");
		sb2=new JButton("Get Details");
		sb3=new JButton("Amount");
		
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
		p13=new JPanel();
		p14=new JPanel(g1);
		p15=new JPanel(g1);
		p16=new JPanel();
		p17=new JPanel();
		p18=new JPanel();
		p19=new JPanel(g2);
		p20=new JPanel(g3);
		JPanel bc5=new JPanel();
		bc5.add(sb3);
		//p1.add(l1);
		p1.add(t1);
		//p2.add(l2);
		p2.add(t2);
		
		p3.add(t3);
		p3.add(c1);
		p4.add(t4);
		p5.add(t5);
		p6.add(t6);
		
		p7.add(t7);
		p7.add(c2);
		
		
		p8.add(t8);
		
		p9.add(t9);
		p10.add(t10);
		p11.add(t11);
		p12.add(t12);
		p12.add(sb3);
		p13.add(t13);
		
		p14.add(l1);
		p14.add(p1);
		p15.add(l2);
		p15.add(p2);
		
		p16.add(p3);
	//	p16.add(sb1);
		p17.add(p7);
	//	p17.add(sb2);
		
		JPanel bc1=new JPanel();
		bc1.add(b1);
		JPanel bc2=new JPanel();
		bc2.add(b2);
		JPanel bc3=new JPanel();
		bc3.add(b3);
		JPanel bc4=new JPanel();
		bc4.add(b4);
		
		p18.add(bc1);
		p18.add(bc2);
		p18.add(bc3);
		p18.add(bc4);
		
		p19.add(p14);
		p19.add(p15);
		p19.add(l3);
		p19.add(p16);
		p19.add(l4);
		p19.add(p4);
		p19.add(l5);
		p19.add(p5);
		p19.add(l6);
		p19.add(p6);
		p19.add(l7);
		p19.add(p17);
		p19.add(l8);
		p19.add(p8);
		p19.add(l9);
		p19.add(p9);
		p19.add(l10);
		p19.add(p10);
		p19.add(l11);
		p19.add(p11);
		p19.add(l12);
		p19.add(p12);
		p19.add(l13);
		p19.add(p13);
		p20.add(p19);
		p20.add(p18);
		JPanel p21=new JPanel(f);
		p21.add(p20);
		add(p21);
		
		t7.addActionListener(this);
		sb3.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		t3.addActionListener(this);
		c1.addActionListener(this);
		c2.addActionListener(this);
		t4.setDisabledTextColor(Color.BLACK);
		t4.setEnabled(false);
		t3.setDisabledTextColor(Color.BLACK);
		t3.setEnabled(false);
		t7.setDisabledTextColor(Color.BLACK);
		t7.setEnabled(false);
		t5.setDisabledTextColor(Color.BLACK);
		t5.setEnabled(false);

		t6.setEnabled(false);
		t6.setDisabledTextColor(Color.BLACK);
		t8.setDisabledTextColor(Color.BLACK);
		t8.setEnabled(false);
		t9.setDisabledTextColor(Color.BLACK);
		t9.setEnabled(false);

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String m=(String) c1.getSelectedItem();
		t3.setText(m);
		String n=(String) c2.getSelectedItem();
		t7.setText(n);
		if(arg0.getSource()==sb3)
		{
			if(t10.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill Price/unit");
			}
			else if(t11.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill Price/unit");
			}
			else
			{
				String s1=t10.getText();
				String s2=t11.getText();
				int i,j,k;
				i=Integer.parseInt(s1);
				j=Integer.parseInt(s2);
				k=i*j;
				String s3=String.valueOf(k);
				t12.setText(s3);
			}
		}
		if(arg0.getSource()==c1)
		{
			try
			{
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection con=null;
				String str="jdbc:oracle:thin:@localhost:1521:";
				con=DriverManager.getConnection(str,"abhay","abhay");
				System.out.print("connection done");
				String sp1="select * from customer where customer_code=?";
				PreparedStatement ps1=con.prepareStatement(sp1);
				int u= c1.getSelectedIndex();
				String s1=(String)al1.get(u);
				ps1.setString(1,s1);
				q=ps1.executeQuery();
				if(q.next())
				{
					String s2=q.getString(2);
					String s3=q.getString(4);
					String s4=q.getString(6);
					String s5=q.getString(7);
					String s6=s4+", "+s5;
					t4.setText(s2);
					t5.setText(s3);
					t6.setText(s6);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"invalid customer code");
				}	
			}
			catch(Exception e)
			{
				e.printStackTrace();	
			}
			}
		if(arg0.getSource()==c2)
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
				int u= c2.getSelectedIndex();
				String s1=(String)al2.get(u);
				ps1.setString(1,s1);
				q=ps1.executeQuery();
				if(q.next())
				{
					String s2=q.getString(2);
					String s3=q.getString(3);
					String s4=q.getString(6);
					String s5=s3;
					t8.setText(s2);
					t9.setText(s5);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"invalid product code");
				}	
			}
			catch(Exception e)
			{
				e.printStackTrace();	
			}
		}
		if(arg0.getSource()==b1)
		{
			if(t1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill Invoice Number");
			}
			else if(t2.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill Date");
			}
			else if(t3.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill customer Details");
			}
			else if(t7.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill Product Details");
			}
			else if(t10.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Price/Unit");
			}
			else if(t11.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill Quantity");
			}
			else if(t12.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill Amount");
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
				String sp1="select * from sale where invoice_number=?";
				PreparedStatement ps1=con.prepareStatement(sp1);
				String s1=t1.getText();
				ps1.setString(1,s1);
				q=ps1.executeQuery();
				if(q.next())
				{
					JOptionPane.showMessageDialog(this,"invalid Invoice Number");
				}
				else
				{
					String sp2="insert into sale values(?,?,?,?,?,?,?,?)";
					PreparedStatement ps2=con.prepareStatement(sp2);
					String s2=t1.getText();
					String s3=t2.getText();
					String s4=t3.getText();
					String s5=t7.getText();
					String s6=t10.getText();
					String s7=t11.getText();
					String s8=t12.getText();
					String s9=t13.getText();
					ps2.setString(1,s2);
					ps2.setString(2,s3);
					ps2.setString(3,s4);
					ps2.setString(4,s5);
					ps2.setString(5,s6);
					ps2.setString(6,s7);
					ps2.setString(7,s8);
					ps2.setString(8,s9);
					ps2.executeQuery();
					con.close();
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
					t5.setText(null);
					t6.setText(null);
					t7.setText(null);
					t8.setText(null);
					t9.setText(null);
					t10.setText(null);
					t11.setText(null);
					t12.setText(null);
					t13.setText(null);
					t14.setText(null);
					
				}
			}
				catch (Exception e)
				{
				e.printStackTrace();	
				}
				}
		}
		if(arg0.getSource()==b2)
		{
			if(t1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill Invoice Number");
			}
			else if(t2.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill Date");
			}
			else if(t3.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill customer Details");
			}
			else if(t7.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill Product Details");
			}
			else if(t10.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Price/Unit");
			}
			else if(t11.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill Quantity");
			}
			else if(t12.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill Amount");
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
				String sp1="select * from sale where invoice_number=?";
				PreparedStatement ps1=con.prepareStatement(sp1);
				String s1=t1.getText();
				ps1.setString(1,s1);
				q=ps1.executeQuery();
				if(q.next())
				{
					String sp2="update sale set date_=?, customer_code=?, product_code=?, price_unit=?, quantity=?, amount=?, narration=? where invoice_number=?";
					PreparedStatement ps2=con.prepareStatement(sp2);
					String s2=t1.getText();
					String s3=t2.getText();
					String s4=t3.getText();
					String s5=t7.getText();
					String s6=t10.getText();
					String s7=t11.getText();
					String s8=t12.getText();
					String s9=t13.getText();
					ps2.setString(1,s3);
					ps2.setString(2,s4);
					ps2.setString(3,s5);
					ps2.setString(4,s6);
					ps2.setString(5,s7);
					ps2.setString(6,s8);
					ps2.setString(7,s9);
					ps2.setString(8,s2);
					ps2.executeQuery();
					
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
					t5.setText(null);
					t6.setText(null);
					t7.setText(null);
					t8.setText(null);
					t9.setText(null);
					t10.setText(null);
					t11.setText(null);
					t12.setText(null);
					t13.setText(null);
					t14.setText(null);
				}
				else
				{
					
					JOptionPane.showMessageDialog(this, "Invalid invoice number");
				}
				con.close();
			}
				catch (Exception e)
				{
				e.printStackTrace();	
				}
				}
		}	
		if(arg0.getSource()==b3)
		{
			if(t1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Fill Invoice Number");
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
					String sp1="select * from sale where invoice_number=?";
					PreparedStatement ps1=con.prepareStatement(sp1);
					String s11=t1.getText();
					ps1.setString(1,s11);
					q=ps1.executeQuery();
					if(q.next())
					{
					String sp="delete sale where invoice_number=?";
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
					t8.setText(null);
					t9.setText(null);
					t10.setText(null);
					t11.setText(null);
					t12.setText(null);
					t13.setText(null);
					t14.setText(null);
								
				}
					else
						{
						JOptionPane.showMessageDialog(this,"Invoice Number doesn't exsist");
						}
						}
			
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}

		}
		if(arg0.getSource()==b4)
		{
			if(t1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill invoice number");
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
					String sp1="select * from sale where invoice_number=?";
					PreparedStatement ps1=con.prepareStatement(sp1);
					String s11=t1.getText();
					ps1.setString(1,s11);
					q=ps1.executeQuery();
					if(q.next())
					{
						String sp="select * from sale where invoice_number=?";
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
							t7.setText(n3);
							t10.setText(n4);
							t11.setText(n5);
							t12.setText(n6);
							t13.setText(n7);
							
						}
					}
						else
						{
							JOptionPane.showMessageDialog(this, "invalid Invoice Number");
						}
					con.close();
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
		sale k=new sale();
		k.setSize(800,1000);
		k.setVisible(true);
	}
}
