import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
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


public class category extends JFrame implements ActionListener{
	JButton b1,b2,b3,b4,lo;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,lop;
	JLabel l1,l2;
	JTextField t1,t2;
	GridLayout g,h;
	FlowLayout f;
	ResultSet q;
	category c;
	public category()
	{
		setTitle("category/Inventory System/ NITIN JINDAL(B.tech CSE 3rd yr GNDU Amritsar) copyright protection");
		lo=new JButton("Sign Out");
		lop=new JPanel();
		lop.add(lo);
		
		f=new FlowLayout(FlowLayout.CENTER);
		h=new GridLayout(3,1);
		g=new GridLayout(2,2);
		b1=new JButton("Save");
		b2=new JButton("Modify");
		b3=new JButton("remove");
		b4=new JButton("search");
		l1=new JLabel("category code*");
		l2=new JLabel("category name");
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
		p5.add(lop);
		add(p11);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		lo.addActionListener(this);
		
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		
		
		if(arg0.getSource()==b1)
		{
			if(t1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill Category code");
			}
			else if(t2.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill name");
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
			String sp="insert into category values(?,?)";
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
			JOptionPane.showMessageDialog(this, "category code already exsist");	
			
		}
		}}
		
		if(arg0.getSource()==b2)
		{
			if(t1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill Category code");
			}
			else if(t2.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill name");
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
			
			String sp1="select * from category where category_code=?";
			PreparedStatement ps1=con.prepareStatement(sp1);
			String s11=t1.getText();
			ps1.setString(1,s11);
			q=ps1.executeQuery();
			if(q.next())
			{
				String sp="update category set category_name=? where category_code=?";
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
				JOptionPane.showMessageDialog(this, "Invalid Category code");
					}
			
		}
		
		catch(Exception e)
		
		{
			JOptionPane.showMessageDialog(this, "invalid Category code");	
			
		}
		}}
		if(arg0.getSource()==b3)
		{
			if(t1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill Category code");
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
			String sp1="select * from category where category_code=?";
			PreparedStatement ps1=con.prepareStatement(sp1);
			String s11=t1.getText();
			ps1.setString(1,s11);
			q=ps1.executeQuery();
			if(q.next())
			{
			String sp="delete category where category_code=?";
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
				JOptionPane.showMessageDialog(this, "invalid category code");
				}
				}
		
		catch(Exception e)
		
		{
			JOptionPane.showMessageDialog(this, "invalid category code");
			e.printStackTrace();	
			
		}
		}}
		if(arg0.getSource()==b4)
		{
			if(t1.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"fill Category code");
			}
			else{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=null;
			String str="jdbc:oracle:thin:@localhost:1521:";
			con=DriverManager.getConnection(str,"abhay","abhay");
			System.out.print("connection done");
			String sp1="select * from category where category_code=?";
			PreparedStatement ps1=con.prepareStatement(sp1);
			String s11=t1.getText();
			ps1.setString(1,s11);
			q=ps1.executeQuery();
			if(q.next())
			{
			String sp="select * from category where category_code=?";
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
				JOptionPane.showMessageDialog(this, "invalid category code");
			}
			}
		
		catch(Exception e)
		
		{
		e.printStackTrace();	
			
		}
		}
		}	
		if(arg0.getSource()==lo)
	{
		this.dispose();
		login k=new login();
		k.setSize(800,800);
		k.setVisible(true);
		System.out.print("true");
		//k.setVisible(false);
	}}
	public static void main(String a[])
{
	category c=new category();
	c.setSize(400,200);
	c.setVisible(true);
	
}
}
