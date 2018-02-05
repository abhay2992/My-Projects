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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener{
JLabel l1,l2,l3,l4;
JTextField t1;
JPasswordField t2;
JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9;
JButton b1,b2;
GridLayout q,w;
FlowLayout f;
ResultSet l;
String sq;
public login()

{
	setTitle("login form/Inventory System/ NITIN JINDAL(B.tech CSE 3rd yr GNDU Amritsar) copyright protection");
	w=new GridLayout(3,1);
	q=new GridLayout(3,2);
	f=new FlowLayout(FlowLayout.CENTER);
	l1=new JLabel("Username");
	l2=new JLabel("Password");
	b2=new JButton("Sign up");
	t1=new JTextField(15);
	t2=new JPasswordField(15);
	b1=new JButton("Sign In");
	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	p4=new JPanel();
	p5=new JPanel(q);
	p6=new JPanel(f);
	p7=new JPanel(w);
	p8=new JPanel();
	
	p1.add(t1);
	p2.add(t2);
	p3.add(b1);
	p4.add(b2);
	p5.add(l1);
	p5.add(p1);
	p5.add(l2);
	p5.add(p2);
	p5.add(p4);
	p5.add(p3);
	p6.add(p5);
	p7.add(p8);
	p7.add(p6);
	add(p7);
	b1.addActionListener(this);
	b2.addActionListener(this);
	
}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
	if(arg0.getSource()==b1)
	{
		if(t1.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"fill username");
		}
		else if(t1.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"fill password");
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
			String s="select * from user_account where username=? and password=?";
			PreparedStatement ps=con.prepareStatement(s);
			String s1=t1.getText();
			ps.setString(1,s1);
			String s2=t2.getText();
			ps.setString(2,s2);
			
			l=ps.executeQuery();
			if(l.next())
			{
				inventory z=new inventory();
				z.setSize(400,300);
				z.setVisible(true);
				sq=t1.getText();
				this.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(this,"invalid username or password");
				t2.setText(null);
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}}
	if(arg0.getSource()==b2)
	{
		signup c=new signup();
		c.setSize(400,200);
		c.setVisible(true);
	}
}

public static void main (String a[])
{
	login z=new login();
	z.setSize(500,500);
	z.setVisible(true);
}

}
