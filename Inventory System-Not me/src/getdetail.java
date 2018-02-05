import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class getdetail extends JFrame implements ActionListener{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9 ;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14;
ResultSet q,r;
GridLayout g;
FlowLayout f;


	public getdetail()
	{
		setTitle("get Detail/Inventory System/ NITIN JINDAL(B.tech CSE 3rd yr GNDU Amritsar) copyright protection");
		g=new GridLayout(8,2);
		f=new FlowLayout(FlowLayout.CENTER);
		l1=new JLabel("product code");
		l2=new JLabel("category code");
		l3=new JLabel("product name");
		l4=new JLabel("unit");
		l5=new JLabel("opening stock");
		l6=new JLabel("total purchase");
		l7=new JLabel("total sale");
		l8=new JLabel("Balance");
		t1=new JTextField(15);
		t2=new JTextField(15);
		t3=new JTextField(15);
		t4=new JTextField(15);
		t5=new JTextField(15);
		t6=new JTextField(15);
		t7=new JTextField(15);
		t8=new JTextField(15);
		
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();
		p9=new JPanel();
		p10=new JPanel();
		p7=new JPanel(g);
		p8=new JPanel(f);
		p1.add(t1);
		p2.add(t2);
		p3.add(t3);
		p4.add(t4);
		p5.add(t5);
		p6.add(t6);
		p9.add(t7);
		p10.add(t8);
		
		p7.add(l1);
		p7.add(p1);
		p7.add(l2);
		p7.add(p2);
		p7.add(l3);
		p7.add(p3);
		p7.add(l4);
		p7.add(p4);
		p7.add(l5);
		p7.add(p5);
		p7.add(l6);
		p7.add(p6);
		p7.add(l7);
		p7.add(p9);
		p7.add(l8);
		p7.add(p10);
		
		
		p8.add(p7);
		add(p8);
		t1.addActionListener(this);
		t2.disable();
		t2.setDisabledTextColor(Color.BLACK);
		t3.disable();
		t3.setDisabledTextColor(Color.BLACK);
		t4.disable();
		t4.setDisabledTextColor(Color.BLACK);
		t5.disable();
		t5.setDisabledTextColor(Color.BLACK);
	/*	t6.disable();
		t6.setDisabledTextColor(Color.BLACK);
		t7.disable();
		t7.setDisabledTextColor(Color.BLACK);
		t8.disable();
		t8.setDisabledTextColor(Color.BLACK);
	*/}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(t1.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"fill product code");
		}
		else if(arg0.getSource()==t1)
		{
			try
			{
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection con=null;
				String str="jdbc:oracle:thin:@localhost:1521:";
				con=DriverManager.getConnection(str,"abhay","abhay");
				System.out.print("connection done");
				String s="select * from product where product_code=?";
				PreparedStatement ps=con.prepareStatement(s);
				String s1=t1.getText();
				ps.setString(1,s1);
				q=ps.executeQuery();
				if(q.next())
				{
					String s2=q.getString(2);
					String s3=q.getString(3);
					String s4=q.getString(5);
					String s5=q.getString(6);
					t2.setText(s2);
					t3.setText(s3);
					t4.setText(s5);
					t5.setText(s4);
					try
					{
						String s6="select sum(quantity) as qty from purchase where product_code=?";
						PreparedStatement ps1=con.prepareStatement(s6);
						System.out.print("purchase");
						String s7=t1.getText();
						ps1.setString(1,s7);
						r=ps1.executeQuery();
						System.out.print("1");
						if(r.next())
						{
							System.out.print("2");
							String s8=r.getString("qty");
							t6.setText(s8);
						}
						else
						{
							JOptionPane.showMessageDialog(this,"no purchase entry");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				
					try
					{
					String s9="select sum(quantity) as qty from sale where product_code=?";
					PreparedStatement ps2=con.prepareStatement(s9);
					String s10=t1.getText();
					ps2.setString(1,s10);
					System.out.print("3");
					q=ps2.executeQuery();
					if(q.next())
					{
						String s11=q.getString("qty");
						t7.setText(s11);
						System.out.print("4");
					}
					else
					{
						JOptionPane.showMessageDialog(this,"no sale entry");
					}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
			
					int i,j,k,l;
					i=Integer.parseInt(s4);
					
					String s12=t6.getText();
					String s13=t7.getText();
					j=Integer.parseInt(s12);
					k=Integer.parseInt(s13);
					l=i+j-k;
					String s14=String.valueOf(l);
					t8.setText(s14);
					System.out.print("5");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"product code doesn't exsist");
				}
				con.close();
			}
			catch(Exception e)
			{
				
			}
		}
		
	}

}
